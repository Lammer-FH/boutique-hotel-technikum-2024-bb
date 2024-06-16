package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateRoomCommand;
import com.awt.boutiquehoteltechnikum.Entities.RoomEntity;
import com.awt.boutiquehoteltechnikum.Mapper.RoomMapper;
import com.awt.boutiquehoteltechnikum.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements com.awt.boutiquehoteltechnikum.Interfaces.RoomServiceInterface {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomEntity createRoom(CreateRoomCommand createRoomCommand) {
        return roomRepository.save(RoomMapper.INSTANCE.createRoomCommandToRoomEntity(createRoomCommand));
    }

    @Override
    public RoomEntity updateRoom(RoomEntity roomEntity)  {
        Optional<RoomEntity> optionalRoom = roomRepository.findById(roomEntity.getId());
        if (optionalRoom.isPresent()) {
            RoomEntity existingRoomEntity = optionalRoom.get();
            existingRoomEntity.setTitle(roomEntity.getTitle());
            existingRoomEntity.setDescription(roomEntity.getDescription());
            existingRoomEntity.setPrice(roomEntity.getPrice());
            existingRoomEntity.setRoomType(roomEntity.getRoomType());
            existingRoomEntity.setBedType(roomEntity.getBedType());
            existingRoomEntity.setBedCount(roomEntity.getBedCount());
            existingRoomEntity.setImage(roomEntity.getImage());
            return roomRepository.save(existingRoomEntity);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "roomId not found"
        );
    }

    @Override
    public RoomEntity getRoomById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"roomId not found"));
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return (List<RoomEntity>) roomRepository.findAll();
    }
}
