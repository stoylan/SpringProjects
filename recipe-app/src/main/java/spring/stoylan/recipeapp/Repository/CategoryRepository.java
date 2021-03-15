package spring.stoylan.recipeapp.Repository;

import org.springframework.data.repository.CrudRepository;
import spring.stoylan.recipeapp.Domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByDescription(String Description);


}
