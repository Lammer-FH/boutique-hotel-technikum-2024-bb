package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.Request.RoomExtraRequestDTO;
import com.awt.boutiquehoteltechnikum.DTO.RoomExtraDTO;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateRoomExtraCommand;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomExtraMapper {

    RoomExtraMapper INSTANCE = Mappers.getMapper(RoomExtraMapper.class);
    RoomExtraEntity roomExtraDTOtoRoomExtra(RoomExtraDTO roomExtraDTO);
    CreateRoomExtraCommand roomExtraRequesteDTOtoCreateRoomExtraCommand(RoomExtraRequestDTO roomExtraDTO);
    @Mapping(target = "roomEntity", ignore = true)
    @Mapping(target = "extraTypeEntity", ignore = true)
    RoomExtraEntity createRoomExtraCommandToRoomExtraEntity(CreateRoomExtraCommand createRoomExtraCommand);
    @Mapping(target = "extraId", source = "extraTypeEntity.id")
    @Mapping(target = "roomId", source = "roomEntity.id")
    RoomExtraDTO roomExtraEntitytoRoomExtraDTO(RoomExtraEntity roomExtraEntity);

}
