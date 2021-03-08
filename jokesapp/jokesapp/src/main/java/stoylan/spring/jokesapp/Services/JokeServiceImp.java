package stoylan.spring.jokesapp.Services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImp implements JokeService {
    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImp(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }


}
