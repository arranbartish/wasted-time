package com.solvedbysunrise.wastedtime.data.factory;

import com.solvedbysunrise.wastedtime.data.dto.WastedTime;
import com.solvedbysunrise.wastedtime.data.jpa.WastedTimeEvent;

public interface WastedTimeFactory {


    WastedTimeEvent fromDto (WastedTime wastedTime);

    WastedTime fromEntity (WastedTimeEvent wastedTimeEvent);
}
