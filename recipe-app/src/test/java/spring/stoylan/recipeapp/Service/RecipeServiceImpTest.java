package spring.stoylan.recipeapp.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spring.stoylan.recipeapp.Domain.Recipe;
import spring.stoylan.recipeapp.Repository.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImpTest {

    @InjectMocks
    RecipeServiceImp recipeServiceImp;

    @Mock
    RecipeRepository recipeRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRecipe() {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipeSet = recipeServiceImp.getRecipe();
        assertEquals(recipeSet.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }
    @Test
    void getRecipeById(){
        Recipe recipe = new Recipe();
        recipe.setID(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe foundrecipe = recipeServiceImp.getRecipeById(1L);
        assertEquals(foundrecipe.getID(),recipe.getID());
        verify(recipeRepository,times(1)).findById(1L);

    }
}