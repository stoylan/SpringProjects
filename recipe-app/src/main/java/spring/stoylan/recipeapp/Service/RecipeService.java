package spring.stoylan.recipeapp.Service;

import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.commands.RecipeCommands;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipe();
    Recipe getRecipeById(Long id);
    RecipeCommands saveRecipeCommand(RecipeCommands recipeCommands);

}
