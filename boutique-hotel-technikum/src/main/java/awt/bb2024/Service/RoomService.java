package awt.bb2024.Service;

import awt.bb2024.Model.Room;
import awt.bb2024.Repository.RoomRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) throws NotFoundException {
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
        } else {
            throw new NotFoundException("Room not found with id: " + room.getId());
        }
    }

    public Room getRoomById(int id) throws NotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Room not found with id: " + id));
    }

    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }
}
