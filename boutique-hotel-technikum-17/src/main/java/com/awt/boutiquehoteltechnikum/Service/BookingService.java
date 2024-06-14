package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;
import com.awt.boutiquehoteltechnikum.Repository.BookingRepository;
//import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class BookingService implements com.awt.boutiquehoteltechnikum.Interfaces.BookingServiceInterface {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingEntity createBooking(BookingEntity bookingEntity) {
        bookingEntity.setCreatedAt(OffsetDateTime.now());
        return bookingRepository.save(bookingEntity);
    }

    @Override
    public BookingEntity updateBooking(BookingEntity bookingEntity)   {
        Optional<BookingEntity> optionalBooking = bookingRepository.findById(bookingEntity.getId());
        //if(optionalBooking.isPresent()){
            BookingEntity existingBookingEntity = optionalBooking.get();
            existingBookingEntity.setTitle(bookingEntity.getTitle());
            existingBookingEntity.setAdditionalNotes(bookingEntity.getAdditionalNotes());
            existingBookingEntity.setCustomerId(bookingEntity.getCustomerId());
            existingBookingEntity.setRoomId(bookingEntity.getRoomId());
            existingBookingEntity.setCreatedAt(bookingEntity.getCreatedAt());
            existingBookingEntity.setBookingStart(bookingEntity.getBookingStart());
            existingBookingEntity.setBookingEnd(bookingEntity.getBookingEnd());
            existingBookingEntity.setBreakfast(bookingEntity.isBreakfast());
            existingBookingEntity.setTotalCost(bookingEntity.getTotalCost());
            existingBookingEntity.setCancelled(bookingEntity.isCancelled());
            return bookingRepository.save(existingBookingEntity);
        //}
        //return bookingRepository.save(optionalBooking);
    }

    @Override
    public BookingEntity getBookingById(int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"bookingId not found"));
    }

    /*public List<Booking> getAllBookings() {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        return bookings;
    }*/
}
