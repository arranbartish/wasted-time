package com.solvedbysunrise.wastedtime.data.dao;

import com.solvedbysunrise.wastedtime.data.entity.jpa.WastedTimeEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WastedTimeDao extends PagingAndSortingRepository<WastedTimeEvent, Long> {

}
