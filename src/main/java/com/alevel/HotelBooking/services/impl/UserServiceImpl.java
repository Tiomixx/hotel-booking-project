package com.alevel.HotelBooking.services.impl;

import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.repository.UserRepository;
import com.alevel.HotelBooking.services.BookingService;
import com.alevel.HotelBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    //TODO переделать на Регистрацию
    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }




    }

