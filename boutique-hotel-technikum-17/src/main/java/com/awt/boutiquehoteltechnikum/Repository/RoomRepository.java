package com.awt.boutiquehoteltechnikum.Repository;

import com.awt.boutiquehoteltechnikum.Entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
}
