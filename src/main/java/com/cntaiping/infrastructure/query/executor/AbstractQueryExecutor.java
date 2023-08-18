package com.cntaiping.infrastructure.query.executor;

import cn.hutool.core.collection.CollectionUtil;
import com.cntaiping.infrastructure.query.enums.QueryStrategyEnum;
import com.cntaiping.infrastructure.query.param.QueryParam;

import java.util.Set;

public abstract class AbstractQueryExecutor<T> {
    public abstract T query(QueryParam queryParam);

    public abstract Set<QueryStrategyEnum> matchQuerySource();

    public boolean matchQuerySource(QueryStrategyEnum queryEnum){
        return CollectionUtil.contains(matchQuerySource(),queryEnum);
    }
}
