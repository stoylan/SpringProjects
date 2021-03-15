package spring.stoylan.recipeapp.Service;

import spring.stoylan.recipeapp.Domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipe();
}
