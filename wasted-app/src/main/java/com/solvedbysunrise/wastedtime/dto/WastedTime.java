package com.solvedbysunrise.wastedtime.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.solvedbysunrise.bean.RefelctiveBean;
import com.solvedbysunrise.wastedtime.dto.serialization.DateTimeDeserializer;
import com.solvedbysunrise.wastedtime.dto.serialization.DateTimeSerializer;
import com.solvedbysunrise.wastedtime.dto.serialization.DurationDeserializer;
import com.solvedbysunrise.wastedtime.dto.serialization.DurationSerializer;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import javax.validation.constraints.NotNull;

public class WastedTime extends RefelctiveBean {

    @NotEmpty
    private final String who;

    @JsonDeserialize(using = DurationDeserializer.class)
    @JsonSerialize(using = DurationSerializer.class)
    @NotNull
    private final Duration duration;

    @NotEmpty
    private final String activity;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @JsonSerialize(using = DateTimeSerializer.class)
    @NotNull
    private final DateTime date;

    @JsonCreator
    public WastedTime(@JsonProperty("who") String who,
                      @JsonProperty("duration") Duration duration,
                      @JsonProperty("activity") String activity,
                      @JsonProperty("date") DateTime date) {
        this.who = who;
        this.duration = duration;
        this.activity = activity;
        this.date = (date == null) ? null : new DateTime(date).withTimeAtStartOfDay();
    }

    public String getWho() {
        return who;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getActivity() {
        return activity;
    }

    public DateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object that) {
        return super.equals(that) && internalEquals((WastedTime) that);
    }

    private boolean internalEquals(WastedTime that) {
        return that.getDate().isEqual(this.getDate())
                && that.getDuration().isEqual(this.getDuration());
    }

    @Override
    public String[] excludedFields() {
        return new String[] { "date", "duration" };
    }
}
