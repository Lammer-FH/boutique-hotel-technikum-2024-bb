package com.awt.boutiquehoteltechnikum.Service;

import com.awt.boutiquehoteltechnikum.DomainModels.CreateExtraTypeCommand;
import com.awt.boutiquehoteltechnikum.Entities.ExtraTypeEntity;
import com.awt.boutiquehoteltechnikum.Mapper.ExtraTypeMapper;
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
    public ExtraTypeEntity createExtraType(CreateExtraTypeCommand createExtraTypeCommand) {
        ExtraTypeEntity extraTypeEntity = ExtraTypeMapper.INSTANCE.createExtraTypeCommandToExtraType(createExtraTypeCommand);
        return extraTypeRepository.save(extraTypeEntity);
    }

    @Override
    public ExtraTypeEntity updateExtraType(ExtraTypeEntity extraTypeEntity)  {
        Optional<ExtraTypeEntity> optionalExtraType = extraTypeRepository.findById(extraTypeEntity.getId());
        if (optionalExtraType.isPresent()) {
            ExtraTypeEntity existingExtraTypeEntity = optionalExtraType.get();
            existingExtraTypeEntity.setTitle(extraTypeEntity.getTitle());
            existingExtraTypeEntity.setDescription(extraTypeEntity.getDescription());
            return extraTypeRepository.save(existingExtraTypeEntity);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"extraType not found not found");
    }

    @Override
    public ExtraTypeEntity getExtraTypeById(int id) {

        return extraTypeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"extraType not found"));
    }

    @Override
    public List<ExtraTypeEntity> getAllExtraTypes() {
        return (List<ExtraTypeEntity>) extraTypeRepository.findAll();
    }
}
