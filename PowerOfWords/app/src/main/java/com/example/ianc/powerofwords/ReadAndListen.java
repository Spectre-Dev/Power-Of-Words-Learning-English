package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;


public class ReadAndListen extends ActionBarActivity {
    MediaPlayer content; //variable for sound files
    ImageButton btn;
    boolean counter = (true);

    private ArrayList<Integer> myList = new ArrayList<>();//arraylist to hold sequential numbers from 1 to however many objects I need.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_and_listen);

        //alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instructions.");
        alertDialog.setMessage("Learn new words by listening. " +
                "\nTap the image to hear the word written. " +
                "\nYou can go to next word by clicking next button! " );
        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}});

        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show


        content = MediaPlayer.create(this, R.raw.the);

        btn = (ImageButton) findViewById(R.id.theIBtn);//identifying the image button to be changed
        Random();//Running the random method
    }
    public void Random() {
        while (counter == (true)) {
            for (int i = 1; i < 6; i++) {
                myList.add(Integer.valueOf(i));
            }
            Collections.shuffle(myList);
            counter = (false);
        }

        if (myList.isEmpty()) {
            //TO DO: set a method here that tells them the game is over.
            //this alert ends the game an outputs the score
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("HEI HEI HEI");
            alertDialog.setMessage("Congratulations, Your learning! ");
            alertDialog.setButton("Proceed", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            alertDialog.setIcon(R.drawable.the);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show

        }
        if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set image to THE.
            btn.setImageResource(R.drawable.the);
            content = MediaPlayer.create(this, R.raw.the);
        } else if (myList.get(0) == 2) {//if the integer at index 0 is a 2, set image to ADD.
            btn.setImageResource(R.drawable.add);
            content = MediaPlayer.create(this, R.raw.add);
        } else if (myList.get(0) == 3) {//if the integer at index 0 is a 3, set image to AGE.
            btn.setImageResource(R.drawable.age);
            content = MediaPlayer.create(this, R.raw.age);
        } else if (myList.get(0) == 4) {//if the integer at index 0 is a 4, set image to CAN.
            btn.setImageResource(R.drawable.can);
            content = MediaPlayer.create(this, R.raw.can);
        } else if (myList.get(0) == 5) {//if the integer at index 0 is a 5, set image to DRY.
            btn.setImageResource(R.drawable.dry);
            content = MediaPlayer.create(this, R.raw.dry);
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_beginner, menu);
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

    public void playSound(View view) {
        content.start();

    }

    public void quit(View view) {
        Intent intent = new Intent(this, BeginnerActivity.class);
        startActivity(intent);
    }

    public void theBtn(View view){
        content.start();
    }

    public void nextBtn(View view){
        myList.remove(0);
        Random();
    }

}