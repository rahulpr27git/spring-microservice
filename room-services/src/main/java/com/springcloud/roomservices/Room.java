package com.springcloud.roomservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Long id;
    private Integer roomType;
    private Integer numberOfBeds;
    private Double pricePerDay;
}
