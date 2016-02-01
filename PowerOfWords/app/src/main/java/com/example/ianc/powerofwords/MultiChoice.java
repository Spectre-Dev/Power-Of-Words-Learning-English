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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MultiChoice extends ActionBarActivity {

    int scoreM;
    int incorrect;
    int tempNum = (int) (Math.random() * 7);
    TextView txtScore;

    Button first;
    Button second;
    Button third;
    Button fourth;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_choice);

        txtScore=(TextView)findViewById(R.id.ScoreShowL);



        first = (Button) findViewById(R.id.button);
        second = (Button) findViewById(R.id.button2);
        third = (Button) findViewById(R.id.button3);
        fourth = (Button) findViewById(R.id.button4);

        AlertDialog alertDialog = new AlertDialog.Builder(MultiChoice.this).create();
        alertDialog.setTitle("How To Play");
        alertDialog.setMessage("There are four words to choose from but which is the correct one? its your fob to choose the correctly spelled word!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();


        txtScore.setText(scoreM +"");
        NextQuestion();
        SetButton();

    }



    public void SetButton(){
        if(tempNum == 1){

            first.setText("field");
            second.setText("feeled");
            third.setText("feeld");
            fourth.setText("feild");


        }
        else if(tempNum == 2 ){

            first.setText("lisin");
            second.setText("listen");
            third.setText("lestin");
            fourth.setText("listin");



        }
        else if(tempNum == 3){

            first.setText("obselete");
            second.setText("obselite");
            third.setText("obsolete");
            fourth.setText("obsolite");
        }
        else if(tempNum == 4){

            first.setText("scosiological");
            second.setText("cosiological");
            third.setText("sosiological");
            fourth.setText("sociological");



        }
        else if(tempNum == 5){

            first.setText("phsychology");
            second.setText("psychology");
            third.setText("cychology");
            fourth.setText("sychologh");


        }
        else if(tempNum == 6){

            first.setText("doughter");
            second.setText("dotter");
            third.setText("daughter");
            fourth.setText("dauhgter");
        }
        else if(tempNum == 7){

            first.setText("concived");
            second.setText("conceived");
            third.setText("conceved");
            fourth.setText("conseived");

        }

    }

    public void NextQuestion(){

        int prev;
        prev = tempNum;
        tempNum = (int) (Math.random() * 7);
        if(prev == tempNum || tempNum==0){
            NextQuestion();
        }
        SetButton();


    }

    public void Button1(View v){


        if(tempNum == 1){
            incorrect = 0;
            scoreM++;
            Correct();


            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }

    public void Button2(View v){

        Button second = (Button) v;
        if(tempNum == 2 || tempNum == 5 || tempNum == 7){
            incorrect = 0;
            scoreM++;
            Correct();


            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }

    public void Button3(View v){

        Button third = (Button) v;
        if(tempNum == 6 || tempNum == 3 ){
            incorrect = 0;
            scoreM++;
            Correct();


            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }
    public void Button4(View v){

        Button fourth = (Button) v;
        if(tempNum == 1 || tempNum==4){
            incorrect = 0;
            scoreM++;
            Correct();


            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }

    public void Correct() {
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.success);
        mp.start();
        txtScore.setText(scoreM +"");
        final ImageView correctImg = (ImageView) findViewById(R.id.check);
        correctImg.setVisibility(View.VISIBLE);
        correctImg.postDelayed(new Runnable() {
            @Override
            public void run() {
                correctImg.setVisibility(View.INVISIBLE);
            }
        }, 1000);
        if (scoreM >= 14) {

            Intent intent = new Intent(this, MainWindowDyslexia.class);
            startActivity(intent);
        }
    }

    public void Incorrect(){
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mp.start();
        incorrect = incorrect +1;
        if(incorrect >= 2){
            scoreM--;
        }
        final ImageView incorrectImg=(ImageView)findViewById(R.id.X);
        incorrectImg.setVisibility(View.VISIBLE);
        incorrectImg.postDelayed(new Runnable() {
            @Override
            public void run() {
                incorrectImg.setVisibility(View.INVISIBLE);
            }
        }, 1000);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi_choice, menu);
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



    public void exit(View v){



        Intent intent = new Intent(this, MainWindowDyslexia.class);

        startActivity(intent);
    }
}
