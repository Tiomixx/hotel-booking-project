package com.alevel.HotelBooking.services.impl;

import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.repository.RoomRepository;
import com.alevel.HotelBooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void createNewRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room findById(Integer roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getRoomsByHotel(List<Integer> ids) {
        return roomRepository.findRoomsByHotelId(ids);
    }

    @Override
    public void deleteRoomById(Integer roomId) {
        roomRepository.deleteById(roomId);
    }
}
