package spring.stoylan.recipeapp.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.Note;
import spring.stoylan.recipeapp.commands.NotesCommand;

@Component
public class NoteToNoteCommand implements Converter<Note, NotesCommand> {
    @Override
    public NotesCommand convert(Note note) {
        if (note == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(note.getId());
        notesCommand.setRecipeNotes(note.getRecipeNotes());
        return notesCommand;
    }
}
