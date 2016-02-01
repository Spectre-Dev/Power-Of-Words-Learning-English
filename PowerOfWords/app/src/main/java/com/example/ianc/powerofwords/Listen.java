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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Listen extends ActionBarActivity {

    int score = 0;
    int incorrect = 0;

    int tempNum = 1;
    String ans;


    Button SubmitBTN;
    ImageButton PlaySound;
    TextView txtScore;
    TextView answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);

        txtScore = (TextView) findViewById(R.id.ScoreShowL);
        answer = (EditText) findViewById(R.id.UserTXT);
        SubmitBTN = (Button) findViewById(R.id.SubmitBTN);

        PlaySound = (ImageButton) findViewById(R.id.PlaySound);


        AlertDialog alertDialog = new AlertDialog.Builder(Listen.this).create();
        alertDialog.setTitle("How To Play");
        alertDialog.setMessage("For this Game You'll need to listen to the word by pressing the speaker button then try to spell it. the words chosen are commonly mis-spelled by dyslexics");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listen, menu);
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

    public void soundBtn(View v) {
        ImageButton PlaySound = (ImageButton) v;
        setAnswer();
    }

    public void Correct(){
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.success);
        mp.start();
        score++;
        answer.setText(null);
        final ImageView correctImg=(ImageView)findViewById(R.id.check);
        correctImg.setVisibility(View.VISIBLE);
        correctImg.postDelayed(new Runnable() {
            @Override
            public void run() {
                correctImg.setVisibility(View.GONE);
            }
        }, 1000);
        if(score >= 14){

            Intent intent = new Intent(this, MainWindowDyslexia.class);
            startActivity(intent);
        }
    }

    public void Incorrect(){
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mp.start();
        incorrect = incorrect +1;
        if(incorrect >= 2){
            score--;
        }
        final ImageView incorrectImg=(ImageView)findViewById(R.id.X);
        incorrectImg.setVisibility(View.VISIBLE);
        incorrectImg.postDelayed(new Runnable() {
            @Override
            public void run() {
                incorrectImg.setVisibility(View.GONE);
            }
        }, 1000);

    }

    public void NextQuestionS(){
        int prev;
        prev = tempNum;
        tempNum = (int) (Math.random() * 10);
        if(tempNum == prev){
            NextQuestionS();
        }


    }

    public void setAnswer(){
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.field);
        final MediaPlayer mp1= MediaPlayer.create(getApplicationContext(), R.raw.listen);
        final MediaPlayer mp2= MediaPlayer.create(getApplicationContext(), R.raw.obsolete);
        final MediaPlayer mp3= MediaPlayer.create(getApplicationContext(), R.raw.sociological);
        final MediaPlayer mp4= MediaPlayer.create(getApplicationContext(), R.raw.psychology);
        final MediaPlayer mp5= MediaPlayer.create(getApplicationContext(), R.raw.daughter);
        final MediaPlayer mp6= MediaPlayer.create(getApplicationContext(), R.raw.conceived);

        if(tempNum == 1){
            ans = "field";
            mp.start();
        }
        else if(tempNum == 2){
            ans = "listen";
            mp1.start();
        }
        else if(tempNum == 3){
            ans = "obsolete";
            mp2.start();
        }
        else if(tempNum ==4){

            ans = "sociological";
            mp3.start();
        }
        else if(tempNum == 5){

            ans = "psychology";
            mp4.start();
        }
        else if(tempNum == 6){

            ans = "daughter";
            mp5.start();
        }
        else if(tempNum == 7){
            ans = "conceived";
            mp6.start();
        }
    }

    public void Submit(View v){
        Button SubmitBTN = (Button) v;
        String userAns = answer.getText().toString();
        boolean test = false;

        if((userAns+"a").equals(ans+"a")){
            test = true;
        }


        if(test == true){
            NextQuestionS();
            setAnswer();
            incorrect = 0;
            Correct();
            txtScore.setText(score+"");



        }
        else if(test == false){
            Incorrect();

        }


    }

    public void exit(View v){
        Intent intent = new Intent(this, MainWindowDyslexia.class);
        startActivity(intent);
    }
}
