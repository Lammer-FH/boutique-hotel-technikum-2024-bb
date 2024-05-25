package awt.bb2024.Repository;

import awt.bb2024.Model.ExtraType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraTypeRepository extends CrudRepository<ExtraType, Integer> {
}
