package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.Category;
import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.commands.RecipeCommands;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommands> {
    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NoteToNoteCommand noteConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter, NoteToNoteCommand noteConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.noteConverter = noteConverter;
    }


    @Override
    public RecipeCommands convert(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        final RecipeCommands command = new RecipeCommands();
        command.setID(recipe.getID());
        command.setCookTime(recipe.getCookTime());
        command.setPrepTime(recipe.getPrepTime());
        command.setDescription(recipe.getDescription());
        command.setDifficulty(recipe.getDifficulty());
        command.setDirections(recipe.getDirections());
        command.setServings(recipe.getServings());
        command.setSource(recipe.getSource());
        command.setUrl(recipe.getUrl());
        command.setNotesCommand(noteConverter.convert(recipe.getNote()));

        if (recipe.getCategories() != null && recipe.getCategories().size() > 0){
            recipe.getCategories()
                    .forEach((Category category) -> command.getCategoryCommandSet().add(categoryConverter.convert(category)));
        }

        if (recipe.getIngredient() != null && recipe.getIngredient().size() > 0){
            recipe.getIngredient()
                    .forEach(ingredient -> command.getIngredientCommandSet().add(ingredientConverter.convert(ingredient)));
        }

        return command;
    }
}
