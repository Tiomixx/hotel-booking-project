package com.alevel.HotelBooking.dto;

import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDtoResponse {


    private Integer bookingId;
    private User user;
    private Room room;
    private Date dateIn;
    private Date dateOut;
    private Double bookingPrice;

    public BookingDtoResponse() {
    }

    public BookingDtoResponse(Integer bookingId, User user, Room room, Date dateIn, Date dateOut, Double bookingPrice) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.bookingPrice = bookingPrice;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
    @JsonBackReference
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

    public Double getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(Double bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public static BookingDtoResponse toDto(Booking booking) {
        BookingDtoResponse bookingDtoResponse = new BookingDtoResponse();
        bookingDtoResponse.setBookingId(booking.getBookingId());
        bookingDtoResponse.setUser(booking.getUser());
        bookingDtoResponse.setRoom(booking.getRooms());
        bookingDtoResponse.setDateIn(booking.getDateIn());
        bookingDtoResponse.setDateOut(booking.getDateOut());

        return bookingDtoResponse;
    }
}
