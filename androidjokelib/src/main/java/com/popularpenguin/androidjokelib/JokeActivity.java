package com.popularpenguin.androidjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/** Activity to display the joke */
public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        displayJoke();
    }

    private void displayJoke() {
        int index = getIntent().getIntExtra("index", 0);

        String joke = getIntent().getStringExtra("joke");

        TextView jokeView = findViewById(R.id.tv_joke);
        jokeView.setText(joke);
    }
}

