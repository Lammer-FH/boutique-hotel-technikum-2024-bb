package awt.bb2024.Controller;

import awt.bb2024.DTO.BookingDTO;
import awt.bb2024.Model.Booking;
import awt.bb2024.Service.BookingService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Booking addBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable int bookingId) throws NotFoundException {
        return bookingService.getBookingById(bookingId);
    }

    @PutMapping
    public Booking updateBooking(@RequestBody BookingDTO bookingDTO) throws NotFoundException {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        return bookingService.updateBooking(booking);
    }
}
