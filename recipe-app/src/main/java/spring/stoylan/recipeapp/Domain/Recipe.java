package spring.stoylan.recipeapp.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Note note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredient = new HashSet<>();
    @ManyToMany
    @JoinTable(name="recipe_category",
            joinColumns = @JoinColumn(name ="recipe_id"),inverseJoinColumns = @JoinColumn(name ="category_id"))
    private Set<Category> categories = new HashSet<>();


    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.getIngredient().add(ingredient);
        return this;
    }
}
