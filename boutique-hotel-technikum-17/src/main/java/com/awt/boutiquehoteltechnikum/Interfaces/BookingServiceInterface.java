package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateBookingCommand;
import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;

public interface BookingServiceInterface {
    BookingEntity createBooking(CreateBookingCommand createBookingCommand) throws Exception;

    BookingEntity updateBooking(BookingEntity bookingEntity);

    BookingEntity getBookingById(int id);
}
