package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.ExtraTypeRequestDTO;
import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import com.awt.boutiquehoteltechnikum.Interfaces.ExtraTypeServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.ExtraTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotel/v1/extra_types")
public class ExtraTypeController {
    @Autowired
    private ExtraTypeServiceInterface extraTypeService;

    @PostMapping
    public ExtraTypeDTO createExtraType(@RequestBody ExtraTypeRequestDTO extraTypeDTO) {
        ExtraTypeEntity extraTypeEntity = ExtraTypeMapper.INSTANCE.extraTypeRequestDTOtoExtraType(extraTypeDTO);
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.createExtraType(extraTypeEntity));
    }

    @GetMapping("/{extraId}")
    public ExtraTypeDTO getExtraTypeById(@PathVariable int extraId) {
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.getExtraTypeById(extraId));
    }

    @GetMapping
    public List<ExtraTypeDTO> getAllExtraTypes() {
        return extraTypeService.getAllExtraTypes().stream()
                .map(extraType -> ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraType))
                .collect(Collectors.toList());
    }

    @PutMapping
    public ExtraTypeDTO updateExtraType(@RequestBody ExtraTypeDTO extraTypeDTO) {
        ExtraTypeEntity extraTypeEntity = ExtraTypeMapper.INSTANCE.extraTypeDTOtoExtraType(extraTypeDTO);
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.updateExtraType(extraTypeEntity));
    }
}
