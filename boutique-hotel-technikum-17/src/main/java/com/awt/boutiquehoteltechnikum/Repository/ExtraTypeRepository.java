package com.awt.boutiquehoteltechnikum.Repository;

import com.awt.boutiquehoteltechnikum.Model.ExtraType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraTypeRepository extends CrudRepository<ExtraType, Integer> {
}
