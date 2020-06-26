package com.alevel.HotelBooking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;


    @Column(name = "date_in")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @Column(name = "date_out")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;


    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //    @JoinTable(
//            name = "booked_rooms",
//            joinColumns = {@JoinColumn(name = "booking_id", referencedColumnName = "bookingId")},
//            inverseJoinColumns = {@JoinColumn(name = "room_id", referencedColumnName = "roomId")}
//    )


    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "room_id")
    private Room rooms;


//    @Column
//    private Double bookingPrice;


    public Booking() {
    }


    public Booking(int bookingId, Date dateIn, Date dateOut,Double bookingPrice, User user, Room rooms) {
        this.bookingId = bookingId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.user = user;
        this.rooms = rooms;
//        this.bookingPrice = bookingPrice;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRooms() {
        return rooms;
    }

    public void setRooms(Room rooms) {
        this.rooms = rooms;
    }

//    public Double getBookingPrice() {
//        return bookingPrice;
//    }
//
//    public void setBookingPrice(Double bookingPrice) {
//        this.bookingPrice = bookingPrice;
//    }
}
