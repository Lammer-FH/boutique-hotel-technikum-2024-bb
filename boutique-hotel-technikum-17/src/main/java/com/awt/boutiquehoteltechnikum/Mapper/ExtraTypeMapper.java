package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.ExtraTypeRequestDTO;
import com.awt.boutiquehoteltechnikum.Entities.ExtraType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExtraTypeMapper {

    ExtraTypeMapper INSTANCE = Mappers.getMapper(ExtraTypeMapper.class);
    ExtraType extraTypeDTOtoExtraType(ExtraTypeDTO extraTypeDTO);
    ExtraType extraTypeRequestDTOtoExtraType(ExtraTypeRequestDTO extraTypeDTO);
    ExtraTypeDTO extraTypeToExtraTypeDTO(ExtraType extraType);
    List<ExtraTypeDTO> extraTypeListToExtraTypeDTOList(List<ExtraType> extraType);

}
