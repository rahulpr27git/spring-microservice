package com.springcloud.roomservices.controller;

import com.springcloud.roomservices.resource.model.Room;
import com.springcloud.roomservices.resource.pojo.Response;
import com.springcloud.roomservices.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    final
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAll() {
        return Arrays.asList(
                new Room(1L, "big", 1, 3.5)
        );
        //return roomService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable(value = "id") long id) {
        return roomService.delete(id);
    }

    @PutMapping("/{id}")
    public Room updateById(@RequestBody Room room, @PathVariable("id") long id) {
        return roomService.updateById(room, id);
    }
}
