package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Model.Booking;

public interface BookingServiceInterface {
    Booking createBooking(Booking booking);

    Booking updateBooking(Booking booking);

    Booking getBookingById(int id);
}
