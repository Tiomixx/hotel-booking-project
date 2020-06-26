package com.alevel.HotelBooking.controllers;


import com.alevel.HotelBooking.dto.USerDtoResponse;
import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<USerDtoResponse> getUserById(@PathVariable(name = "id") Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        USerDtoResponse result = USerDtoResponse.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
