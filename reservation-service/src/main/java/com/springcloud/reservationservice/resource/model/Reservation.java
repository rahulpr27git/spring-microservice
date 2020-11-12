package com.springcloud.reservationservice.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    long id;
    long guestId;
    long roomId;
    String checkInTime;
    String checkOutTime;

    public Reservation(long guestId, long roomId, String checkInTime, String checkOutTime) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
}

