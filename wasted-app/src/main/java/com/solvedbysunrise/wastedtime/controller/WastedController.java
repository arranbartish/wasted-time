package com.solvedbysunrise.wastedtime.controller;

import com.solvedbysunrise.wastedtime.dto.WastedTime;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

@RestController
public class WastedController {

    @RequestMapping(method = RequestMethod.POST, name = "/wasted")
    public Collection<WastedTime> wastedTime(@RequestBody @Valid WastedTime wastedTime) {
        return newArrayList(wastedTime);
    }

    @RequestMapping(method = RequestMethod.GET, name = "/wasted")
    public Collection<WastedTime> wastedTime() {
        return newArrayList(new WastedTime(null, null, null, null));
    }
}
