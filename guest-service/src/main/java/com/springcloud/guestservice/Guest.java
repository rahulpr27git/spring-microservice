package com.springcloud.guestservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String pincode;
    private String govermentId;

}
