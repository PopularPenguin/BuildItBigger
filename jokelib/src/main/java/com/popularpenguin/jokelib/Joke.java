package com.popularpenguin.jokelib;

/** Joke class contains both parts of a joke */
public class Joke {

    private String story;
    private String punchline;

    Joke(String story, String punchline) {
        this.story = story;
        this.punchline = punchline;
    }

    public String getStory() {
        return story;
    }

    public String getPunchline() {
        return punchline;
    }

    @Override
    public String toString() {
        return String.format("%s%n%n%s", story, punchline);
    }
}

