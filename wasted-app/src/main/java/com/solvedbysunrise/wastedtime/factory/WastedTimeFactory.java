package com.solvedbysunrise.wastedtime.factory;

import com.solvedbysunrise.wastedtime.dto.WastedTime;
import com.solvedbysunrise.wastedtime.entity.jpa.WastedTimeEvent;

public interface WastedTimeFactory {


    WastedTimeEvent fromDto (WastedTime wastedTime);

    WastedTime fromEntity (WastedTimeEvent wastedTimeEvent);
}
