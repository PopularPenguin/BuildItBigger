package com.udacity.gradle.builditbigger.backend;

import com.popularpenguin.jokelib.JokeProvider;

public class MyBean {

    public MyBean() { }

    public String getJoke() {
        return new JokeProvider().getRandomJokeString();
    }
}
