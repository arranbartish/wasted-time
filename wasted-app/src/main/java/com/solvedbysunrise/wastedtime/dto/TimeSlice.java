package com.solvedbysunrise.wastedtime.dto;

import com.solvedbysunrise.bean.RefelctiveBean;
import org.joda.time.Duration;

public class TimeSlice extends RefelctiveBean {

    private final Duration slice;
    private final String display;

    public TimeSlice(Duration slice, String display) {
        this.slice = slice;
        this.display = display;
    }

    public Duration getSlice() {
        return slice;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String[] excludedFields() {
        return new String[] {"slice"};
    }

    @Override
    public boolean equals(Object that) {
        return super.equals(that) && internalEquals((TimeSlice) that);
    }

    private boolean internalEquals(TimeSlice that) {
        return that.getSlice().isEqual(this.getSlice());
    }
}
