package spring.stoylan.recipeapp.BootStrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.stoylan.recipeapp.Domain.*;
import spring.stoylan.recipeapp.Repository.CategoryRepository;
import spring.stoylan.recipeapp.Repository.RecipeRepository;
import spring.stoylan.recipeapp.Repository.UnitOfMeasureRepository;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading Bootstrap Data");
    }
    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<Category> mexicanCategory = categoryRepository.findByDescription("Mexican");
        Optional<Category> americanCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");
        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");
        Optional<UnitOfMeasure> each = unitOfMeasureRepository.findByDescription("Each");
        Category american = mexicanCategory.get();
        Category mexican = americanCategory.get();

        Recipe guatamala = new Recipe();
        guatamala.setCookTime(0);
        guatamala.setDescription("Guatamala");
        guatamala.setDifficulty(Difficulty.EASY);
        guatamala.setDirections("Cut the avocado, remove flesh:\n Mash with a fork:\n Add salt, lime juice, and the rest:\n Serve:\n");
        guatamala.setPrepTime(10);
        guatamala.setServings(4);
        guatamala.setSource("simplyrecipes");
        guatamala.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guatamala.getCategories().add(american);
        guatamala.getCategories().add(mexican);
        guatamala.addIngredient(new Ingredient("ripe avacados",new BigDecimal(2),each.get()));
        guatamala.addIngredient(new Ingredient("Kosher salt",new BigDecimal(0.5),teaspoon.get()));
        guatamala.addIngredient(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(2),tablespoon.get()));
        guatamala.addIngredient(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2),each.get()));
        guatamala.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced",new BigDecimal(2),tablespoon.get()));
        guatamala.getCategories().add(americanCategory.get());

        Note note = new Note();

        note.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.\n");
        guatamala.setNote(note);

        recipes.add(guatamala);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Note tacoNotes = new Note();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacosRecipe.setNote(tacoNotes);


        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1),  teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1),  teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"),  teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), each.get()));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2),  tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4),  tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8),  each.get()));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3),  cup.get()));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2),  each.get()));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4),  each.get()));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"),  each.get()));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"),  each.get()));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4),  each.get()));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4),  cup.get()));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4),  each.get()));

        tacosRecipe.getCategories().add(american);
        tacosRecipe.getCategories().add(mexican);

        recipes.add(tacosRecipe);
        return recipes;
    }


}
