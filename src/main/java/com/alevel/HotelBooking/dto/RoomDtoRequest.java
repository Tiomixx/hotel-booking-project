package com.alevel.HotelBooking.dto;


import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDtoRequest {

    private Integer roomNumber;
    private Double price;
    private RoomCategory roomCategory;
    private Hotel hotel;
    private List<Booking> bookings;
    private boolean booked;
}
