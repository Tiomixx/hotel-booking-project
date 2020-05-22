package com.alevel.HotelBooking.repository;

import com.alevel.HotelBooking.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    Hotel findHotelByHotelName(String hotelName);

}
