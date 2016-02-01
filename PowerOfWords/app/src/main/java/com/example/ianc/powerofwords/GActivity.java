package com.example.ianc.powerofwords;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class GActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g);

        ImageButton gnomeButton = (ImageButton)findViewById(R.id.gnomeButton);
        gnomeButton.setOnClickListener(this);

        ImageButton gnuButton = (ImageButton)findViewById(R.id.gnuButton);
        gnuButton.setOnClickListener(this);

        ImageButton gnatButton = (ImageButton)findViewById(R.id.gnatButton);
        gnatButton.setOnClickListener(this);

        ImageButton signButton = (ImageButton)findViewById(R.id.signButton);
        signButton.setOnClickListener(this);

        ImageButton assignButton = (ImageButton)findViewById(R.id.assignButton);
        assignButton.setOnClickListener(this);

        ImageButton designButton = (ImageButton)findViewById(R.id.designButton);
        designButton.setOnClickListener(this);

        ImageButton resignButton = (ImageButton)findViewById(R.id.resignButton);
        resignButton.setOnClickListener(this);

        ImageButton alignButton = (ImageButton)findViewById(R.id.alignButton);
        alignButton.setOnClickListener(this);

        ImageButton reignButton = (ImageButton)findViewById(R.id.reignButton);
        reignButton.setOnClickListener(this);

        ImageButton foreignButton = (ImageButton)findViewById(R.id.foreignButton);
        foreignButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_g, menu);
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
        if (view.getId() == R.id.gnomeButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.gnome);
            mediaPlayer.start();

        } else if (view.getId() == R.id.gnatButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.gnat);
            mediaPlayer.start();
        } else if (view.getId() == R.id.gnuButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.gnu);
            mediaPlayer.start();
        } else if (view.getId() == R.id.signButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sign);
            mediaPlayer.start();
        } else if (view.getId() == R.id.assignButton){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.assign);
            mediaPlayer.start();
        } else if (view.getId() == R.id.designButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.design);
            mediaPlayer.start();
        } else if (view.getId() == R.id.resignButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.resign);
            mediaPlayer.start();
        } else if (view.getId() == R.id.alignButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.align);
            mediaPlayer.start();
        } else if (view.getId() == R.id.reignButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.reign);
            mediaPlayer.start();
        }
        else if (view.getId() == R.id.foreignButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.foreign);
            mediaPlayer.start();
        }
    }
}
