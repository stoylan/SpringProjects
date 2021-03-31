package spring.stoylan.recipeapp.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.Repository.RecipeRepository;
import spring.stoylan.recipeapp.commands.RecipeCommands;
import spring.stoylan.recipeapp.Converters.RecipeCommandToRecipe;
import spring.stoylan.recipeapp.Converters.RecipeToRecipeCommand;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    public RecipeServiceImp(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipe() {
        log.debug("I'm in the service");
        Set<Recipe> receipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(receipes::add);
        return receipes;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        log.debug("I'm in the service");
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommands saveRecipeCommand(RecipeCommands recipeCommands) {
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommands);

        Recipe savedRecipe = recipeRepository.save(recipe);
        log.debug("Saved RecipeId : " + savedRecipe.getID());

        return recipeToRecipeCommand.convert(savedRecipe);
    }


}
