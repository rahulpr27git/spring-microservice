package com.springcloud.guestservice.controller;

import com.springcloud.guestservice.resource.model.Guest;
import com.springcloud.guestservice.resource.pojo.Response;
import com.springcloud.guestservice.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestController {

    final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getAll() {
        return guestService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Guest addGuest(@RequestBody Guest guest) {
        return guestService.addGuest(guest);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable(value = "id") long id) {
        return guestService.delete(id);
    }

    @PutMapping("/{id}")
    public Guest updateById(@RequestBody Guest guest, @PathVariable("id") long id) {
        return guestService.updateById(guest, id);
    }
}
