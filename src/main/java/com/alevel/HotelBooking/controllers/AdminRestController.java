package com.alevel.HotelBooking.controllers;

import com.alevel.HotelBooking.dto.USerDtoResponse;
import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminRestController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "users/{id}")
    public ResponseEntity<USerDtoResponse> getUserById (@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        USerDtoResponse result = USerDtoResponse.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
