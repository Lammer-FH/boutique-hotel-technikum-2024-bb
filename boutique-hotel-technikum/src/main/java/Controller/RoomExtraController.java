package Controller;

import DTO.RoomExtraDTO;
import Model.ExtraType;
import Model.RoomExtra;
import Service.RoomExtraService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room_extras")
public class RoomExtraController {
    @Autowired
    private RoomExtraService roomExtraService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public RoomExtraDTO createRoomExtra(@RequestBody RoomExtraDTO roomExtraDTO) {
        RoomExtra roomExtra = modelMapper.map(roomExtraDTO, RoomExtra.class);
        return modelMapper.map(roomExtraService.createRoomExtra(roomExtra), RoomExtraDTO.class);
    }

    @GetMapping("/{roomId}")
    public List<ExtraType> getAllRoomExtras(@PathVariable int roomId) {
        return roomExtraService.getAllRoomExtrasByRoomId(roomId);
    }

    @PutMapping
    public RoomExtraDTO updateRoomExtra(@RequestBody RoomExtraDTO roomExtraDTO) throws NotFoundException {
        RoomExtra roomExtra = modelMapper.map(roomExtraDTO, RoomExtra.class);
        return modelMapper.map(roomExtraService.updateRoomExtra(roomExtra), RoomExtraDTO.class);
    }
}
