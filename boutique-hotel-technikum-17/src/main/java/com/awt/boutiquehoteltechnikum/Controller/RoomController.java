package com.awt.boutiquehoteltechnikum.Controller;


import com.awt.boutiquehoteltechnikum.DTO.RoomDTO;
import com.awt.boutiquehoteltechnikum.Mapper.RoomMapper;
import com.awt.boutiquehoteltechnikum.Model.Room;
import com.awt.boutiquehoteltechnikum.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {
        Room room = RoomMapper.INSTANCE.roomDTOtoRoom(roomDTO);
        return RoomMapper.INSTANCE.roomtoRoomDTO(room);
    }

    @GetMapping("/{roomId}")
    public RoomDTO getRoom(@PathVariable int roomId) {
        return RoomMapper.INSTANCE.roomtoRoomDTO(roomService.getRoomById(roomId));
    }

    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms().stream()
                .map(room -> RoomMapper.INSTANCE.roomtoRoomDTO(room))
                .collect(Collectors.toList());
    }

    @PutMapping
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO) {
        Room room = RoomMapper.INSTANCE.roomDTOtoRoom(roomDTO);
        return RoomMapper.INSTANCE.roomtoRoomDTO(roomService.updateRoom(room));
    }
}
