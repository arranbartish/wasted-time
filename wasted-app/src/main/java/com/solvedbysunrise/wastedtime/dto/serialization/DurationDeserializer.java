package com.solvedbysunrise.wastedtime.dto.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.Duration;

import java.io.IOException;

public class DurationDeserializer extends JsonDeserializer<Duration> {

    @Override
    public Duration deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        long valueAsLong = p.getValueAsLong();
        return Duration.millis(valueAsLong);
    }
}
