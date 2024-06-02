package awt.bb2024.Controller;

import awt.bb2024.DTO.RoomExtraDTO;
import awt.bb2024.Model.ExtraType;
import awt.bb2024.Model.RoomExtra;
import awt.bb2024.Service.RoomExtraService;
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
