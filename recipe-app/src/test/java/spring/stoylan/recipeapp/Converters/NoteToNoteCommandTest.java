package spring.stoylan.recipeapp.Converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.stoylan.recipeapp.Domain.Note;
import spring.stoylan.recipeapp.commands.NotesCommand;

import static org.junit.jupiter.api.Assertions.*;

class NoteToNoteCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NoteToNoteCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new NoteToNoteCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note notes = new Note();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand notesCommand = converter.convert(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }
}