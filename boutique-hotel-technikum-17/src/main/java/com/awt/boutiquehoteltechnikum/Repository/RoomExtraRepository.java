package com.awt.boutiquehoteltechnikum.Repository;

import com.awt.boutiquehoteltechnikum.Entities.RoomExtraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomExtraRepository extends CrudRepository<RoomExtraEntity, Integer> {
    List<RoomExtraEntity> findAllByRoomId(int roomId);
}
