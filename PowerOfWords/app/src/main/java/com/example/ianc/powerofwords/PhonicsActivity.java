package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class PhonicsActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonics);
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instructions.");
        alertDialog.setMessage("In the phonics section the design is to help people learn how to pronounce difficult words. " +
                "\nEach section is designed for specific silent letters " +
                "\nBoth the abc Section and the Abc sounds are to teach the alphabet and the sounds the letters make"  );
        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}});

        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        ImageButton abcButton = (ImageButton)findViewById(R.id.abcButton);
        abcButton.setOnClickListener(this);

        ImageButton abcsoundsButton = (ImageButton)findViewById(R.id.abcsoundsButton);
        abcsoundsButton.setOnClickListener(this);

        ImageButton skButton = (ImageButton)findViewById(R.id.skButton);
        skButton.setOnClickListener(this);

        ImageButton spButton = (ImageButton)findViewById(R.id.spButton);
        spButton.setOnClickListener(this);

        ImageButton sgButton = (ImageButton)findViewById(R.id.sgButton);
        sgButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_phonics, menu);
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
        if(view.getId()==R.id.abcButton){
            Intent playIntent = new Intent(this, AbcActivity.class);
            this.startActivity(playIntent);
        }
        else if (view.getId()==R.id.abcsoundsButton){
            Intent playIntent = new Intent(this, AbcSoundActivity.class);
            this.startActivity(playIntent);
        }
        else if (view.getId()==R.id.skButton){
            Intent playIntent = new Intent(this, KActivity.class);
            this.startActivity(playIntent);
        }
        else if (view.getId()==R.id.sgButton){
            Intent playIntent = new Intent(this, GActivity.class);
            this.startActivity(playIntent);
        }
        else if (view.getId()==R.id.spButton){
            Intent playIntent = new Intent(this, PActivity.class);
            this.startActivity(playIntent);
        }
    }
}
