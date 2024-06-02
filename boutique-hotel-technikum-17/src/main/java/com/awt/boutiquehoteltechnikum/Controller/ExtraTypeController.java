package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.Mapper.ExtraTypeMapper;
import com.awt.boutiquehoteltechnikum.Model.ExtraType;
import com.awt.boutiquehoteltechnikum.Service.ExtraTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/extra_types")
public class ExtraTypeController {
    @Autowired
    private ExtraTypeService extraTypeService;

    @PostMapping
    public ExtraTypeDTO createExtraType(@RequestBody ExtraTypeDTO extraTypeDTO) {
        ExtraType extraType = ExtraTypeMapper.INSTANCE.extraTypeDTOtoExtraType(extraTypeDTO);
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.createExtraType(extraType));
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
        ExtraType extraType = ExtraTypeMapper.INSTANCE.extraTypeDTOtoExtraType(extraTypeDTO);
        return ExtraTypeMapper.INSTANCE.extraTypeToExtraTypeDTO(extraTypeService.updateExtraType(extraType));
    }
}
