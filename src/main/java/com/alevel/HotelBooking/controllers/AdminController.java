package com.alevel.HotelBooking.controllers;

import com.alevel.HotelBooking.dto.USerDtoResponse;
import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.services.HotelService;
import com.alevel.HotelBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private HotelService hotelService;


    @GetMapping(value = "users/{id}")
    public ResponseEntity<USerDtoResponse> getUserById (@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        USerDtoResponse result = USerDtoResponse.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "hotels/add")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        hotelService.addNewHotel(hotel);
        return new ResponseEntity(hotel, HttpStatus.CREATED);
    }
}
