package com.awt.boutiquehoteltechnikum.Service;


import com.awt.boutiquehoteltechnikum.DomainModels.CreateRoomExtraCommand;
import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import com.awt.boutiquehoteltechnikum.Entities.RoomEntity;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtraEntity;
import com.awt.boutiquehoteltechnikum.Mapper.ExtraTypeMapper;
import com.awt.boutiquehoteltechnikum.Mapper.RoomExtraMapper;
import com.awt.boutiquehoteltechnikum.Repository.ExtraTypeRepository;
import com.awt.boutiquehoteltechnikum.Repository.RoomExtraRepository;
import com.awt.boutiquehoteltechnikum.Repository.RoomRepository;
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
    private RoomRepository roomRepository;
    @Autowired
    private ExtraTypeRepository extraTypeRepository;

    @Override
    public RoomExtraEntity createRoomExtra(CreateRoomExtraCommand createRoomExtraCommand) {
        RoomExtraEntity roomExtraEntity = RoomExtraMapper.INSTANCE.createRoomExtraCommandToRoomExtraEntity(createRoomExtraCommand);
        RoomEntity room = roomRepository.findById(createRoomExtraCommand.getRoomId()).get();
        ExtraTypeEntity extraType = extraTypeRepository.findById(createRoomExtraCommand.getExtraId()).get();
        roomExtraEntity.setExtraTypeEntity(extraType);
        roomExtraEntity.setRoomEntity(room);
        return roomExtraRepository.save(roomExtraEntity);
    }

    @Override
    public RoomExtraEntity updateRoomExtra(RoomExtraEntity roomExtraEntity) {
        Optional<RoomExtraEntity> optionalRoomExtra = roomExtraRepository.findById(roomExtraEntity.getId());
            RoomExtraEntity existingRoomExtraEntity = optionalRoomExtra.get();
            existingRoomExtraEntity.setRoomEntity(roomExtraEntity.getRoomEntity());
            existingRoomExtraEntity.setExtraTypeEntity(roomExtraEntity.getExtraTypeEntity());
            return roomExtraRepository.save(existingRoomExtraEntity);
    }

    @Override
    public List<ExtraTypeEntity> getAllRoomExtrasByRoomId(int room_Id) {
        List<RoomExtraEntity> roomExtraEntities = roomExtraRepository.findAllByRoomEntityId(room_Id);
        List<ExtraTypeEntity> extraTypeEntities = null;
        if (roomExtraEntities != null) {
            extraTypeEntities = new ArrayList<>();
            for (RoomExtraEntity roomExtraEntity : roomExtraEntities) {
                Optional<ExtraTypeEntity> extraType = extraTypeRepository.findById(roomExtraEntity.getExtraTypeEntity().getId());
                extraType.ifPresent(extraTypeEntities::add);
            }
        }
        return extraTypeEntities;
    }
}
