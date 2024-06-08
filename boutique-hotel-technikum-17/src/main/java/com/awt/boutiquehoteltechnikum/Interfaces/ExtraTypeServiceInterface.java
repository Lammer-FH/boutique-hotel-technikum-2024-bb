package com.awt.boutiquehoteltechnikum.Interfaces;

import com.awt.boutiquehoteltechnikum.Model.ExtraType;

import java.util.List;

public interface ExtraTypeServiceInterface {
    ExtraType createExtraType(ExtraType extraType);

    ExtraType updateExtraType(ExtraType extraType);

    ExtraType getExtraTypeById(int id);

    List<ExtraType> getAllExtraTypes();
}
