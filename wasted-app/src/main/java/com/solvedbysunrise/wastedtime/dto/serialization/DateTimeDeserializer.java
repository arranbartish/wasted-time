package com.solvedbysunrise.wastedtime.dto.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class DateTimeDeserializer extends JsonDeserializer<DateTime> {

    @Override
    public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (isBlank(p.getValueAsString())) {
            return null;
        }
        long valueAsLong = p.getValueAsLong();
        return new DateTime(valueAsLong);
    }


}
