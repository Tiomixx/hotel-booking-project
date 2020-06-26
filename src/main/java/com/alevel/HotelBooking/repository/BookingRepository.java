package com.alevel.HotelBooking.repository;

import com.alevel.HotelBooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {



    @Query("select b from Booking as b where (b.dateIn >= :dIn and b.dateIn < :dOut) " +
            "or (b.dateOut > :dIn and b.dateOut <= :dOut)")
    List<Booking> findBookingsThatOverlapSpecifiedPeriod(@Param("dIn") Date dIn, @Param("dOut") Date dOut);

//    List<Booking> findByDateInGreaterAndDateOutLessThen(@Param("dIn") Date dIn, @Param("dOut") Date dOut);
//    List<Booking> findByDateInGreaterAndDateOutLessThen(Date dateIn, Date dateOut);
}
