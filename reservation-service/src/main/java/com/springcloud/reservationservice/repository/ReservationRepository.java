package com.springcloud.reservationservice.repository;

import com.springcloud.reservationservice.resource.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
