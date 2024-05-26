package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Model.ExtraType;
import com.awt.boutiquehoteltechnikum.Repository.ExtraTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraTypeService {
    @Autowired
    private ExtraTypeRepository extraTypeRepository;

    public ExtraType createExtraType(ExtraType extraType) {
        return extraTypeRepository.save(extraType);
    }

    public ExtraType updateExtraType(ExtraType extraType)  {
        Optional<ExtraType> optionalExtraType = extraTypeRepository.findById(extraType.getId());
        //if (optionalExtraType.isPresent()) {
            ExtraType existingExtraType = optionalExtraType.get();
            existingExtraType.setTitle(extraType.getTitle());
            existingExtraType.setDescription(extraType.getDescription());
            return extraTypeRepository.save(existingExtraType);
        //}
    }

    public ExtraType getExtraTypeById(int id) {
        return extraTypeRepository.findById(id);
    }

    public List<ExtraType> getAllExtraTypes() {
        return (List<ExtraType>) extraTypeRepository.findAll();
    }
}
