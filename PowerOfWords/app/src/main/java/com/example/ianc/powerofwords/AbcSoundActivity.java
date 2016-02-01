package com.example.ianc.powerofwords;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class AbcSoundActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_sound);

        ImageButton asoundButton = (ImageButton)findViewById(R.id.asoundButton);
        asoundButton.setOnClickListener(this);//Creates an instance of the button

        ImageButton bsoundButton = (ImageButton)findViewById(R.id.bsoundButton);
        bsoundButton.setOnClickListener(this);

        ImageButton csoundButton = (ImageButton)findViewById(R.id.csoundButton);
        csoundButton.setOnClickListener(this);

        ImageButton dsoundButton = (ImageButton)findViewById(R.id.dsoundButton);
        dsoundButton.setOnClickListener(this);

        ImageButton esoundButton = (ImageButton)findViewById(R.id.esoundButton);
        esoundButton.setOnClickListener(this);

        ImageButton fsoundButton = (ImageButton)findViewById(R.id.fsoundButton);
        fsoundButton.setOnClickListener(this);

        ImageButton gsoundButton = (ImageButton)findViewById(R.id.gsoundButton);
        gsoundButton.setOnClickListener(this);

        ImageButton hsoundButton = (ImageButton)findViewById(R.id.hsoundButton);
        hsoundButton.setOnClickListener(this);

        ImageButton isoundButton = (ImageButton)findViewById(R.id.isoundButton);
        isoundButton.setOnClickListener(this);

        ImageButton jsoundButton = (ImageButton)findViewById(R.id.jsoundButton);
        jsoundButton.setOnClickListener(this);

        ImageButton ksoundButton = (ImageButton)findViewById(R.id.ksoundButton);
        ksoundButton.setOnClickListener(this);

        ImageButton lsoundButton = (ImageButton)findViewById(R.id.lsoundButton);
        lsoundButton.setOnClickListener(this);

        ImageButton msoundButton = (ImageButton)findViewById(R.id.msoundButton);
        msoundButton.setOnClickListener(this);

        ImageButton nsoundButton = (ImageButton)findViewById(R.id.nsoundButton);
        nsoundButton.setOnClickListener(this);

        ImageButton osoundButton = (ImageButton)findViewById(R.id.osoundButton);
        osoundButton.setOnClickListener(this);

        ImageButton psoundButton = (ImageButton)findViewById(R.id.psoundButton);
        psoundButton.setOnClickListener(this);

        ImageButton qsoundButton = (ImageButton)findViewById(R.id.qsoundButton);
        qsoundButton.setOnClickListener(this);

        ImageButton rsoundButton = (ImageButton)findViewById(R.id.rsoundButton);
        rsoundButton.setOnClickListener(this);

        ImageButton ssoundButton = (ImageButton)findViewById(R.id.ssoundButton);
        ssoundButton.setOnClickListener(this);

        ImageButton tsoundButton = (ImageButton)findViewById(R.id.tsoundButton);
        tsoundButton.setOnClickListener(this);

        ImageButton usoundButton = (ImageButton)findViewById(R.id.usoundButton);
        usoundButton.setOnClickListener(this);

        ImageButton vsoundButton = (ImageButton)findViewById(R.id.vsoundButton);
        vsoundButton.setOnClickListener(this);

        ImageButton wsoundButton = (ImageButton)findViewById(R.id.wsoundButton);
        wsoundButton.setOnClickListener(this);

        ImageButton xsoundButton = (ImageButton)findViewById(R.id.xsoundButton);
        xsoundButton.setOnClickListener(this);

        ImageButton ysoundButton = (ImageButton)findViewById(R.id.ysoundButton);
        ysoundButton.setOnClickListener(this);

        ImageButton zsoundButton = (ImageButton)findViewById(R.id.zsoundButton);
        zsoundButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        //handle clicks
        if (view.getId() == R.id.asoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.asound);
            mediaPlayer.start();//Waits for the click of the button and when it is clicked the audio file plays

        } else if (view.getId() == R.id.bsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.csoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.csound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.dsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.esoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.esound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.fsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.gsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.gsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.hsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.isoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.isound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.jsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.jsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.ksoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ksound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.lsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.lsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.msoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.msound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.nsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.nsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.osoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.osound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.psoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.psound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.qsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.qsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.rsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.ssoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ssound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.tsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.tsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.usoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.usound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.vsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.vsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.wsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.xsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.xsound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.ysoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ysound);
            mediaPlayer.start();
        } else if (view.getId() == R.id.zsoundButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.zsound);
            mediaPlayer.start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_abc_sound, menu);
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
}
