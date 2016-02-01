package com.example.ianc.powerofwords;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class PActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p);

        ImageButton pneumaticButton = (ImageButton)findViewById(R.id.pneumaticButton);
        pneumaticButton.setOnClickListener(this);

        ImageButton pneumoniaButton = (ImageButton)findViewById(R.id.pneumoniaButton);
        pneumoniaButton.setOnClickListener(this);

        ImageButton psychiatristButton = (ImageButton)findViewById(R.id.psychiatristButton);
        psychiatristButton.setOnClickListener(this);

        ImageButton psychicButton = (ImageButton)findViewById(R.id.psychicButton);
        psychicButton.setOnClickListener(this);

        ImageButton psychedelicButton = (ImageButton)findViewById(R.id.psychedelicButton);
        psychedelicButton.setOnClickListener(this);

        ImageButton psychologistButton = (ImageButton)findViewById(R.id.psychologistButton);
        psychologistButton.setOnClickListener(this);

        ImageButton psychologyButton = (ImageButton)findViewById(R.id.psychologyButton);
        psychologyButton.setOnClickListener(this);

        ImageButton psychopathButton = (ImageButton)findViewById(R.id.psychopathButton);
        psychopathButton.setOnClickListener(this);

        ImageButton psychosisButton = (ImageButton)findViewById(R.id.psychosisButton);
        psychosisButton.setOnClickListener(this);

        ImageButton psychotherapyButton = (ImageButton)findViewById(R.id.psychotherapyButton);
        psychotherapyButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_p, menu);
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

    @Override
    public void onClick(View view) {
        //handle clicks
        if (view.getId() == R.id.pneumaticButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pneumatic);
            mediaPlayer.start();

        } else if (view.getId() == R.id.pneumoniaButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pneumonia);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychiatristButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychiatrist);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychicButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychic);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychedelicButton){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychedelic);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychologistButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychologist);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychologyButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychology);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychopathButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychopath);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psychotherapyButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychotherapy);
            mediaPlayer.start();
        }
        else if (view.getId() == R.id.psychosisButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psychosis);
            mediaPlayer.start();
        }
    }
}
