package com.alevel.HotelBooking.services.impl;

import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.repository.HotelRepository;
import com.alevel.HotelBooking.repository.RoomRepository;
import com.alevel.HotelBooking.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HotelServiceImpl implements HotelService  {


    @Autowired
    HotelRepository hotelRepository;


    @Override
    public Hotel findById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public void addNewHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotelById(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelByHotelName(String hotelName) {
        return hotelRepository.findHotelByHotelName(hotelName);
    }
}
