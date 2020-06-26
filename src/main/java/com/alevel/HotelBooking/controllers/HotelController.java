package com.alevel.HotelBooking.controllers;


import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.exceptions.HotelNotFoundException;
import com.alevel.HotelBooking.services.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hotels")
@AllArgsConstructor
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello hotels";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        hotelService.addNewHotel(hotel);
        return new ResponseEntity(hotel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Integer id) {
        Hotel hotel = hotelService.findById(id);
        if (hotel == null) throw new HotelNotFoundException();
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> deleteHotelById(@PathVariable("id") Integer id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
