package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.RoomDTO;
import com.awt.boutiquehoteltechnikum.DTO.RoomExtraDTO;
import com.awt.boutiquehoteltechnikum.Model.Room;
import com.awt.boutiquehoteltechnikum.Model.RoomExtra;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomExtraMapper {

    RoomExtraMapper INSTANCE = Mappers.getMapper(RoomExtraMapper.class);
    RoomExtra roomExtraDTOtoRoomExtra(RoomExtraDTO roomExtraDTO);
    RoomExtraDTO roomExtraDTOtoRoomExtra(RoomExtra roomExtra);

}
