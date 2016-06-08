package com.solvedbysunrise.wastedtime.controller;

import com.google.common.collect.Lists;
import com.solvedbysunrise.wastedtime.dto.WastedTime;
import com.solvedbysunrise.wastedtime.service.WastedTimeService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WastedControllerTest {

    @Mock
    private WastedTime wastedTime;

    @Mock
    private WastedTimeService wastedTimeService;

    @InjectMocks
    private WastedController wastedController;

    @Test
    public void wastedTime_will_return_list_when_recording() throws Exception {
        when(wastedTimeService.recordWastedTime(wastedTime)).thenReturn(Lists.newArrayList(wastedTime));
        Collection<WastedTime> wastedTimes = wastedController.wastedTime(wastedTime);
        assertThat(wastedTimes, contains(wastedTime));
    }

    @Test
    public void wastedTime_will_return_list_when_requested() throws Exception {
        when(wastedTimeService.getAllWastedTime()).thenReturn(Lists.newArrayList(wastedTime));
        Collection<WastedTime> wastedTimes = wastedController.wastedTime();
        assertThat(wastedTimes, contains(wastedTime));

    }

}