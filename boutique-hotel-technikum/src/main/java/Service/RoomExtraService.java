package Service;

import Model.ExtraType;
import Model.RoomExtra;
import Repository.ExtraTypeRepository;
import Repository.RoomExtraRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomExtraService {
    @Autowired
    private RoomExtraRepository roomExtraRepository;
    @Autowired
    private ExtraTypeRepository extraTypeRepository;

    public RoomExtra createRoomExtra(RoomExtra roomExtra) {
        return roomExtraRepository.save(roomExtra);
    }

    public RoomExtra updateRoomExtra(RoomExtra roomExtra) throws NotFoundException {
        Optional<RoomExtra> optionalRoomExtra = roomExtraRepository.findById(roomExtra.getId());
        if (optionalRoomExtra.isPresent()) {
            RoomExtra existingRoomExtra = optionalRoomExtra.get();
            existingRoomExtra.setRoom_id(roomExtra.getRoom_id());
            existingRoomExtra.setExtra_id(roomExtra.getExtra_id());
            return roomExtraRepository.save(existingRoomExtra);
        } else {
            throw new NotFoundException("Room Extra not found with id: " + roomExtra.getId());
        }
    }

    public List<ExtraType> getAllRoomExtrasByRoomId(int roomId) {
        List<RoomExtra> roomExtras = roomExtraRepository.findAllByRoomId(roomId);
        List<ExtraType> extraTypes = null;
        if (roomExtras != null) {
            extraTypes = new ArrayList<>();
            for (RoomExtra roomExtra : roomExtras) {
                Optional<ExtraType> extraType = extraTypeRepository.findById(roomExtra.getExtra_id());
                extraType.ifPresent(extraTypes::add);
            }
        }
        return extraTypes;
    }
}
