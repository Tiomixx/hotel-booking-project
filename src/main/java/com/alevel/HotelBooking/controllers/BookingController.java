package com.alevel.HotelBooking.controllers;

import com.alevel.HotelBooking.dto.BookingDtoRequest;
import com.alevel.HotelBooking.dto.BookingDtoResponse;
import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.entities.User;
import com.alevel.HotelBooking.exceptions.HotelNotFoundException;
import com.alevel.HotelBooking.services.BookingService;


import com.alevel.HotelBooking.services.RoomService;
import com.alevel.HotelBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/new")
    public ResponseEntity<BookingDtoRequest> createBooking(@RequestBody BookingDtoRequest bookingDtoRequest) throws ParseException {

        User user = new User();
        user.setId(bookingDtoRequest.getUser().getId());

        Room room = new Room();
        room.setRoomId(bookingDtoRequest.getRoom().getRoomId());

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRooms(room);
        booking.setDateIn(booking.getDateIn());
        booking.setDateOut(booking.getDateOut());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dateIn = dateFormat.parse(String.valueOf(bookingDtoRequest.getDateIn()));
        booking.setDateIn(dateIn);

        Date dateOut = dateFormat.parse(String.valueOf(bookingDtoRequest.getDateOut()));
        booking.setDateOut(dateOut);

        bookingService.createNewBooking(booking);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.findAllBookings();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<BookingDtoResponse> getBookingById(@PathVariable("booking_id") Integer bookingId) {
        Booking booking = bookingService.findById(bookingId);
        BookingDtoResponse result = BookingDtoResponse.toDto(booking);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
