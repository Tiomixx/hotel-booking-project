package com.alevel.HotelBooking.services;

import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.Room;

import java.util.List;

public interface RoomService {

    void createNewRoom(Room room);

    Room findById(Integer roomId);

    void deleteRoomById (Integer roomId);

    List<Room> getAllRooms();

    List<Room> getRoomsByHotel (List<Integer> ids);


}
