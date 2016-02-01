package com.example.ianc.powerofwords;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LandingPage extends ActionBarActivity {
    MediaPlayer colours, numbers, wordgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        colours = MediaPlayer.create(this, R.raw.colours);
        numbers = MediaPlayer.create(this, R.raw.numbers);
        wordgame = MediaPlayer.create(this, R.raw.wordgame);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing_page, menu);
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

    public void colourBtn(View view) {//code for activating colour learning activity
        Intent intent = new Intent(this, ColorActivity.class);//beginning the class to learn the activity_colour_game
        startActivity(intent);
        colours.start();
    }

    public void  numberBtn(View view) {//code for activating numbers activity
        Intent intent = new Intent(this, NumberActivity.class);//beginning the class to learn the activity_colour_game
        startActivity(intent);
        numbers.start();
    }

    public void  letterBtn(View view) {//code for activating numbers activity
        Intent intent = new Intent(this, LetterGuess.class);//beginning the class to learn the activity_colour_game
        startActivity(intent);
        wordgame.start();
    }
}
