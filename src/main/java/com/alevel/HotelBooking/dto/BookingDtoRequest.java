package com.alevel.HotelBooking.dto;

import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDtoRequest {

    private User user;
    private Room room;
    private Date dateIn;
    private Date dateOut;



    public BookingDtoRequest() {
    }

    public BookingDtoRequest(User user, Room room, Date dateIn, Date dateOut) {
        this.user = user;
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

}
