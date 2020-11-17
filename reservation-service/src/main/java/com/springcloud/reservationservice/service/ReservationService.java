package com.springcloud.reservationservice.service;

import com.springcloud.reservationservice.repository.ReservationRepository;
import com.springcloud.reservationservice.resource.model.Reservation;
import com.springcloud.reservationservice.resource.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }


    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Response delete(long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(id);
            return new Response(false, String.format("Reservation with id: %s Deleted Successfully", id));
        }

        return new Response(true, String.format("Reservation with id: %s not found", id));
    }


    public Reservation updateById(Reservation reservation, long id) {
        Reservation reservation1 = reservationRepository.findById(id).get();
        reservation1.setGuestId(reservation.getGuestId());
        reservation1.setRoomId(reservation.getRoomId());
        reservation1.setCheckInTime(reservation.getCheckInTime());
        reservation1.setCheckOutTime(reservation.getCheckOutTime());
        return reservationRepository.save(reservation1);
    }
}
