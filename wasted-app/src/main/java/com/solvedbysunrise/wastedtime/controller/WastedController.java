package com.solvedbysunrise.wastedtime.controller;

import com.solvedbysunrise.wastedtime.dto.WastedTime;
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
@RequestMapping(value = "/wasted",
        consumes = APPLICATION_JSON_UTF8_VALUE,
        produces = APPLICATION_JSON_UTF8_VALUE)
public class WastedController {

    private final WastedTimeService wastedTimeService;

    @Autowired
    public WastedController(final WastedTimeService wastedTimeService) {
        this.wastedTimeService = wastedTimeService;
    }

    @RequestMapping(method = POST)
    public Collection<WastedTime> wastedTime(@Valid @RequestBody WastedTime wastedTime) {
        return wastedTimeService.recordWastedTime(wastedTime);
    }

    @RequestMapping(method = GET)
    public Collection<WastedTime> wastedTime() {
        return wastedTimeService.getAllWastedTime();
    }
}
