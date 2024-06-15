package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateRoomExtraCommand;
import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtraEntity;

import java.util.List;

public interface RoomExtraServiceInterface {
    RoomExtraEntity createRoomExtra(CreateRoomExtraCommand roomExtraEntity);

    RoomExtraEntity updateRoomExtra(RoomExtraEntity roomExtraEntity);

    List<ExtraTypeEntity> getAllRoomExtrasByRoomId(int room_Id);
}
