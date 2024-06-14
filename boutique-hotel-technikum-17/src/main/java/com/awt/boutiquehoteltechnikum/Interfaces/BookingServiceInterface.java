package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;

public interface BookingServiceInterface {
    BookingEntity createBooking(BookingEntity bookingEntity);

    BookingEntity updateBooking(BookingEntity bookingEntity);

    BookingEntity getBookingById(int id);
}
