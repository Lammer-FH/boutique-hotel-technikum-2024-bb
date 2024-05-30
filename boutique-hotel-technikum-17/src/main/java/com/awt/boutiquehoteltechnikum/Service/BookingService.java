package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Model.Booking;
import com.awt.boutiquehoteltechnikum.Repository.BookingRepository;
//import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking booking)   {
        Optional<Booking> optionalBooking = bookingRepository.findById(booking.getId());
        //if(optionalBooking.isPresent()){
            Booking existingBooking = optionalBooking.get();
            existingBooking.setTitle(booking.getTitle());
            existingBooking.setAdditionalNotes(booking.getAdditionalNotes());
            existingBooking.setCustomerId(booking.getCustomerId());
            existingBooking.setRoomId(booking.getRoomId());
            existingBooking.setCreatedAt(booking.getCreatedAt());
            existingBooking.setBookingStart(booking.getBookingStart());
            existingBooking.setBookingEnd(booking.getBookingEnd());
            existingBooking.setBreakfast(booking.isBreakfast());
            existingBooking.setTotalCost(booking.getTotalCost());
            existingBooking.setCancelled(booking.isCancelled());
            return bookingRepository.save(existingBooking);
        //}
        //return bookingRepository.save(optionalBooking);
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    /*public List<Booking> getAllBookings() {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        return bookings;
    }*/
}
