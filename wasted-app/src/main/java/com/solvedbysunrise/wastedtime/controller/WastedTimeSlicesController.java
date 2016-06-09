package com.solvedbysunrise.wastedtime.controller;

import com.solvedbysunrise.wastedtime.data.dto.TimeSlice;
import com.solvedbysunrise.wastedtime.data.dto.WastedTime;
import com.solvedbysunrise.wastedtime.service.TimeSliceService;
import com.solvedbysunrise.wastedtime.service.WastedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/time-slices",
        consumes = APPLICATION_JSON_UTF8_VALUE,
        produces = APPLICATION_JSON_UTF8_VALUE)
public class WastedTimeSlicesController {

    private final TimeSliceService timeSliceService;

    @Autowired
    public WastedTimeSlicesController(final TimeSliceService timeSliceService) {
        this.timeSliceService = timeSliceService;
    }

    @RequestMapping(method = GET)
    public TimeSlice[] wastedTimeSlices() {
        return timeSliceService.getTimeSlices();
    }
}
