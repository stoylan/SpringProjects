package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.Ingredient;
import spring.stoylan.recipeapp.commands.IngredientCommand;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final UnitOfMeasureToUniteOfMeasureCommand unitOfMeasureToUniteOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUniteOfMeasureCommand unitOfMeasureToUniteOfMeasureCommand) {
        this.unitOfMeasureToUniteOfMeasureCommand = unitOfMeasureToUniteOfMeasureCommand;
    }

    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient ==null)
            return null;
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setUnitOfMeasure(unitOfMeasureToUniteOfMeasureCommand.convert(ingredient.getUnitOfMeasure()));
        return ingredientCommand;
    }
}
