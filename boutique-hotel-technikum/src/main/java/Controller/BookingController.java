package Controller;

import DTO.BookingDTO;
import Model.Booking;
import Service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/{bookingId}")
    public Booking addBooking(@PathVariable int bookingId, @RequestBody BookingDTO bookingDTO) {
        /* booking = bookingService.createBooking(this.modelMapper(bookingDTO, Booking.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);*/
    }

    @PostMapping
    public Booking updateBooking(@RequestBody BookingDTO bookingDTO) {
        // Booking updatedBooking = bookingService.updateBooking(bookingDTO);
    }

    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable int bookingId) throws Exception {
        /* BookingDTO booking = BookingDTO.fromEntity(bookingService.getBookingById(bookingId));
        return ResponseEntity.ok(booking).getBody(); */
    }
}
