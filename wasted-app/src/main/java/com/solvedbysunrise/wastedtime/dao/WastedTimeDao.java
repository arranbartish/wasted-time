package com.solvedbysunrise.wastedtime.dao;

import com.solvedbysunrise.wastedtime.entity.jpa.WastedTimeEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WastedTimeDao extends PagingAndSortingRepository<WastedTimeEvent, String> {

}
