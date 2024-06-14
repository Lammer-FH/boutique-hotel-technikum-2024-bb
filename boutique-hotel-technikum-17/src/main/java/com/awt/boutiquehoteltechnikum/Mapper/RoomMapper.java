package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.Request.RoomRequestDTO;
import com.awt.boutiquehoteltechnikum.DTO.RoomDTO;
import com.awt.boutiquehoteltechnikum.Entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
    Room roomDTOtoRoom(RoomDTO roomDTO);
    Room roomReqestDTOtoRoom(RoomRequestDTO roomDTO);
    RoomDTO roomtoRoomDTO(Room room);

}
