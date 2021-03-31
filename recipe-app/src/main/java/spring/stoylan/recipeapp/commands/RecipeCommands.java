package spring.stoylan.recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.stoylan.recipeapp.Domain.Difficulty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommands {
    private Long ID;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<IngredientCommand> ingredientCommandSet = new HashSet<>();
    private NotesCommand notesCommand;
    private Set<CategoryCommand> categoryCommandSet = new HashSet<>();

}
