package com.popularpenguin.jokelib;

import java.util.ArrayList;
import java.util.List;

/** Class that provides a list of Jokes to display */
public class JokeProvider {
    private List<Joke> jokes;

    public JokeProvider() {
        jokes = new ArrayList<>();

        jokes.add(new Joke("Why did the chicken cross the road?", "To get to the other side!"));
    }

    public Joke getJoke(int index) {
        return jokes.get(index);
    }

    public List<Joke> getJokes() {
        return jokes;
    }
}

