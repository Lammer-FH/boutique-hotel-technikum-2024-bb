package com.awt.boutiquehoteltechnikum.Service;


import com.awt.boutiquehoteltechnikum.Entities.ExtraType;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtra;
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
    public RoomExtra createRoomExtra(RoomExtra roomExtra) {
        return roomExtraRepository.save(roomExtra);
    }

    @Override
    public RoomExtra updateRoomExtra(RoomExtra roomExtra) {
        Optional<RoomExtra> optionalRoomExtra = roomExtraRepository.findById(roomExtra.getId());
            RoomExtra existingRoomExtra = optionalRoomExtra.get();
            existingRoomExtra.setRoomId(roomExtra.getRoomId());
            existingRoomExtra.setExtraId(roomExtra.getExtraId());
            return roomExtraRepository.save(existingRoomExtra);
    }

    @Override
    public List<ExtraType> getAllRoomExtrasByRoomId(int room_Id) {
        List<RoomExtra> roomExtras = roomExtraRepository.findAllByRoomId(room_Id);
        List<ExtraType> extraTypes = null;
        if (roomExtras != null) {
            extraTypes = new ArrayList<>();
            for (RoomExtra roomExtra : roomExtras) {
                Optional<ExtraType> extraType = extraTypeRepository.findById(roomExtra.getExtraId());
                extraType.ifPresent(extraTypes::add);
            }
        }
        return extraTypes;
    }
}
