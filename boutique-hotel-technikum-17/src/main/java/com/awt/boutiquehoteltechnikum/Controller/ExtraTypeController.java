package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.ExtraTypeRequestDTO;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateExtraTypeCommand;
import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import com.awt.boutiquehoteltechnikum.Interfaces.ExtraTypeServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.ExtraTypeMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/api/hotel/v1/extra_types")
public class ExtraTypeController {
    @Autowired
    private ExtraTypeServiceInterface extraTypeService;

    @PostMapping
    public ExtraTypeDTO createExtraType(@Valid @RequestBody ExtraTypeRequestDTO extraTypeDTO) {
        CreateExtraTypeCommand createExtraTypeCommand = ExtraTypeMapper.INSTANCE.extraTypeRequestDTOtoCreateExtraTypeCommand(extraTypeDTO);
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.createExtraType(createExtraTypeCommand));
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
    public ExtraTypeDTO updateExtraType(@Valid @RequestBody ExtraTypeDTO extraTypeDTO) {
        ExtraTypeEntity extraTypeEntity = ExtraTypeMapper.INSTANCE.extraTypeDTOtoExtraType(extraTypeDTO);
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.updateExtraType(extraTypeEntity));
    }
}
