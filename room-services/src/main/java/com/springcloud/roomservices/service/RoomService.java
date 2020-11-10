package com.springcloud.roomservices.service;


import com.springcloud.roomservices.repository.RoomRepository;
import com.springcloud.roomservices.resource.model.Room;
import com.springcloud.roomservices.resource.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

        @Autowired
        RoomRepository roomRepository;

        public List<Room> getAll() {
            return roomRepository.findAll();
        }


        public Room addRoom(Room room) {
            return roomRepository.save(room);
        }

        public Response delete(long id) {
            Optional<Room> room = roomRepository.findById(id);
            if (room.isPresent()) {
                roomRepository.deleteById(id);
                return new Response(false,String.format("Room with id: %s Deleted Successfully",id));
            }

            return new Response(true,String.format("Room with id: %s not found",id));
        }


        public Room updateById(Room room, long id) {
            Room room1 = roomRepository.findById(id).get();
            room1.setNumberOfBeds(room.getNumberOfBeds());
            room1.setPricePerDay(room.getPricePerDay());
            room1.setRoomType(room.getRoomType());
            return roomRepository.save(room1);
        }
}


