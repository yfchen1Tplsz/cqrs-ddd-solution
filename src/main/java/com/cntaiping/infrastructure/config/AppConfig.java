package com.cntaiping.infrastructure.config;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public SQLQueryFactory sqlQueryFactory(DataSource dataSource){
        SQLTemplates pgyTemplate = new PostgreSQLTemplates();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(pgyTemplate);
        return  new SQLQueryFactory(configuration,dataSource);
    }
}
