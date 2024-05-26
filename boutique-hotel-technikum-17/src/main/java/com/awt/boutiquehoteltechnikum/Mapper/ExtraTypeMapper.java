package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.Model.Customer;
import com.awt.boutiquehoteltechnikum.Model.ExtraType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExtraTypeMapper {

    ExtraTypeMapper INSTANCE = Mappers.getMapper(ExtraTypeMapper.class);
    ExtraType extraTypeDTOtoExtraType(ExtraTypeDTO extraTypeDTO);
    ExtraTypeDTO extraTypeToExtraTypeDTO(ExtraType extraType);

}
