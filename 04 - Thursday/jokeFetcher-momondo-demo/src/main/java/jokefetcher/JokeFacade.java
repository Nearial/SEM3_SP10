package jokefetcher;

import com.google.gson.Gson;
import jokefetcher.ChuckDTO;
import jokefetcher.DadDTO;
import java.io.IOException;
import java.util.HashMap;
import utils.HttpUtils;

/**
 *
 * @author Nikolaj Larsen
 */
public class JokeFacade {
    
    
    public static HashMap<String, String> getJokes() throws IOException {
        String joke1, joke1Reference, joke2, joke2Reference;
        HashMap jokes = new HashMap<String, String>();
                
        joke1 = new Gson().fromJson(HttpUtils.fetchData("https://api.chucknorris.io/jokes/random"), ChuckDTO.class).getValue();
        joke1Reference = "https://api.chucknorris.io";
        
        joke2 = new Gson().fromJson(HttpUtils.fetchData("https://icanhazdadjoke.com"), DadDTO.class).getJoke();
        joke2Reference = "https://icanhazdadjoke.com";
        
        jokes.put("joke1", joke1);
        jokes.put("joke1Reference", joke1Reference);
        jokes.put("joke2", joke2);
        jokes.put("joke2Reference", joke2Reference);
        
        return jokes;
    }
}
