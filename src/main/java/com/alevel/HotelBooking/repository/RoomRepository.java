package com.alevel.HotelBooking.repository;

import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("select b from Room b where b.hotel.id in :idsHotel")
    List<Room> findRoomsByHotelId(List<Integer> idsHotel);

}
