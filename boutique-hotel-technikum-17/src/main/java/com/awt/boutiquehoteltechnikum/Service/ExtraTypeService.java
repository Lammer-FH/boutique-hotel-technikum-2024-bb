package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.Model.ExtraType;
import com.awt.boutiquehoteltechnikum.Repository.ExtraTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraTypeService implements com.awt.boutiquehoteltechnikum.Interfaces.ExtraTypeServiceInterface {
    @Autowired
    private ExtraTypeRepository extraTypeRepository;

    @Override
    public ExtraType createExtraType(ExtraType extraType) {
        return extraTypeRepository.save(extraType);
    }

    @Override
    public ExtraType updateExtraType(ExtraType extraType)  {
        Optional<ExtraType> optionalExtraType = extraTypeRepository.findById(extraType.getId());
        if (optionalExtraType.isPresent()) {
            ExtraType existingExtraType = optionalExtraType.get();
            existingExtraType.setTitle(extraType.getTitle());
            existingExtraType.setDescription(extraType.getDescription());
            return extraTypeRepository.save(existingExtraType);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"extraType not found not found");
    }

    @Override
    public ExtraType getExtraTypeById(int id) {

        return extraTypeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"extraType not found"));
    }

    @Override
    public List<ExtraType> getAllExtraTypes() {
        return (List<ExtraType>) extraTypeRepository.findAll();
    }
}
