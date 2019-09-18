package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import com.example.displayajokeandroidlib.DisplayAJokeActivity;
import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import static com.udacity.gradle.builditbigger.MainActivity.INTENT_JOKE_TAG;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi mJokeApi = null;
    private Context mContext;
    private InterstitialAd mInterstitialAd;
    public static final String TAGTAG = "tag";

    public EndpointsAsyncTask(Context context) {
        this.mContext = context;

    }


    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mJokeApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.104:8080/_ah/api/" )
                    .setGoogleClientRequestInitializer(abstractGoogleClientRequest ->
                            abstractGoogleClientRequest.setDisableGZipContent(true));
            mJokeApi = builder.build();
        }
        try {
            return mJokeApi.getAJoke().execute().getDataFromEndPoint();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


@Override
    protected void onPostExecute(String result) {
        startJokeDisplayActivity(result);
}


    private void startJokeDisplayActivity(String mResult) {
        Intent intent = new Intent(mContext, DisplayAJokeActivity.class);
        intent.putExtra(INTENT_JOKE_TAG, mResult);
       // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}