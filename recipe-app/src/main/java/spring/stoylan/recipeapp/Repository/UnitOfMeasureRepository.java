package spring.stoylan.recipeapp.Repository;

import org.springframework.data.repository.CrudRepository;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
}
