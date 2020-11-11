package com.springcloud.roomservices.resource.model;

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
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String roomType;
    private Integer numberOfBeds;
    private Double pricePerDay;

    public Room(String roomType, Integer numberOfBeds, Double pricePerDay) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerDay = pricePerDay;
    }
}
