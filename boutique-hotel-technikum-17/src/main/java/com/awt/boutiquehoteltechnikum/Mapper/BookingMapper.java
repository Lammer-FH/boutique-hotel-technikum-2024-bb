package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.BookingDTO;
import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.BookingRequestDTO;
import com.awt.boutiquehoteltechnikum.Model.Booking;
import com.awt.boutiquehoteltechnikum.Model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
    Booking bookingRequestDTOtoBooking(BookingRequestDTO bookingDTO);
    Booking bookingDTOtoBooking(BookingDTO bookingDTO);
    BookingDTO bookingToBookingDTO(Booking booking);

}
