package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.Room;

import java.util.List;

public interface RoomServiceInterface {
    Room createRoom(Room room);

    Room updateRoom(Room room);

    Room getRoomById(int id);

    List<Room> getAllRooms();
}
