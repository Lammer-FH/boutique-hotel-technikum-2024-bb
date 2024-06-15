package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateBookingCommand;
import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;
import com.awt.boutiquehoteltechnikum.Mapper.BookingMapper;
import com.awt.boutiquehoteltechnikum.Mapper.CustomerMapper;
import com.awt.boutiquehoteltechnikum.Repository.BookingRepository;
//import javassist.NotFoundException;
import com.awt.boutiquehoteltechnikum.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookingService implements com.awt.boutiquehoteltechnikum.Interfaces.BookingServiceInterface {
    @Autowired
    private BookingRepository bookingRepository; // If enough time: Make extra class which handles requests to the repository

    @Autowired
    private CustomerRepository customerRepository; // If enough time: Make extra class which handles requests to the repository

    @Override
    public BookingEntity createBooking(CreateBookingCommand createBookingCommand) throws Exception {
        BookingEntity bookingEntity = BookingMapper.INSTANCE.createBookingCommandtoBookingEntity(createBookingCommand);
        try{
            bookingEntity.setCreatedAt(OffsetDateTime.now());

            CustomerEntity customer = customerRepository.findById(createBookingCommand.getCustomerId()).get();
            bookingEntity.setCustomerEntity(customer);

            return bookingRepository.save(bookingEntity);
        }
        catch(NoSuchElementException e){
            throw new Exception("CustomerId not found");
        }
        catch(Exception e){
            throw e;
        }

    }

    @Override
    public BookingEntity updateBooking(BookingEntity bookingEntity)   {
        Optional<BookingEntity> optionalBooking = bookingRepository.findById(bookingEntity.getId());
        //if(optionalBooking.isPresent()){
            BookingEntity existingBookingEntity = optionalBooking.get();
            existingBookingEntity.setTitle(bookingEntity.getTitle());
            existingBookingEntity.setAdditionalNotes(bookingEntity.getAdditionalNotes());
            existingBookingEntity.setCustomerEntity(bookingEntity.getCustomerEntity());
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
