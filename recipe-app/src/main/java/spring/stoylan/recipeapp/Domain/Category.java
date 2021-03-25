package spring.stoylan.recipeapp.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Category() {
    }


    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

}
