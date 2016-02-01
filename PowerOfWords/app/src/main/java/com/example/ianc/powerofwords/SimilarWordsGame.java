package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class SimilarWordsGame extends ActionBarActivity {

    private int scoreS = 0;
    int incorrect = 0;
    int tempNum = (int) (Math.random() * 10);
    TextView txtScore;

    Button Btn1;
    Button Btn2;
    Button Btn3;
    ImageButton back;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_words_game);

        txtScore=(TextView)findViewById(R.id.ScoreShowS);
        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn3 = (Button) findViewById(R.id.Btn3);
        back = (ImageButton) findViewById(R.id.BackArrow);


        AlertDialog alertDialog = new AlertDialog.Builder(SimilarWordsGame.this).create();
        alertDialog.setTitle("How To Play");
        alertDialog.setMessage("Match the word to the sentence. these word are pronounced the same so be careful! If the word doesn't fit, click the refresh button!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        txtScore.setText(scoreS +"");

        NextQuestion();
        SetButton();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_similar, menu);
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

    public void SetButton(){
        if(tempNum <= 3){
            Btn1.setText("THERE");
            Btn2.setText("THEIR");
            Btn3.setText("THEY'RE");
            Btn3.setVisibility(View.VISIBLE);

        }
        else if(tempNum>3 && tempNum<=5 ){
            Btn1.setText("WHICH");
            Btn2.setText("WITCH");
            Btn3.setVisibility(View.GONE);


        }
        else if(tempNum>5 && tempNum<=8){
            Btn1.setText("To");
            Btn2.setText("TWO");
            Btn3.setText("TOO");
            Btn3.setVisibility(View.VISIBLE);

        }
        else{
            Btn1.setText("AFFECT");
            Btn2.setText("EFFECT");
            Btn3.setVisibility(View.GONE);

        }

    }

    public void exit(View v){
        Intent intent = new Intent(this, MainWindowDyslexia.class);
        startActivity(intent);
    }

    public void Correct() {
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.success);
        mp.start();
        final ImageView correctImg = (ImageView) findViewById(R.id.check);

        correctImg.setVisibility(View.VISIBLE);
        correctImg.postDelayed(new Runnable() {
            @Override
            public void run() {
                correctImg.setVisibility(View.INVISIBLE);
            }
        }, 1000);
        if (scoreS >= 15) {
            Intent intent = new Intent(this, MainWindowDyslexia.class);
            startActivity(intent);
        }
    }

    public void Incorrect(){
        final MediaPlayer mp= MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mp.start();
        incorrect = incorrect +1;
        if(incorrect >= 2){
            scoreS--;
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

    public void NextQuestion(){

        int prev;
        prev = tempNum;
        tempNum = (int) (Math.random() * 10);
        if(tempNum == prev) {
            NextQuestion();
        }
        TextView txtContent=(TextView)findViewById(R.id.tv1);
        AssetManager assetManager = getAssets();
        InputStream input;
        try{
            input=assetManager.open(tempNum+"L.txt");
            int size=input.available();
            byte[] buffer=new byte[size];
            input.read(buffer);
            input.close();
            String text=new String(buffer);
            txtContent.setText(text);
        }catch (Exception e) {
            e.printStackTrace();
        }
        SetButton();
    }

    public void Btn1OnClick(View v){

        Button Btn1 = (Button) v;
        if(tempNum == 1 || tempNum == 4 || tempNum == 6 || tempNum == 9){
            incorrect = 0;
            scoreS++;
            Correct();
            txtScore.setText(scoreS +"");

            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }

    public void Btn2OnClick(View v){

        Button Btn2 = (Button) v;
        if(tempNum == 2 || tempNum == 5 || tempNum == 7 || tempNum == 10){
            incorrect = 0;
            scoreS++;
            Correct();
            txtScore.setText(scoreS +"");

            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }

    public void Btn3OnClick(View v){

        Button Btn3 = (Button) v;
        if(tempNum == 3 || tempNum == 8){
            incorrect = 0;
            scoreS++;

            Correct();
            txtScore.setText(scoreS +"");

            NextQuestion();
            SetButton();
        }
        else {
            Incorrect();
        }


    }

    public void Err(View v){
        tempNum = (int) (Math.random() * 10);
        NextQuestion();
        SetButton();
    }
}
