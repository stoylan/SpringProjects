package spring.stoylan.recipeapp.Converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;
import spring.stoylan.recipeapp.commands.UnitOfMeasureCommands;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommands()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasureCommands command = new UnitOfMeasureCommands();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }
}