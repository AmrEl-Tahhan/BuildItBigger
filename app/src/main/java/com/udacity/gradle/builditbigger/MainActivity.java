package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public final static String INTENT_JOKE_TAG = "intentJokeTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

//        JokeProvider mJokeProvider = new JokeProvider();
        EndpointsAsyncTask mEndpointsAsynkTask = new EndpointsAsyncTask(this);
       mEndpointsAsynkTask.execute();

//        Intent intent = new Intent(this, DisplayAJokeActivity.class);
//        intent.putExtra(INTENT_JOKE_TAG,mJokeProvider.getaJoke());
//        startActivity(intent);

       // Toast.makeText(this, mJokeProvider.getaJoke(), Toast.LENGTH_SHORT).show();
    }


}
