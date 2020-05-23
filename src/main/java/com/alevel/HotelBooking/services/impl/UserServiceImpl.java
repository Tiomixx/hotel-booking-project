package com.alevel.HotelBooking.services.impl;

import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Role;
import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.exceptions.UserNoteFoundException;
import com.alevel.HotelBooking.repository.RoleRepository;
import com.alevel.HotelBooking.repository.UserRepository;
import com.alevel.HotelBooking.services.BookingService;
import com.alevel.HotelBooking.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User findById(Integer id) {
        User result = userRepository.findById(id).orElse(null);
        if(result == null){
            throw new UserNoteFoundException();
        }
        return result;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByRoleName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User findByUsername(String username) {
        User userResult = userRepository.findByUsername(username);
        return userResult;
    }
}

