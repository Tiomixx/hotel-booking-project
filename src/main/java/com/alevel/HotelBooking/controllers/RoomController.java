package com.alevel.HotelBooking.controllers;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.alevel.HotelBooking.entities.Hotel;
import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.services.HotelService;
import com.alevel.HotelBooking.services.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    HotelService hotelService;


    @PostMapping(value = "/{id}/rooms")
    public ResponseEntity createRoom(@PathVariable("id") Integer id, @RequestBody Room room) {
        Hotel hotel = hotelService.findById(id);
        room.setHotel(hotel);
        roomService.createNewRoom(room);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/rooms/")
    public ResponseEntity<List<Room>> showAllRooms(@PathVariable("id") Integer id) {
        Hotel hotel = hotelService.findById(id);
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

}
