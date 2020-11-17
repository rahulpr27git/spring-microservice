package com.springcloud.reservationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.reservationservice.resource.model.Reservation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationControllerTest {

        private final static Logger LOGGER = LoggerFactory.getLogger(ReservationControllerTest.class);

        @Autowired
        MockMvc mockMvc;

        @Test
        void testCreateReservation() throws Exception {

            ObjectMapper mapper = new ObjectMapper();

            Reservation reservation = new Reservation(
                    3,
                    4,
                    "10:00",
                    "20:00"
            );

            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/reservations")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(reservation));

            MockHttpServletResponse response = mockMvc.perform(request)
                    .andReturn()
                    .getResponse();

            String body = response.getContentAsString();
            LOGGER.info("### testCreateEmployee ### Response: {}", body);

            // Testing status code
            assertEquals(response.getStatus(), 201);
        }

        @Test
        void testDeleteById() throws Exception {
            ObjectMapper mapper = new ObjectMapper();

            Reservation reservation = new Reservation(
                    3,
                    4,
                    "10:00",
                    "20:00"
            );

            MockHttpServletRequestBuilder requestReservation = MockMvcRequestBuilders.post("/api/v1/reservations")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(reservation));

            String reservationBody = mockMvc.perform(requestReservation)
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

            Reservation actualReservation = mapper.readValue(reservationBody, Reservation.class);

            long reservationId = actualReservation.getId();
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/api/v1/reservations/{id}", reservationId);

            MockHttpServletResponse response = mockMvc.perform(request)
                    .andReturn()
                    .getResponse();

            // Testing status code
            assertEquals(response.getStatus(), 200);
        }

        @Test
        void testValidUpdateById() throws Exception {

            ObjectMapper mapper = new ObjectMapper();

            Reservation reservation = new Reservation(
                    3,
                    4,
                    "10:00",
                    "20:00"
            );

            MockHttpServletRequestBuilder requestReservation = MockMvcRequestBuilders.post("/api/v1/reservations")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(reservation));

            String reservationBody = mockMvc.perform(requestReservation)
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

            Reservation actualReservation = mapper.readValue(reservationBody, Reservation.class);

            long reservationId = actualReservation.getId();

            Reservation reservation1 = new Reservation(
                    3,
                    4,
                    "11:00",
                    "20:00"
            );

            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/api/v1/reservations/{id}", reservationId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(reservation1));

            MockHttpServletResponse response = mockMvc.perform(request)
                    .andReturn()
                    .getResponse();

            // Testing status code
            assertEquals(response.getStatus(), 200);


        }
}


