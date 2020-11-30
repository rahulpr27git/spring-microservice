package com.springcloud.roomreservationservice;

public class Room {

    private Long id;
    private String roomType;
    private Integer numberOfBeds;
    private Double pricePerDay;

    public Room() {
    }

    public Room(Long id, String roomType, Integer numberOfBeds, Double pricePerDay) {
        this.id = id;
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerDay = pricePerDay;
    }

    public Long getId() {
        return id;
    }

    public String getRoomType() {
        return roomType;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
}
