package com.example.ianc.powerofwords;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class KActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k);

        ImageButton knapsackButton = (ImageButton)findViewById(R.id.knapsackButton);
        knapsackButton.setOnClickListener(this);

        ImageButton knowButton = (ImageButton)findViewById(R.id.knowButton);
        knowButton.setOnClickListener(this);

        ImageButton kneeButton = (ImageButton)findViewById(R.id.kneeButton);
        kneeButton.setOnClickListener(this);

        ImageButton knotButton = (ImageButton)findViewById(R.id.knotButton);
        knotButton.setOnClickListener(this);

        ImageButton knowledgeButton = (ImageButton)findViewById(R.id.knowledgeButton);
        knowledgeButton.setOnClickListener(this);

        ImageButton knobButton = (ImageButton)findViewById(R.id.knobButton);
        knobButton.setOnClickListener(this);

        ImageButton knockButton = (ImageButton)findViewById(R.id.knockButton);
        knockButton.setOnClickListener(this);

        ImageButton knifeButton = (ImageButton)findViewById(R.id.knifeButton);
        knifeButton.setOnClickListener(this);

        ImageButton knitButton = (ImageButton)findViewById(R.id.knitButton);
        knitButton.setOnClickListener(this);

        ImageButton knuckleButton = (ImageButton)findViewById(R.id.knuckleButton );
        knuckleButton .setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_k, menu);
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
        if (view.getId() == R.id.knapsackButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knapsack);
            mediaPlayer.start();

        } else if (view.getId() == R.id.knobButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knob);
            mediaPlayer.start();
        } else if (view.getId() == R.id.knockButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knock);
            mediaPlayer.start();
        } else if (view.getId() == R.id.knifeButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knife);
            mediaPlayer.start();
        } else if (view.getId() == R.id.knitButton){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knit);
            mediaPlayer.start();
        } else if (view.getId() == R.id.knotButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knot);
            mediaPlayer.start();
        } else if (view.getId() == R.id.knowledgeButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knowledge);
            mediaPlayer.start();
        } else if (view.getId() == R.id.knowButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.know);
            mediaPlayer.start();
        } else if (view.getId() == R.id.kneeButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knee);
            mediaPlayer.start();
        }
        else if (view.getId() == R.id.knuckleButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.knuckle);
            mediaPlayer.start();
        }
    }
}
