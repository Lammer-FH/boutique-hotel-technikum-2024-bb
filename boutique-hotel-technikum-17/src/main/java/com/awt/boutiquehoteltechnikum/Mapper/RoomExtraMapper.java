package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.Request.RoomExtraRequestDTO;
import com.awt.boutiquehoteltechnikum.DTO.RoomExtraDTO;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtra;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomExtraMapper {

    RoomExtraMapper INSTANCE = Mappers.getMapper(RoomExtraMapper.class);
    RoomExtra roomExtraDTOtoRoomExtra(RoomExtraDTO roomExtraDTO);
    RoomExtra roomExtraRequestDTOtoRoomExtra(RoomExtraRequestDTO roomExtraDTO);
    RoomExtraDTO roomExtratoRoomExtraDTO(RoomExtra roomExtra);

}
