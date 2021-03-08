package stoylan.spring.jokesapp.Config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ChuckNorrisConfig {

  //  @Bean
    public ChuckNorrisQuotes chuckNorrisQuotes(){
        return new ChuckNorrisQuotes();
    }
}
