package com.udacity.gradle.builditbigger.backend;

import com.example.jokeproviderlibrary.JokeProvider;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private JokeProvider mJokeProvider;

    public MyBean() {
        this.mJokeProvider = new JokeProvider();
    }

    public String getDataFromEndPoint() {
        return mJokeProvider.getaJoke();
    }


}