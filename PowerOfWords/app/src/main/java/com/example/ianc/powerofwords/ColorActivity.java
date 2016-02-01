package com.example.ianc.powerofwords;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.view.View;


public class ColorActivity extends ActionBarActivity {
    //below are variables to store the audio files for activity_colour_game/numbers section
    MediaPlayer red, yellow, pink, green, purple, orange, blue, black, one, two, three, four, five, six, seven, eight, nine, ten, letsplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        //activity_colour_game - assigns the variables to an associated audio file in the "raw" folder
        red = MediaPlayer.create(this, R.raw.red);
        yellow = MediaPlayer.create(this, R.raw.yellow);
        pink = MediaPlayer.create(this, R.raw.pink);
        green = MediaPlayer.create(this, R.raw.green);
        purple = MediaPlayer.create(this, R.raw.purple);
        orange = MediaPlayer.create(this, R.raw.orange);
        blue = MediaPlayer.create(this, R.raw.blue);
        black = MediaPlayer.create(this, R.raw.black);
        //numbers - assigns the variables to an associated audio file in the "raw" folder
        one = MediaPlayer.create(this, R.raw.one);
        two = MediaPlayer.create(this, R.raw.two);
        three = MediaPlayer.create(this, R.raw.three);
        four = MediaPlayer.create(this, R.raw.four);
        five = MediaPlayer.create(this, R.raw.five);
        six = MediaPlayer.create(this, R.raw.six);
        seven = MediaPlayer.create(this, R.raw.seven);
        eight = MediaPlayer.create(this, R.raw.eight);
        nine = MediaPlayer.create(this, R.raw.nine);
        ten = MediaPlayer.create(this, R.raw.ten);
        letsplay = MediaPlayer.create(this, R.raw.letsplay);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
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

    public void red(View view) {//method for playing red audio file
        red.start();

    }

    public void yellow(View view) {//method for playing yellow audio file
        yellow.start();

    }

    public void pink(View view) {//method for playing pink audio file
        pink.start();

    }

    public void green(View view) {//method for playing green audio file
        green.start();

    }

    public void purple(View view) {//method for playing purple audio file
        purple.start();

    }

    public void orange(View view) {//method for playing orange audio file
        orange.start();

    }

    public void blue(View view) {//method for playing blue audio file
        blue.start();

    }

    public void black(View view) {//method for playing black audio file
        black.start();

    }

    public void one(View view) {//method for playing one audio file
        one.start();

    }

    public void two(View view) {//method for playing two audio file
        two.start();

    }

    public void three(View view) {//method for playing three audio file
        three.start();

    }

    public void four(View view) {//method for playing four audio file
        four.start();

    }

    public void five(View view) {//method for playing five audio file
        five.start();

    }

    public void six(View view) {//method for playing six audio file
        six.start();

    }

    public void seven(View view) {//method for playing seven audio file
        seven.start();

    }

    public void eight(View view) {//method for playing eight audio file
        eight.start();

    }

    public void nine(View view) {//method for playing nine audio file
        nine.start();

    }

    public void ten(View view) {//method for playing ten audio file
        ten.start();

    }

    public void letsPlay(View view) {//method for playing letsplay audio file
        letsplay.start();//plays "lets play" audio file
        Intent intent = new Intent(this, ColoursGame.class);//activates the advanced/games activity
        startActivity(intent);

    }
}
