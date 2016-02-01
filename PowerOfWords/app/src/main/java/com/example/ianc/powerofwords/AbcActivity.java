package com.example.ianc.powerofwords;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class AbcActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);

        ImageButton aButton = (ImageButton)findViewById(R.id.aButton);
        aButton.setOnClickListener(this);

        ImageButton bButton = (ImageButton)findViewById(R.id.bButton);
        bButton.setOnClickListener(this);

        ImageButton cButton = (ImageButton)findViewById(R.id.cButton);
        cButton.setOnClickListener(this);

        ImageButton dButton = (ImageButton)findViewById(R.id.dButton);
        dButton.setOnClickListener(this);

        ImageButton eButton = (ImageButton)findViewById(R.id.eButton);
        eButton.setOnClickListener(this);

        ImageButton fButton = (ImageButton)findViewById(R.id.fButton);
        fButton.setOnClickListener(this);

        ImageButton gButton = (ImageButton)findViewById(R.id.gButton);
        gButton.setOnClickListener(this);

        ImageButton hButton = (ImageButton)findViewById(R.id.hButton);
        hButton.setOnClickListener(this);

        ImageButton iButton = (ImageButton)findViewById(R.id.iButton);
        iButton.setOnClickListener(this);

        ImageButton jButton = (ImageButton)findViewById(R.id.jButton);
        jButton.setOnClickListener(this);

        ImageButton kButton = (ImageButton)findViewById(R.id.kButton);
        kButton.setOnClickListener(this);

        ImageButton lButton = (ImageButton)findViewById(R.id.lButton);
        lButton.setOnClickListener(this);

        ImageButton mButton = (ImageButton)findViewById(R.id.mButton);
        mButton.setOnClickListener(this);

        ImageButton nButton = (ImageButton)findViewById(R.id.nButton);
        nButton.setOnClickListener(this);

        ImageButton oButton = (ImageButton)findViewById(R.id.oButton);
        oButton.setOnClickListener(this);

        ImageButton pButton = (ImageButton)findViewById(R.id.pButton);
        pButton.setOnClickListener(this);

        ImageButton qButton = (ImageButton)findViewById(R.id.qButton);
        qButton.setOnClickListener(this);

        ImageButton rButton = (ImageButton)findViewById(R.id.rButton);
        rButton.setOnClickListener(this);

        ImageButton sButton = (ImageButton)findViewById(R.id.sButton);
        sButton.setOnClickListener(this);

        ImageButton tButton = (ImageButton)findViewById(R.id.tButton);
        tButton.setOnClickListener(this);

        ImageButton uButton = (ImageButton)findViewById(R.id.uButton);
        uButton.setOnClickListener(this);

        ImageButton vButton = (ImageButton)findViewById(R.id.vButton);
        vButton.setOnClickListener(this);

        ImageButton wButton = (ImageButton)findViewById(R.id.wButton);
        wButton.setOnClickListener(this);

        ImageButton xButton = (ImageButton)findViewById(R.id.xButton);
        xButton.setOnClickListener(this);

        ImageButton yButton = (ImageButton)findViewById(R.id.yButton);
        yButton.setOnClickListener(this);

        ImageButton zButton = (ImageButton)findViewById(R.id.zButton);
        zButton.setOnClickListener(this);

    }

    public void onClick(View view) {
        //handle clicks
        if (view.getId() == R.id.aButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.a);
            mediaPlayer.start();

        } else if (view.getId() == R.id.bButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.b);
            mediaPlayer.start();
        } else if (view.getId() == R.id.cButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.c);
            mediaPlayer.start();
        } else if (view.getId() == R.id.dButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.d);
            mediaPlayer.start();
        } else if (view.getId() == R.id.eButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.e);
            mediaPlayer.start();
        } else if (view.getId() == R.id.fButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.f);
            mediaPlayer.start();
        } else if (view.getId() == R.id.gButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.g);
            mediaPlayer.start();
        } else if (view.getId() == R.id.hButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.h);
            mediaPlayer.start();
        } else if (view.getId() == R.id.iButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.i);
            mediaPlayer.start();
        } else if (view.getId() == R.id.jButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.j);
            mediaPlayer.start();
        } else if (view.getId() == R.id.kButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.k);
            mediaPlayer.start();
        } else if (view.getId() == R.id.lButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.l);
            mediaPlayer.start();
        } else if (view.getId() == R.id.mButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.m);
            mediaPlayer.start();
        } else if (view.getId() == R.id.nButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.n);
            mediaPlayer.start();
        } else if (view.getId() == R.id.oButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.o);
            mediaPlayer.start();
        } else if (view.getId() == R.id.pButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.p);
            mediaPlayer.start();
        } else if (view.getId() == R.id.qButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.q);
            mediaPlayer.start();
        } else if (view.getId() == R.id.rButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.r);
            mediaPlayer.start();
        } else if (view.getId() == R.id.sButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.s);
            mediaPlayer.start();
        } else if (view.getId() == R.id.tButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.t);
            mediaPlayer.start();
        } else if (view.getId() == R.id.uButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.u);
            mediaPlayer.start();
        } else if (view.getId() == R.id.vButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.v);
            mediaPlayer.start();
        } else if (view.getId() == R.id.wButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.w);
            mediaPlayer.start();
        } else if (view.getId() == R.id.xButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.x);
            mediaPlayer.start();
        } else if (view.getId() == R.id.yButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.y);
            mediaPlayer.start();
        } else if (view.getId() == R.id.zButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.z);
            mediaPlayer.start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_abc, menu);
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
