package com.springcloud.roomservices.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.roomservices.resource.model.Room;
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
public class RoomControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(RoomControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCreateRoom() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Room room = new Room(
                "General",
                1,
                1000.0
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(room));

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

        Room room = new Room(
                "General",
                1,
                1000.0
        );

        MockHttpServletRequestBuilder requestRoom = MockMvcRequestBuilders.post("/api/v1/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(room));

        String roomBody = mockMvc.perform(requestRoom)
                .andReturn()
                .getResponse()
                .getContentAsString();

        Room actualRoom = mapper.readValue(roomBody, Room.class);

        long roomId = actualRoom.getId();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/api/v1/rooms/{id}", roomId);

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 200);
    }

    @Test
    void testValidUpdateById() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Room room = new Room(
                "General",
                1,
                1000.0
        );

        MockHttpServletRequestBuilder requestRoom = MockMvcRequestBuilders.post("/api/v1/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(room));

        String roomBody = mockMvc.perform(requestRoom)
                .andReturn()
                .getResponse()
                .getContentAsString();

        Room actualRoom = mapper.readValue(roomBody, Room.class);

        long roomId = actualRoom.getId();

        Room room1 = new Room(
                "General",
                2,
                2000.0
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/api/v1/rooms/{id}", roomId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(room1));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 200);


    }
}
