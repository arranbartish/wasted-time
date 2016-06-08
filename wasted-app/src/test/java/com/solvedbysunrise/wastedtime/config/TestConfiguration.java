package com.solvedbysunrise.wastedtime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import static com.google.common.collect.Lists.newArrayList;

public class TestConfiguration extends ProductionConfiguration {

    private static final String BASE_URL = "http://localhost:8080/";

    @Override
    @Bean(name = "wastedTimeBaseUrl")
    public String wastedTimeBaseUrl(){
        return BASE_URL;
    }

}
