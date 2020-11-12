package com.springcloud.guestservice.service;

import com.springcloud.guestservice.resource.model.Guest;
import com.springcloud.guestservice.repositories.GuestRepository;
import com.springcloud.guestservice.resource.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    GuestRepository guestRepository;

    public List<Guest> getAll() {
        return guestRepository.findAll();
    }


    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Response delete(long id) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (guest.isPresent()) {
            guestRepository.deleteById(id);
            return new Response(false, String.format("Guest with id: %s Deleted Successfully", id));
        }

        return new Response(true, String.format("Guest with id: %s not found", id));
    }


    public Guest updateById(Guest guest, long id) {
        Guest guest1 = guestRepository.findById(id).get();
        guest1.setAddress(guest.getAddress());
        guest1.setGovermentId(guest.getGovermentId());
        guest1.setName(guest.getName());
        guest1.setPhoneNumber(guest.getPhoneNumber());
        guest1.setPincode(guest.getPincode());
        return guestRepository.save(guest1);
    }
}
