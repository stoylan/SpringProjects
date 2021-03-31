package spring.stoylan.recipeapp.Converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;
import spring.stoylan.recipeapp.commands.UnitOfMeasureCommands;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUniteOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureToUniteOfMeasureCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUniteOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);
        //when
        UnitOfMeasureCommands uomc = converter.convert(uom);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }

}