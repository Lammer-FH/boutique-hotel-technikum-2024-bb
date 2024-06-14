package com.awt.boutiquehoteltechnikum.Repository;

import com.awt.boutiquehoteltechnikum.Entities.RoomExtra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomExtraRepository extends CrudRepository<RoomExtra, Integer> {
    List<RoomExtra> findAllByRoomId(int roomId);
}
