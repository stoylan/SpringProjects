package spring.stoylan.recipeapp.Repository;

import org.springframework.data.repository.CrudRepository;
import spring.stoylan.recipeapp.Domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
