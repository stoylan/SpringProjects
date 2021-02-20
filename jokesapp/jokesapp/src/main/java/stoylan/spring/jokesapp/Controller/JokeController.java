package stoylan.spring.jokesapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stoylan.spring.jokesapp.Services.JokeService;

@Controller
public class JokeController {
    private final JokeService jokeService;


    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }


    @RequestMapping("/jokes")
    public String showJoke(Model model){
        model.addAttribute("joke",jokeService.getJoke());

        return "index";
    }

    public JokeService getJokeService() {
        return jokeService;
    }
}
