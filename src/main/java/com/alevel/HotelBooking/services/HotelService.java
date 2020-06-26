package com.alevel.HotelBooking.services;

import com.alevel.HotelBooking.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel findById (Integer id);

    void addNewHotel (Hotel hotel);

    void deleteHotelById (Integer id);

    List<Hotel> getAllHotels();


    Hotel getHotelByHotelName(String hotelName);
}
