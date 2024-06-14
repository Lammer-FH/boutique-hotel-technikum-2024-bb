package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.Booking;

public interface BookingServiceInterface {
    Booking createBooking(Booking booking);

    Booking updateBooking(Booking booking);

    Booking getBookingById(int id);
}
