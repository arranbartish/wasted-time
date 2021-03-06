package com.solvedbysunrise.wastedtime.service;

import com.solvedbysunrise.wastedtime.data.dto.WastedTime;

import java.util.Collection;

public interface WastedTimeService {

    Collection<WastedTime> recordWastedTime(WastedTime wastedTime);

    Collection<WastedTime> getAllWastedTime();

    Collection<String> getAllWastedTimeActivities();

    Collection<String> getEveryoneWhoHasWastedTime();
}
