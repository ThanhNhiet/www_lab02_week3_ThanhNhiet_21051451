package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DsConfig {
    @Bean
    @Scope("singleton")
    public DataSource mariadbDataSource() throws Throwable{
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/recuitmentdb");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
