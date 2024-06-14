package com.awt.boutiquehoteltechnikum.Controller;

import com.awt.boutiquehoteltechnikum.DTO.ExtraTypeDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.RoomExtraRequestDTO;
import com.awt.boutiquehoteltechnikum.DTO.RoomExtraDTO;
import com.awt.boutiquehoteltechnikum.Interfaces.RoomExtraServiceInterface;
import com.awt.boutiquehoteltechnikum.Mapper.ExtraTypeMapper;
import com.awt.boutiquehoteltechnikum.Mapper.RoomExtraMapper;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtraEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/v1/room_extras")
public class RoomExtraController {
    @Autowired
    private RoomExtraServiceInterface roomExtraService;

    @PostMapping
    public RoomExtraDTO createRoomExtra(@RequestBody RoomExtraRequestDTO roomExtraDTO) {
        RoomExtraEntity roomExtraEntity = RoomExtraMapper.INSTANCE.roomExtraRequestDTOtoRoomExtra(roomExtraDTO);
        return RoomExtraMapper.INSTANCE.roomExtratoRoomExtraDTO(roomExtraService.createRoomExtra(roomExtraEntity));
    }

    @GetMapping("/{roomId}")
    public List<ExtraTypeDTO> getAllRoomExtras(@PathVariable int roomId) {
        return ExtraTypeMapper.INSTANCE.extraTypeListToExtraTypeDTOList(roomExtraService.getAllRoomExtrasByRoomId(roomId));
    }

    @PutMapping
    public RoomExtraDTO updateRoomExtra(@RequestBody RoomExtraDTO roomExtraDTO) {
        RoomExtraEntity roomExtraEntity = RoomExtraMapper.INSTANCE.roomExtraDTOtoRoomExtra(roomExtraDTO);
        return RoomExtraMapper.INSTANCE.roomExtratoRoomExtraDTO(roomExtraService.updateRoomExtra(roomExtraEntity));
    }
}
