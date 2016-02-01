package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class WeekDays extends ActionBarActivity {
    MediaPlayer monday,tuesday, wednesday, thursday, friday, saturday, sunday; //variables for sound files


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_days);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instructions.");
        alertDialog.setMessage("Press on desired day and learn how to pronounce it. " +
                "\nIn no time you will be a pro!");
        alertDialog.setButton("Lets go!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        //assigns the variables to an associated audio file in the "raw" folder
        monday = MediaPlayer.create(this, R.raw.monday);
        tuesday = MediaPlayer.create(this, R.raw.tuesday);
        wednesday = MediaPlayer.create(this, R.raw.wednesday);
        thursday = MediaPlayer.create(this, R.raw.thursday);
        friday = MediaPlayer.create(this, R.raw.friday);
        saturday = MediaPlayer.create(this, R.raw.saturday);
        sunday = MediaPlayer.create(this, R.raw.sunday);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_week_days, menu);
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

    public void mondayBtn(View view) {//method for playing monday audio file
        monday.start();
    }
    public void tuesdayBtn(View view){//tuesday audio file
        tuesday.start();
    }
    public void wednesdayBtn(View view){//wednesday audio file
        wednesday.start();
    }
    public void thursdayBtn(View view){//thursday audio file
        thursday.start();
    }
    public void fridayBtn(View view){//friday audio file
        friday.start();
    }
    public void saturdayBtn(View view){//saturday audio file
        saturday.start();
    }
    public void sundayBtn(View view){//sunday audio file
        sunday.start();
    }
}
