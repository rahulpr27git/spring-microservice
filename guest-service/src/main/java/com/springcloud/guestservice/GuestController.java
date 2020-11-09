package com.springcloud.guestservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestController {


    @GetMapping
    public Collection<Guest> getAll() {
        return Arrays.asList(
                new Guest(1L, "Rahul", "Kolkata", "987654351", "124242235", "242425"),
                new Guest(2L, "Jay", "Kolkata", "987654351", "124242235", "242425"),
                new Guest(3L, "Abhishek", "Kolkata", "987654351", "124242235", "242425"),
                new Guest(4L, "Shiwam", "Kolkata", "987654351", "124242235", "242425")
        );
    }
}
