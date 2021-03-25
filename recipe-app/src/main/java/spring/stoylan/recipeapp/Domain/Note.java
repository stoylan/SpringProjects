package spring.stoylan.recipeapp.Domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

    public Note() {
    }


}
