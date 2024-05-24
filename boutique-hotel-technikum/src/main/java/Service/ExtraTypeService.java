package Service;

import Model.ExtraType;
import Repository.ExtraTypeRepository;
import javassist.NotFoundException;
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

    public ExtraType updateExtraType(ExtraType extraType) throws NotFoundException {
        Optional<ExtraType> optionalExtraType = extraTypeRepository.findById(extraType.getId());
        if (optionalExtraType.isPresent()) {
            ExtraType existingExtraType = optionalExtraType.get();
            existingExtraType.setTitle(extraType.getTitle());
            existingExtraType.setDescription(extraType.getDescription());
            return extraTypeRepository.save(existingExtraType);
        } else {
            throw new NotFoundException("Extra Type not found with id: " + extraType.getId());
        }
    }

    public ExtraType getExtraTypeById(int id) throws NotFoundException {
        return extraTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Extra Type not found with id: " + id));
    }

    public List<ExtraType> getAllExtraTypes() {
        return (List<ExtraType>) extraTypeRepository.findAll();
    }
}
