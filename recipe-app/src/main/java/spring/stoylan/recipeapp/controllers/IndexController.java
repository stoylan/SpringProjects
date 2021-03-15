package spring.stoylan.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.stoylan.recipeapp.Domain.Category;
import spring.stoylan.recipeapp.Domain.UnitOfMeasure;
import spring.stoylan.recipeapp.Repository.CategoryRepository;
import spring.stoylan.recipeapp.Repository.UnitOfMeasureRepository;
import spring.stoylan.recipeapp.Service.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"index","","/"})
    public String getIndex(Model model){
        model.addAttribute("Recipe",recipeService.getRecipe());
        return "index";
    }
}
