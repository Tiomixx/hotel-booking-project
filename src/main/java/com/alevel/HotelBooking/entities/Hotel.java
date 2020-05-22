package com.alevel.HotelBooking.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "address")
    private String address;

    @Min(1)
    @Max(5)
    @Column(name = "stars")
    private int stars;

    @Column(name = "phone_number")
    private String phoneNumber;


    @JsonBackReference
    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapKeyColumn(name = "id")
    private List<Room> rooms;


    public Hotel() {
    }

    public Hotel(int hotelId, String hotelName, String address, int stars, String phoneNumber, List<Room> rooms) {
        this.id = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.stars = stars;
        this.phoneNumber = phoneNumber;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
