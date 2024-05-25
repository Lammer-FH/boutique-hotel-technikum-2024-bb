package awt.bb2024.Controller;

import awt.bb2024.DTO.ExtraTypeDTO;
import awt.bb2024.Model.ExtraType;
import awt.bb2024.Service.ExtraTypeService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/extra_types")
public class ExtraTypeController {
    @Autowired
    private ExtraTypeService extraTypeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ExtraTypeDTO createExtraType(@RequestBody ExtraTypeDTO extraTypeDTO) {
        ExtraType extraType = modelMapper.map(extraTypeDTO, ExtraType.class);
        return modelMapper.map(extraTypeService.createExtraType(extraType), ExtraTypeDTO.class);
    }

    @GetMapping("/{extraId}")
    public ExtraTypeDTO getExtraTypeById(@PathVariable int extraId) throws NotFoundException {
        return modelMapper.map(extraTypeService.getExtraTypeById(extraId),ExtraTypeDTO.class);
    }

    @GetMapping
    public List<ExtraTypeDTO> getAllExtraTypes() {
        return extraTypeService.getAllExtraTypes().stream()
                .map(extraType -> modelMapper.map(extraType, ExtraTypeDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public ExtraTypeDTO updateExtraType(@RequestBody ExtraTypeDTO extraTypeDTO) throws NotFoundException {
        ExtraType extraType = modelMapper.map(extraTypeDTO, ExtraType.class);
        return modelMapper.map(extraTypeService.updateExtraType(extraType), ExtraTypeDTO.class);
    }
}
