package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Model.Room;
import com.awt.boutiquehoteltechnikum.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room)  {
        Optional<Room> optionalRoom = roomRepository.findById(room.getId());
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setTitle(room.getTitle());
            existingRoom.setDescription(room.getDescription());
            existingRoom.setPrice(room.getPrice());
            existingRoom.setRoom_type(room.getRoom_type());
            existingRoom.setBed_type(room.getBed_type());
            existingRoom.setBed_count(room.getBed_count());
            existingRoom.setImage(room.getImage());
            return roomRepository.save(existingRoom);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "roomId not found"
        );
    }

    public Room getRoomById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"roomId not found"));
    }

    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }
}
