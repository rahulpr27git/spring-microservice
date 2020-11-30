package com.springcloud.roomreservationservice;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("room-reservation")
public class RoomReservationController {

    private final RoomServiceClient roomServiceClient;

    public RoomReservationController(RoomServiceClient roomServiceClient) {
        this.roomServiceClient = roomServiceClient;
    }

    @GetMapping
    public Collection<Room> getALl() {
        return this.roomServiceClient.getAll();
    }

}
