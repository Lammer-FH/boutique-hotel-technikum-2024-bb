package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Model.ExtraType;
import com.awt.boutiquehoteltechnikum.Model.RoomExtra;

import java.util.List;

public interface RoomExtraServiceInterface {
    RoomExtra createRoomExtra(RoomExtra roomExtra);

    RoomExtra updateRoomExtra(RoomExtra roomExtra);

    List<ExtraType> getAllRoomExtrasByRoomId(int room_Id);
}
