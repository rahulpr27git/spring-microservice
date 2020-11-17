package com.springcloud.roomreservationservice;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("room-reservation")
public class RoomReservationController {

    private final RestTemplate restTemplate;

    public RoomReservationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public Collection<Room> getALl() {
        return getRooms();
    }

    public Collection<Room> getRooms() {
        ResponseEntity<List<Room>> exchange = this.restTemplate.exchange(
                "http://ROOMSERVICE/api/v1/rooms",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});

        return exchange.getBody();
    }

}
