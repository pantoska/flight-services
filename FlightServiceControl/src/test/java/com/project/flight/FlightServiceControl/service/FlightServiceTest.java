package com.project.flight.FlightServiceControl.service;

import com.project.flight.entity.FlightEntity;
import com.project.flight.error.NotFoundException;
import com.project.flight.repository.FlightRepository;
import com.project.flight.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Not;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private FlightEntity entity;

    @InjectMocks
    private FlightService service;


    @Before
    public void init(){
        entity.setId("1");
        entity.setLatitude(55);
        entity.setLongitude(66);
    }

    @Test
    public void updateFlight(){

        given(flightRepository.findById(entity.getId())).willReturn(Optional.ofNullable(entity));

        service.updateFlight(entity);

        then(flightRepository)
                .should(times(1))
                .save(entity);

    }

    @Test(expected = NotFoundException.class)
    public void updateFlightExceptionTest(){
        given(flightRepository.findById(entity.getId())
                .orElseThrow(() -> new NotFoundException("Not found ID")))
                .willThrow(new Exception(""));

        service.updateFlight(entity);

        then(flightRepository)
                .should(never())
                .save(entity);

    }


}
