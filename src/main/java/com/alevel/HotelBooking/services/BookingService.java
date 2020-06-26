package com.alevel.HotelBooking.services;


import com.alevel.HotelBooking.entities.Booking;



import java.util.List;

public interface BookingService {

    Booking findById(Integer id);

    void createNewBooking(Booking booking);

    void deleteBookingById(Integer id);

    List<Booking> findAllBookings();




}
