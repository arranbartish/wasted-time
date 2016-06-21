package com.solvedbysunrise.wastedtime.controller;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

public class CSVFormatter {


    private String dateFormat;

    private String durationFormat;

    public CSVFormatter() {
        dateFormat = "yyyy-mmm-dd";
        durationFormat = "mmm";
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String getDurationFormat() {
        return durationFormat;
    }
}
