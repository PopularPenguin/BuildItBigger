package com.popularpenguin.jokelib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Class that provides a list of Jokes to display */
public class JokeProvider {
    private List<Joke> jokes;

    public JokeProvider() {
        jokes = new ArrayList<>();

        jokes.add(new Joke("Why did the chicken cross the road?\n\nTo get to the other side!"));
        jokes.add(new Joke("How many carpenters does it take to change a lightbulb?\n\n" +
                "None, it's the electrician's job."));
        jokes.add(new Joke("What's the opposite of progress?\n\nCongress!"));
        jokes.add(new Joke("Why was 6 afraid of 7?\n\nBecause 7 8 9."));
        jokes.add(new Joke("A horse walks into a bar.\n\nThe bartender says \'Why the long face?\'"));
        jokes.add(new Joke("What is Jesus's favorite fitness program?\n\nCrossfit!"));
    }

    public String getJoke(int index) {
        return jokes.get(index).toString();
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public String getRandomJokeString() {
        int randomIndex = new Random().nextInt(jokes.size());

        return getJoke(randomIndex);
    }
}

