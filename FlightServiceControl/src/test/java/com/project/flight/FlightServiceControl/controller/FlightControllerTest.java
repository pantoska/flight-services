package com.project.flight.FlightServiceControl.controller;

import com.project.flight.controller.FlightsController;
import com.project.flight.dto.FlightDto;
import com.project.flight.entity.FlightEntity;
import com.project.flight.error.NotFoundException;
import com.project.flight.repository.FlightRepository;
import com.project.flight.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private FlightService flightService;

    @Mock
    private FlightEntity entity;


    @Before
    public void setup() {
        entity.setId("1");
        entity.setLatitude(55);
        entity.setLongitude(66);
    }

    @Test
    public void getFlightTest() throws Exception {
        given(flightService.getFlight(entity.getId())).willReturn(entity);
        this.mvc.perform(get("/api/flights/" + entity.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void getFlightExceptionTest() throws Exception {
        FlightRepository flightRepository = Mockito.mock(FlightRepository.class);
        given(flightService.getFlight(anyString())).willThrow(new NotFoundException(""));
        this.mvc.perform(get("/api/flights/" + entity.getId()))
                .andExpect(status().isNotFound());
    }






}
