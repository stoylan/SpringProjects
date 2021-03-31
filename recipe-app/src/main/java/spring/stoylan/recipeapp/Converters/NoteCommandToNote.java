package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.Note;
import spring.stoylan.recipeapp.commands.NotesCommand;

@Component
public class NoteCommandToNote implements Converter<NotesCommand, Note> {

    @Override
    public Note convert(NotesCommand notesCommand) {
        if(notesCommand == null) {
            return null;
        }

        final Note notes = new Note();
        notes.setId(notesCommand.getId());
        notes.setRecipeNotes(notesCommand.getRecipeNotes());
        return notes;
    }
}
