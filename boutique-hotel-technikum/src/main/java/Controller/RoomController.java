package Controller;

import DTO.RoomDTO;
import Model.Room;
import Service.RoomService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {
        Room room = modelMapper.map(roomDTO, Room.class);
        return modelMapper.map(roomService.createRoom(room), RoomDTO.class);
    }

    @GetMapping("/{roomId}")
    public RoomDTO getRoom(@PathVariable int roomId) throws NotFoundException {
        return  modelMapper.map(roomService.getRoomById(roomId), RoomDTO.class);
    }

    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms().stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO) throws NotFoundException {
        Room room = modelMapper.map(roomDTO, Room.class);
        return modelMapper.map(roomService.updateRoom(room), RoomDTO.class);
    }
}
