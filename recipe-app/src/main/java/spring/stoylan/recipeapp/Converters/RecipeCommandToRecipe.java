package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.commands.CategoryCommand;
import spring.stoylan.recipeapp.commands.RecipeCommands;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommands, Recipe> {
    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NoteCommandToNote notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NoteCommandToNote notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }


    @Override
    public Recipe convert(RecipeCommands recipeCommands) {
        if (recipeCommands == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setID(recipeCommands.getID());
        recipe.setCookTime(recipeCommands.getCookTime());
        recipe.setPrepTime(recipeCommands.getPrepTime());
        recipe.setDescription(recipeCommands.getDescription());
        recipe.setDifficulty(recipeCommands.getDifficulty());
        recipe.setDirections(recipeCommands.getDirections());
        recipe.setServings(recipeCommands.getServings());
        recipe.setSource(recipeCommands.getSource());
        recipe.setUrl(recipeCommands.getUrl());
        recipe.setNote(notesConverter.convert(recipeCommands.getNotesCommand()));
        if (recipeCommands.getCategoryCommandSet() != null && recipeCommands.getCategoryCommandSet().size() > 0) {
            for (CategoryCommand x : recipeCommands.getCategoryCommandSet()) {
                recipe.getCategories().add(categoryConverter.convert(x));
            }
        }

        if (recipeCommands.getIngredientCommandSet() != null && recipeCommands.getIngredientCommandSet().size() > 0){
            recipeCommands.getIngredientCommandSet()
                    .forEach(ingredient -> recipe.getIngredient().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
