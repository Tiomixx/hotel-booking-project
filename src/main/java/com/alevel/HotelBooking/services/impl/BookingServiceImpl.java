package com.alevel.HotelBooking.services.impl;

import com.alevel.HotelBooking.entities.Booking;
import com.alevel.HotelBooking.entities.Room;
import com.alevel.HotelBooking.repository.BookingRepository;
import com.alevel.HotelBooking.repository.RoomRepository;
import com.alevel.HotelBooking.repository.UserRepository;
import com.alevel.HotelBooking.services.BookingService;
import com.alevel.HotelBooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomService roomService;



    @Override
    public Booking findById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }



    @Override
    public void createNewBooking(Booking booking) {
            if (roomService.getAvailableRooms(booking.getDateIn(), booking.getDateOut())
                    .stream()
                    .filter(e -> e.getRoomId() == booking.getRooms().getRoomId())
                    .findAny().isPresent())
        {
            long days = (booking.getDateOut().getTime() - booking.getDateIn().getTime()) / (1000*60*60*24);
            Double roomsPrice = booking.getRooms().getPrice() * days;
//            booking.setBookingPrice(roomsPrice);
            bookingRepository.save(booking);
        }
    }


//    public double calculatePrice (Room rooms, long days){
//        Double roomPrice = 0.0;
//
//        for (Room room : rooms){
//            Double roomPricePerDay = room.getPrice();
//            roomPrice = roomPricePerDay * days
//        }
//    }

    @Override
    public void deleteBookingById(Integer id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }


}
//        final Instant dateIn = booking.getDateIn();
//        final Instant dateOut = booking.getDateOut();
//        final LocalDate fromLocalDate = LocalDateTime.ofInstant(dateIn, ZoneId.systemDefault()).toLocalDate();
//        final LocalDate nowLocalDate = LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()).toLocalDate();
//        if (nowLocalDate.compareTo(fromLocalDate) > 0){
//            throw new InvalidDataException("You can't book room in past time");
//        }
//        if (dateOut.compareTo(dateIn) < 0) {
//            throw new InvalidDataException("To date can't be less than from date");
//        }
//        final long days = DAYS.between(dateIn, dateOut);
//        if (days < 1 ){
//            throw new InvalidDataException("You have to book room for 1 day at least");
//        }
//        final Double roomPrice = calculatePrice(booking.getRooms(), (int) days);
//        booking.setBookingPrice(roomPrice);
//        return bookingRepository.save(booking);
//    }
//
//    private Double calculatePrice(final List<Room> rooms, final Integer days){
//        Double roomPrice = 0.0;
//        for (Room room : rooms){
//            final Double roomsPricePerDay = room.getPrice();
//            roomPrice = roomsPricePerDay * days + roomPrice;
//        }
//        return roomPrice;