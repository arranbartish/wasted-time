package com.solvedbysunrise.wastedtime.config;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Collection;

public interface WastedTimeConfiguration {

    String wastedTimeUrl();

    String wastedTimeBaseUrl();

    String testValue();

    Collection<Pair<String, String>> config();

}
