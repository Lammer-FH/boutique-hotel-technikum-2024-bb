package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.ExtraType;
import com.awt.boutiquehoteltechnikum.Entities.RoomExtra;

import java.util.List;

public interface RoomExtraServiceInterface {
    RoomExtra createRoomExtra(RoomExtra roomExtra);

    RoomExtra updateRoomExtra(RoomExtra roomExtra);

    List<ExtraType> getAllRoomExtrasByRoomId(int room_Id);
}
