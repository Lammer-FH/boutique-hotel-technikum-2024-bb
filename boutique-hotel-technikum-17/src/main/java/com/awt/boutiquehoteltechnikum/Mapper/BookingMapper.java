package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.BookingDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.BookingRequestDTO;
import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
    BookingEntity bookingRequestDTOtoBooking(BookingRequestDTO bookingDTO);
    BookingEntity bookingDTOtoBooking(BookingDTO bookingDTO);
    BookingDTO bookingToBookingDTO(BookingEntity bookingEntity);

}
