package lingo.game.infrastructure.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Word;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ApiWordSource implements IWordSource {

    private String baseUrl;

    public ApiWordSource(String baseUrl){
        this.baseUrl = baseUrl;
    }

    @Override
    public ArrayList<Word> ReadWords() throws IOException, URISyntaxException {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        ArrayList<Word> words = target.path("words").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Word>>(){});

        System.out.println(words.size());
        return words;
    }

    @Override
    public ArrayList<Word> ReadWords(int length) throws IOException, URISyntaxException {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());

        ArrayList<Word> words = target.path("words").path("length").path(String.valueOf(length)).request().accept(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Word>>(){});

        System.out.println(words.size());
        return words;
    }

    @Override
    public Word ReadWord() throws IOException, URISyntaxException {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        Word word = target.path("word").request().accept(MediaType.APPLICATION_JSON).get(Word.class);

        System.out.println(word);
        return word;
    }

    @Override
    public Word ReadWord(int length) throws IOException, URISyntaxException {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        Word word = target.path("word").path("length").
                path(String.valueOf(length)).request().accept(MediaType.APPLICATION_JSON).get(Word.class);

        System.out.println(word);
        return word;
    }

    @Override
    public boolean checkWord(String word) throws IOException, URISyntaxException {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        boolean exits = target.path("word").path("check").
                path(String.valueOf(word)).request().accept(MediaType.APPLICATION_JSON).get(boolean.class);

        System.out.println(word + " : " + exits);
        return exits;
    }
    private URI getBaseURI() {
        return UriBuilder.fromUri(baseUrl).build();
    }
}
