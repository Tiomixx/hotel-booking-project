package com.alevel.HotelBooking.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rooms")
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;


    @Column(name = "room_number", unique = true)
    private Integer roomNumber;


    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_category")
    private RoomCategory roomCategory;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;


    @OneToMany(mappedBy = "rooms", cascade = CascadeType.REMOVE)
    private transient List<Booking> bookings;

    @Column(name = "booked")
    private boolean booked;

    public Room() {
    }

    public Room(int roomId, Integer roomNumber, Double price, RoomCategory roomCategory, Hotel hotel, List<Booking> bookings, boolean booked) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomCategory = roomCategory;
        this.hotel = hotel;
        this.bookings = bookings;
        this.booked = booked;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId &&
                booked == room.booked &&
                roomNumber.equals(room.roomNumber) &&
                price.equals(room.price) &&
                roomCategory == room.roomCategory &&
                Objects.equals(hotel, room.hotel) &&
                Objects.equals(bookings, room.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomNumber, price, roomCategory, hotel, bookings, booked);
    }
}
