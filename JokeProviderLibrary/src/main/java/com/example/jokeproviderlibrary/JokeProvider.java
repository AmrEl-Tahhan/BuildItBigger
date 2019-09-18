package com.example.jokeproviderlibrary;

import java.util.Random;

public class JokeProvider {


    String[] mJokes = new String[5];
    private Random random = new Random();
    public JokeProvider() {

        mJokes[0] = "Today at the bank, an old lady asked me to help check her balance. So I pushed her over.";
        mJokes[1] = "I bought some shoes from a drug dealer. I don't know what he laced them with, but I've been tripping all day";
        mJokes[2] = "I told my girlfriend she drew her eyebrows too high. She seemed surprised.";
        mJokes[3] = "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.";
        mJokes[4] = "I'm so good at sleeping. I can do it with my eyes closed.";

    }

    public String[] getJokes() {
        return mJokes;
    }

    public String getaJoke() {
        return mJokes[random.nextInt(mJokes.length)];
    }

}
