package com.springcloud.roomservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @GetMapping
    public Collection<Room> getAll() {
        return Arrays.asList(
                new Room(1L, 1, 2, 50d),
                new Room(2L, 2, 3, 100d),
                new Room(3L, 3, 4, 200d),
                new Room(4L, 4, 1, 20d)
        );
    }
}
