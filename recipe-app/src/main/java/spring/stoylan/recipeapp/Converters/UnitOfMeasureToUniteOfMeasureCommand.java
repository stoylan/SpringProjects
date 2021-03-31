package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;
import spring.stoylan.recipeapp.commands.UnitOfMeasureCommands;

@Component
public class UnitOfMeasureToUniteOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommands> {
    @Override
    public UnitOfMeasureCommands convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure != null) {
            final UnitOfMeasureCommands uomc = new UnitOfMeasureCommands();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
            return uomc;
        }
        return null;
    }
}
