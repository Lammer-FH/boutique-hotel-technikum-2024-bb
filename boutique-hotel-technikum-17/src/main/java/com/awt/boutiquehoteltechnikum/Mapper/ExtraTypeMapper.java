package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.ExtraTypeRequestDTO;
import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExtraTypeMapper {

    ExtraTypeMapper INSTANCE = Mappers.getMapper(ExtraTypeMapper.class);
    ExtraTypeEntity extraTypeDTOtoExtraType(ExtraTypeDTO extraTypeDTO);
    ExtraTypeEntity extraTypeRequestDTOtoExtraType(ExtraTypeRequestDTO extraTypeDTO);
    ExtraTypeDTO extraTypeToExtraTypeDTO(ExtraTypeEntity extraTypeEntity);
    List<ExtraTypeDTO> extraTypeListToExtraTypeDTOList(List<ExtraTypeEntity> extraTypeEntity);

}
