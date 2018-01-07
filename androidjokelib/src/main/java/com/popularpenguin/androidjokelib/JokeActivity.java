package com.popularpenguin.androidjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/** Activity to display the joke */
public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        displayJoke();
    }

    private void displayJoke() {
        String jokeString = getIntent().getStringExtra("joke");
        JSONObject jokeJson;
        String joke = "";

        try {
            jokeJson = new JSONObject(jokeString);
            joke = jokeJson.getString("joke");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        TextView jokeView = findViewById(R.id.tv_joke);
        jokeView.setText(joke);
    }
}

