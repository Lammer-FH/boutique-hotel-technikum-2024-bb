package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Model.Booking;
import com.awt.boutiquehoteltechnikum.Repository.BookingRepository;
//import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BookingService implements com.awt.boutiquehoteltechnikum.Interfaces.BookingServiceInterface {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
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

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"bookingId not found"));
    }

    /*public List<Booking> getAllBookings() {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        return bookings;
    }*/
}
