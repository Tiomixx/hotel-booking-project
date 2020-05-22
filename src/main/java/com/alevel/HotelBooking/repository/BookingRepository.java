package com.alevel.HotelBooking.repository;

import com.alevel.HotelBooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {


}
