package com.springcloud.guestservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.guestservice.resource.model.Guest;
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
public class GuestControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(GuestControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCreateGuest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Guest guest = new Guest(
                "Rahul Prasad",
                "kolkata",
                "2574961254",
                "700022",
                "aadhar"
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/guests")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(guest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 201);
    }
}
