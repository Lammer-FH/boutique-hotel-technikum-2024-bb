package Service;

import Model.Booking;
import Repository.BookingRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking = bookingRepository.save(booking);
        return booking;
    }

    public Booking updateBooking(Booking booking) throws NotFoundException {
        Optional<Booking> optionalBooking = bookingRepository.findById(booking.getId());
        if(optionalBooking.isPresent()){
            Booking existingBooking = bookingRepository.findById(booking.getId()).get();
            existingBooking.setTitle(booking.getTitle());
            existingBooking.setAdditional_notes(booking.getAdditional_notes());
            existingBooking.setCustomer_id(booking.getCustomer_id());
            existingBooking.setRoom_id(booking.getRoom_id());
            existingBooking.setCreated_at(booking.getCreated_at());
            existingBooking.setBooking_start(booking.getBooking_start());
            existingBooking.setBooking_end(booking.getBooking_end());
            existingBooking.setBreakfast(booking.isBreakfast());
            existingBooking.setTotal_cost(booking.getTotal_cost());
            existingBooking.setCancelled(booking.isCancelled());
            return bookingRepository.save(existingBooking);
        } else {
            throw new NotFoundException("Booking not found with id: " + booking.getId());
        }
    }

    public Booking getBookingById(int id) throws Exception {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found with id: " + id));
        return booking;
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        return bookings;
    }
}
