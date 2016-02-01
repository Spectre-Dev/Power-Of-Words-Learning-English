package com.example.ianc.powerofwords;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class NumberActivity extends ActionBarActivity {
    //variables to store the sound files for each number
    MediaPlayer one, two, three, four, five, six, seven, eight, nine, ten, twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety, hundred, letsplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        //assigning the variables to the corrisponding audio file
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
        twenty = MediaPlayer.create(this, R.raw.twenty);
        thirty = MediaPlayer.create(this, R.raw.thirty);
        forty = MediaPlayer.create(this, R.raw.forty);
        fifty = MediaPlayer.create(this, R.raw.fifty);
        sixty = MediaPlayer.create(this, R.raw.sixty);
        seventy = MediaPlayer.create(this, R.raw.seventy);
        eighty = MediaPlayer.create(this, R.raw.eighty);
        ninety = MediaPlayer.create(this, R.raw.ninety);
        hundred = MediaPlayer.create(this, R.raw.hundred);

        letsplay = MediaPlayer.create(this, R.raw.letsplay);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_number, menu);
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

    public void twenty(View view) {//method for playing twenty audio file
        twenty.start();

    }

    public void thirty(View view) {//method for playing thirty audio file
        thirty.start();

    }

    public void forty(View view) {//method for playing forty audio file
        forty.start();

    }

    public void fifty(View view) {//method for playing fifty audio file
        fifty.start();

    }

    public void sixty(View view) {//method for playing sixty audio file
        sixty.start();

    }

    public void seventy(View view) {//method for playing seventy audio file
        seventy.start();

    }

    public void eighty(View view) {//method for playing eighty audio file
        eighty.start();

    }

    public void ninety(View view) {//method for playing ninety audio file
        ninety.start();

    }

    public void hundred(View view) {//method for playing 100 audio file
        hundred.start();

    }

    public void letsPlay(View view) {//method for playing letsplay audio file and lanching the game
        letsplay.start();//plays "lets play" audio file
        Intent intent = new Intent(this, NumberGame.class);//activates the advanced/games activity
        startActivity(intent);

    }
}
