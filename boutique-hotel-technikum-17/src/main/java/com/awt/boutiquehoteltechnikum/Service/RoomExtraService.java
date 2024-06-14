package com.awt.boutiquehoteltechnikum.Service;


import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtraEntity;
import com.awt.boutiquehoteltechnikum.Repository.ExtraTypeRepository;
import com.awt.boutiquehoteltechnikum.Repository.RoomExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomExtraService implements com.awt.boutiquehoteltechnikum.Interfaces.RoomExtraServiceInterface {
    @Autowired
    private RoomExtraRepository roomExtraRepository;
    @Autowired
    private ExtraTypeRepository extraTypeRepository;

    @Override
    public RoomExtraEntity createRoomExtra(RoomExtraEntity roomExtraEntity) {
        return roomExtraRepository.save(roomExtraEntity);
    }

    @Override
    public RoomExtraEntity updateRoomExtra(RoomExtraEntity roomExtraEntity) {
        Optional<RoomExtraEntity> optionalRoomExtra = roomExtraRepository.findById(roomExtraEntity.getId());
            RoomExtraEntity existingRoomExtraEntity = optionalRoomExtra.get();
            existingRoomExtraEntity.setRoomId(roomExtraEntity.getRoomId());
            existingRoomExtraEntity.setExtraId(roomExtraEntity.getExtraId());
            return roomExtraRepository.save(existingRoomExtraEntity);
    }

    @Override
    public List<ExtraTypeEntity> getAllRoomExtrasByRoomId(int room_Id) {
        List<RoomExtraEntity> roomExtraEntities = roomExtraRepository.findAllByRoomId(room_Id);
        List<ExtraTypeEntity> extraTypeEntities = null;
        if (roomExtraEntities != null) {
            extraTypeEntities = new ArrayList<>();
            for (RoomExtraEntity roomExtraEntity : roomExtraEntities) {
                Optional<ExtraTypeEntity> extraType = extraTypeRepository.findById(roomExtraEntity.getExtraId());
                extraType.ifPresent(extraTypeEntities::add);
            }
        }
        return extraTypeEntities;
    }
}
