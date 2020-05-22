package com.alevel.HotelBooking.services;

import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.User;

import java.util.List;

public interface UserService {


    User findById (Integer id);

    void addNewUser (User user);

    void deleteUserById (Integer id);

    List<User> getAllUsers();


}
