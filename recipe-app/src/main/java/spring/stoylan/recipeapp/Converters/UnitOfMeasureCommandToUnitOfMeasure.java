package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;
import spring.stoylan.recipeapp.commands.UnitOfMeasureCommands;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommands, UnitOfMeasure> {
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommands unitOfMeasureCommands) {
        if (unitOfMeasureCommands == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(unitOfMeasureCommands.getId());
        uom.setDescription(unitOfMeasureCommands.getDescription());
        return uom;
    }
}
