package com.alevel.HotelBooking.repository;

import com.alevel.HotelBooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername (String username);

}
