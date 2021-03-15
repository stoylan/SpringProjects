package spring.stoylan.recipeapp.Repository;

import org.springframework.data.repository.CrudRepository;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
