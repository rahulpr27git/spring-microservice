package com.springcloud.guestservice.resource.model;

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
public class Guest {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String pincode;
    private String govermentId;

}
