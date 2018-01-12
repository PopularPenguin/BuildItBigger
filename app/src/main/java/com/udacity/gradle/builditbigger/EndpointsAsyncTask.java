package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.popularpenguin.androidjokelib.JokeActivity;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressBar mSpinner;

    EndpointsAsyncTask(Context context, ProgressBar spinner) {
        this.context = context;
        mSpinner = spinner;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        return getJoke();
    }

    @Override
    protected void onPostExecute(String result) {
        mSpinner.setVisibility(View.GONE);

        // Launch new android lib activity
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);

        context = null;
        mSpinner = null;
    }

    /** Get a random joke from the cloud */
    private String getJoke() {
        try {
            Log.d("Endpoints", myApiService.getJoke().execute().getJoke());
            return myApiService.getJoke().execute().getJoke();
        }
        catch (IOException e) {
            return context.getResources().getString(R.string.error_joke);
        }
    }
}
