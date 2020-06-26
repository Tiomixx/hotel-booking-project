package com.alevel.HotelBooking.services.impl;

import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.repository.BookingRepository;
import com.alevel.HotelBooking.repository.RoomRepository;
import com.alevel.HotelBooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

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


    @Override
    public List<Room> getAvailableRooms(Date in, Date out) {
        List<Booking> booked = bookingRepository.findBookingsThatOverlapSpecifiedPeriod(in, out);
        List<Room> allRooms = roomRepository.findAll();
        Set<Room> reservedRooms = booked.stream()
                .map(Booking::getRooms)
                .collect(Collectors.toSet());
        return allRooms.stream()
                .filter(e -> !reservedRooms.contains(e))
                .collect(Collectors.toList());
    }
}
