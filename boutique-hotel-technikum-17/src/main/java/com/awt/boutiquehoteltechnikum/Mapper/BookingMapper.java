package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.BookingDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.BookingRequestDTO;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateBookingCommand;
import com.awt.boutiquehoteltechnikum.Entities.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
    CreateBookingCommand bookingRequestDTOtoCreateBookingCommand(BookingRequestDTO bookingDTO);
    BookingEntity bookingDTOtoBookingEntity(BookingDTO bookingDTO);
    @Mapping(target = "customerEntity", ignore = true)
    BookingEntity createBookingCommandtoBookingEntity(CreateBookingCommand createBookingCommand);

    @Mapping(target = "customerId", source = "customerEntity.id")
    BookingDTO bookingEntityToBookingDTO(BookingEntity bookingEntity);

}
