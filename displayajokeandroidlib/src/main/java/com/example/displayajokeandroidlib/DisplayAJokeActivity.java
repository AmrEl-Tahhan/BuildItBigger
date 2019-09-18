package com.example.displayajokeandroidlib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayAJokeActivity extends AppCompatActivity {

    public final static String INTENT_JOKE_TAG = "intentJokeTag";
    private TextView JokeTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ajoke);
        String mJoke = getIntent().getStringExtra(INTENT_JOKE_TAG);
        JokeTV = findViewById(R.id.joke_tv);
        JokeTV.setText(mJoke);
    }
}

