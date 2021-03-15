package spring.stoylan.recipeapp.Service;

import org.springframework.stereotype.Service;
import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.Repository.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImp implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipe() {
        Set<Recipe> receipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(receipes::add);
        return receipes;
    }
}
