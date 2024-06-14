package com.awt.boutiquehoteltechnikum.Controller;


import com.awt.boutiquehoteltechnikum.DTO.BookingDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.BookingRequestDTO;
import com.awt.boutiquehoteltechnikum.Interfaces.BookingServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.BookingMapper;
import com.awt.boutiquehoteltechnikum.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/hotel/v1/booking")
public class BookingController {
    @Autowired
    private BookingServiceInterface bookingService;
    @PostMapping
    public BookingDTO addBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        Booking booking = BookingMapper.INSTANCE.bookingRequestDTOtoBooking(bookingRequestDTO);
        return BookingMapper.INSTANCE.bookingToBookingDTO(bookingService.createBooking(booking));
    }

    @GetMapping("/{bookingId}")
    public BookingDTO getBooking(@PathVariable int bookingId) {
        return BookingMapper.INSTANCE.bookingToBookingDTO(bookingService.getBookingById(bookingId));
    }

    @PutMapping("/{bookingId}")
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDto) {
        Booking booking = BookingMapper.INSTANCE.bookingDTOtoBooking(bookingDto);
        return BookingMapper.INSTANCE.bookingToBookingDTO(bookingService.updateBooking(booking));
    }
}

