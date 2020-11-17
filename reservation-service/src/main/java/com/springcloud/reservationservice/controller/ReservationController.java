package com.springcloud.reservationservice.controller;

import com.springcloud.reservationservice.resource.model.Reservation;
import com.springcloud.reservationservice.resource.pojo.Response;
import com.springcloud.reservationservice.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable(value = "id") long id) {
        return reservationService.delete(id);
    }

    @PutMapping("/{id}")
    public Reservation updateById(@RequestBody Reservation reservation, @PathVariable("id") long id) {
        return reservationService.updateById(reservation, id);
    }
}
