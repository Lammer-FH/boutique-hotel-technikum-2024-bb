package com.awt.boutiquehoteltechnikum.Controller;


import com.awt.boutiquehoteltechnikum.DTO.Request.RoomRequestDTO;
import com.awt.boutiquehoteltechnikum.DTO.RoomDTO;
import com.awt.boutiquehoteltechnikum.Interfaces.RoomServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.RoomMapper;
import com.awt.boutiquehoteltechnikum.Entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotel/v1/rooms")
public class RoomController {
    @Autowired
    private RoomServiceInterface roomService;

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomRequestDTO roomDTO) {
        Room room = RoomMapper.INSTANCE.roomReqestDTOtoRoom(roomDTO);
        return RoomMapper.INSTANCE.roomtoRoomDTO(roomService.createRoom(room));
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
