package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.RoomEntity;

import java.util.List;

public interface RoomServiceInterface {
    RoomEntity createRoom(RoomEntity roomEntity);

    RoomEntity updateRoom(RoomEntity roomEntity);

    RoomEntity getRoomById(int id);

    List<RoomEntity> getAllRooms();
}
