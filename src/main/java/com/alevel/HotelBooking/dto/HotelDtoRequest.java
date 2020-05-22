package com.alevel.HotelBooking.dto;

import com.alevel.HotelBooking.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDtoRequest {

    private String hotelName;

    private String address;

    private int stars;

    private String phoneNumber;

    private List<Room> rooms;


}
