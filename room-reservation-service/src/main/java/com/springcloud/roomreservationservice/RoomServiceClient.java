package com.springcloud.roomreservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("ROOMSERVICE")
public interface RoomServiceClient {

    @GetMapping("/api/v1/rooms")
    List<Room> getAll();

    @PostMapping("/api/v1/rooms")
    Room addRoom(@RequestBody Room room);
}
