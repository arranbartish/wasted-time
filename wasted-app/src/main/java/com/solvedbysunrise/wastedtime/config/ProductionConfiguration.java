package com.solvedbysunrise.wastedtime.config;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang3.tuple.Pair.of;

public class ProductionConfiguration implements WastedTimeConfiguration {

    @Value("${baseUrl:http://localhost:8080/}")
    private String baseUrl;

    @Value("${DATABASE_URL:did-not-resolve}")
    private String databaseUrl;

    @Value("${testValue:also-did-not-work}")
    private String testValue;

    @Override
    @Bean(name = "wastedTimeBaseUrl")
    public String wastedTimeBaseUrl() {
        return baseUrl;
    }

    @Override
    @Bean(name = "wastedTimeUrl")
    public String wastedTimeUrl() {
        return databaseUrl;
    }

    @Override
    @Bean(name = "testValue")
    public String testValue() {
        return testValue;
    }

    @Override
    @Bean(name = "config")
    public Collection<Pair<String, String>> config() {
        return newArrayList(
                of("database", wastedTimeUrl()),
                of("url", wastedTimeBaseUrl()),
                of("test", testValue()));
    }

}
