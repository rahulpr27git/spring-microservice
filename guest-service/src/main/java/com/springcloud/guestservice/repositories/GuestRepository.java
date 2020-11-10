package com.springcloud.guestservice.repositories;

import com.springcloud.guestservice.resource.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {

}
