package com.solvedbysunrise.wastedtime.service;

import com.google.common.collect.Lists;
import com.solvedbysunrise.wastedtime.data.dao.WastedTimeDao;
import com.solvedbysunrise.wastedtime.data.dto.WastedTime;
import com.solvedbysunrise.wastedtime.data.jpa.WastedTimeEvent;
import com.solvedbysunrise.wastedtime.data.factory.BeanCopyWastedTimeFactory;
import com.solvedbysunrise.wastedtime.data.factory.WastedTimeFactory;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EntityMappingWastedTimeServiceTest {

    private static final String WHO = "Arran";
    private static final Duration DURATION = Duration.standardMinutes(30);
    private static final String ACTIVITY = "This app";
    private static final DateTime DATE_TIME = DateTime.now();
    private static final WastedTime WASTED_TIME = new WastedTime(WHO, DURATION, ACTIVITY, DATE_TIME);

    @Mock
    private WastedTimeDao wastedTimeDao;

    @Mock
    private WastedTimeFactory wastedTimeFactory;

    @InjectMocks
    private EntityMappingWastedTimeService entityMappingWastedTimeService;

    @Before
    public void setupMocks() {
        WastedTimeEvent event = (new BeanCopyWastedTimeFactory()).fromDto(WASTED_TIME);
        when(wastedTimeFactory.fromDto(WASTED_TIME)).thenReturn(event);
        when(wastedTimeDao.save(event)).thenReturn(event);
        when(wastedTimeDao.findAll()).thenReturn(Lists.newArrayList(event));
        when(wastedTimeFactory.fromEntity(event)).thenReturn(WASTED_TIME);
    }

    @Test
    public void recordWastedTime_will_return_events_including_the_one_recorded() throws Exception {
        Collection<WastedTime> wastedTimes = entityMappingWastedTimeService.recordWastedTime(WASTED_TIME);
        assertThat(wastedTimes, hasItem(WASTED_TIME));
    }

    @Test
    public void getAllWastedTime_will_return_all_events() throws Exception {
        Collection<WastedTime> wastedTimes = entityMappingWastedTimeService.getAllWastedTime();
        assertThat(wastedTimes, hasItem(WASTED_TIME));
    }

}