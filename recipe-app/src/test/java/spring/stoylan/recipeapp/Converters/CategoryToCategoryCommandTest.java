package spring.stoylan.recipeapp.Converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.stoylan.recipeapp.Domain.Category;
import spring.stoylan.recipeapp.commands.CategoryCommand;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "descript";
    CategoryToCategoryCommand convter;

    @BeforeEach
    public void setUp() throws Exception {
        convter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(convter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = convter.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());

    }
}