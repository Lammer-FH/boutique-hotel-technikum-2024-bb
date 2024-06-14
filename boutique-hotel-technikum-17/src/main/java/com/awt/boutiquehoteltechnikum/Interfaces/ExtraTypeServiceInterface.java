package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;

import java.util.List;

public interface ExtraTypeServiceInterface {
    ExtraTypeEntity createExtraType(ExtraTypeEntity extraTypeEntity);

    ExtraTypeEntity updateExtraType(ExtraTypeEntity extraTypeEntity);

    ExtraTypeEntity getExtraTypeById(int id);

    List<ExtraTypeEntity> getAllExtraTypes();
}
