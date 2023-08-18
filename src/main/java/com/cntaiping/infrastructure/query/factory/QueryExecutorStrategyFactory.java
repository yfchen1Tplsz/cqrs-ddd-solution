package com.cntaiping.infrastructure.query.factory;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.cntaiping.infrastructure.exception.ApplicationException;
import com.cntaiping.infrastructure.query.enums.QueryStrategyEnum;
import com.cntaiping.infrastructure.query.executor.AbstractQueryExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@Slf4j
public class QueryExecutorStrategyFactory {
    private final List<AbstractQueryExecutor> executorList;
    private static final ConcurrentMap<String,AbstractQueryExecutor> STRATEGY_MAP = new ConcurrentHashMap<>();

    public QueryExecutorStrategyFactory(List<AbstractQueryExecutor> executorList){
        this.executorList = executorList;
        initStrategyMap();
    }

    private void initStrategyMap() {
        if(CollectionUtil.isEmpty(executorList)){
            return;
        }
        executorList.stream().forEach(k->{
            Arrays.stream(QueryStrategyEnum.values()).forEach(v->{
                if(k.matchQuerySource(v)){
                    if( STRATEGY_MAP.get(v.type()) != null){
                        String errMsg = StrUtil.format("multi strategy for queryExecutor: {}, strategy1: {}, strategy2: {}", v.code(),  STRATEGY_MAP.get(v.type()), k);
                        log.info(errMsg);
                        throw new IllegalArgumentException("策略map加载失败，存在相同策略的查询");
                    }
                    STRATEGY_MAP.put(v.type(),k);
                }
            });
        });
    }

    public static AbstractQueryExecutor queryExecutor(QueryStrategyEnum strategy){
        return STRATEGY_MAP.get(strategy.type());
    }
}
