package spring.stoylan.recipeapp.Repository;

import org.springframework.data.repository.CrudRepository;
import spring.stoylan.recipeapp.Domain.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
