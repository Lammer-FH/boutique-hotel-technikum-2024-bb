package com.awt.boutiquehoteltechnikum.Controller;


import com.awt.boutiquehoteltechnikum.DTO.BookingDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.BookingRequestDTO;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateBookingCommand;
import com.awt.boutiquehoteltechnikum.Interfaces.BookingServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.BookingMapper;
import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/hotel/v1/booking")
public class BookingController {
    @Autowired
    private BookingServiceInterface bookingService;
    @PostMapping
    public BookingDTO addBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) throws Exception {
        CreateBookingCommand createBookingCommand = BookingMapper.INSTANCE.bookingRequestDTOtoCreateBookingCommand(bookingRequestDTO);
        return BookingMapper.INSTANCE.bookingEntityToBookingDTO(bookingService.createBooking(createBookingCommand));
    }

    @GetMapping("/{bookingId}")
    public BookingDTO getBooking(@PathVariable int bookingId) {
        return BookingMapper.INSTANCE.bookingEntityToBookingDTO(bookingService.getBookingById(bookingId));
    }

    @PutMapping
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDto) {
        BookingEntity bookingEntity = BookingMapper.INSTANCE.bookingDTOtoBookingEntity(bookingDto);
        return BookingMapper.INSTANCE.bookingEntityToBookingDTO(bookingService.updateBooking(bookingEntity));
    }
}

