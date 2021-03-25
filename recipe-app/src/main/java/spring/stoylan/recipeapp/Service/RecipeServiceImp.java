package spring.stoylan.recipeapp.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.Repository.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipe() {
        log.debug("I'm in the service");
        Set<Recipe> receipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(receipes::add);
        return receipes;
    }
}
