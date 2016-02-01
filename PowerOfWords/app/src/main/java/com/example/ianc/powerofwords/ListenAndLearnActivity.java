package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ListenAndLearnActivity extends ActionBarActivity {
    MediaPlayer mpSound, correctSound, wrongSound;
    EditText answerText;
    Button enter1, enter2, enter3, enter4, enter5, enter6, enter7, enter8, enter9, enter10;
    ImageView tweet;
    TextView score;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_and_learn);

        tweet = (ImageView) findViewById(R.id.tweetImage);

        mpSound = MediaPlayer.create(this, R.raw.doctor);
        correctSound = MediaPlayer.create(this, R.raw.success);
        wrongSound = MediaPlayer.create(this, R.raw.wrong);

        answerText = (EditText) findViewById(R.id.editTextAnswer);

        score = (TextView) findViewById(R.id.totalScoreTV);
        count = 0;
        score.setText(count+"");

        enter2 = (Button) findViewById(R.id.enterBtn2);
        enter2.setVisibility(View.INVISIBLE);
        enter3 = (Button) findViewById(R.id.enterBtn3);
        enter3.setVisibility(View.INVISIBLE);
        enter4 = (Button) findViewById(R.id.enterBtn4);
        enter4.setVisibility(View.INVISIBLE);
        enter5 = (Button) findViewById(R.id.enterBtn5);
        enter5.setVisibility(View.INVISIBLE);
        enter6 = (Button) findViewById(R.id.enterBtn6);
        enter6.setVisibility(View.INVISIBLE);
        enter7 = (Button) findViewById(R.id.enterBtn7);
        enter7.setVisibility(View.INVISIBLE);
        enter8 = (Button) findViewById(R.id.enterBtn8);
        enter8.setVisibility(View.INVISIBLE);
        enter9 = (Button) findViewById(R.id.enterBtn9);
        enter9.setVisibility(View.INVISIBLE);
        enter10 = (Button) findViewById(R.id.enterBtn10);
        enter10.setVisibility(View.INVISIBLE);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Instructions.");

        alertDialog.setMessage("Here you can test your knowledge of listening and spelling skills. " +

                "\nClick the image to listen to the word " +

                "\nEnter your answer " +

                "\nScore will be monitored and can be saved to the leaderboard ");

        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {}});



        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page

        alertDialog.show();//this tells the above icon to show

        //set home as up
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listen_and_learn, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void open(View view){
        //enables user to tweet about a score they have achieved i.e. share with friends
        String tweetUrl = "https://twitter.com/intent/tweet?text=New Score in POW app: " + count;
        Uri uri = Uri.parse(tweetUrl);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void playSound(View view) {
        mpSound.start();

    }

    public void enter(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Doctor")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.bicycle);

            mpSound = MediaPlayer.create(this, R.raw.bicycle);

            answerText.setText("");

            enter1 = (Button) findViewById(R.id.enterBtn);
            enter1.setVisibility(View.INVISIBLE);
            enter2.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.bicycle);

            mpSound = MediaPlayer.create(this, R.raw.bicycle);

            answerText.setText("");

            enter1 = (Button) findViewById(R.id.enterBtn);
            enter1.setVisibility(View.INVISIBLE);
            enter2.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionTwo(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Bicycle")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.car);

            mpSound = MediaPlayer.create(this, R.raw.car);

            answerText.setText("");

            enter2.setVisibility(View.INVISIBLE);
            enter3.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.car);

            mpSound = MediaPlayer.create(this, R.raw.car);

            answerText.setText("");

            enter2.setVisibility(View.INVISIBLE);
            enter3.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionThree(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Car")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.football);

            mpSound = MediaPlayer.create(this, R.raw.football);

            answerText.setText("");

            enter3.setVisibility(View.INVISIBLE);
            enter4.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.football);

            mpSound = MediaPlayer.create(this, R.raw.football);

            answerText.setText("");

            enter3.setVisibility(View.INVISIBLE);
            enter4.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionFour(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Football")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.bus);

            mpSound = MediaPlayer.create(this, R.raw.bus);

            answerText.setText("");

            enter4.setVisibility(View.INVISIBLE);
            enter5.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.bus);

            mpSound = MediaPlayer.create(this, R.raw.bus);

            answerText.setText("");

            enter4.setVisibility(View.INVISIBLE);
            enter5.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionFive(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Bus")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.dinosaur);

            mpSound = MediaPlayer.create(this, R.raw.dinosaur);

            answerText.setText("");

            enter5.setVisibility(View.INVISIBLE);
            enter6.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.dinosaur);

            mpSound = MediaPlayer.create(this, R.raw.dinosaur);

            answerText.setText("");

            enter5.setVisibility(View.INVISIBLE);
            enter6.setVisibility(View.VISIBLE);
        }
    }

    public void quit(View view) {
        Intent intent = new Intent(this, KidsActivity.class);
        startActivity(intent);
    }

    public void save(View view) {
        Bundle b = new Bundle();
        b.putString("Key", score.getText().toString());
        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void enterQuestionSix(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Dinosaur")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.policeman);

            mpSound = MediaPlayer.create(this, R.raw.police);

            answerText.setText("");

            enter6.setVisibility(View.INVISIBLE);
            enter7.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.policeman);

            mpSound = MediaPlayer.create(this, R.raw.police);

            answerText.setText("");

            enter6.setVisibility(View.INVISIBLE);
            enter7.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionSeven(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Police")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.apple);

            mpSound = MediaPlayer.create(this, R.raw.apple);

            answerText.setText("");

            enter7.setVisibility(View.INVISIBLE);
            enter8.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.apple);

            mpSound = MediaPlayer.create(this, R.raw.apple);

            answerText.setText("");

            enter7.setVisibility(View.INVISIBLE);
            enter8.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionEight(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Apple")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.orange);

            mpSound = MediaPlayer.create(this, R.raw.orange);

            answerText.setText("");

            enter8.setVisibility(View.INVISIBLE);
            enter9.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.orangetwo);

            mpSound = MediaPlayer.create(this, R.raw.orangetwo);

            answerText.setText("");

            enter8.setVisibility(View.INVISIBLE);
            enter9.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionNine(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Orange")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.mountains);

            mpSound = MediaPlayer.create(this, R.raw.mountains);

            answerText.setText("");

            enter9.setVisibility(View.INVISIBLE);
            enter10.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageButton myButton = (ImageButton) findViewById(R.id.imageBtn);
            myButton.setImageResource(R.drawable.mountains);

            mpSound = MediaPlayer.create(this, R.raw.mountains);

            answerText.setText("");

            enter9.setVisibility(View.INVISIBLE);
            enter10.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionTen(View view) {
        answerText = (EditText) findViewById(R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Mountain")){
            Toast.makeText(ListenAndLearnActivity.this, "Congratulations. That is Correct", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            if(count == 5) {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Bronze Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievebronze);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 6){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Bronze Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievebronze);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 7){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Silver Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievesilver);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 8){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Silver Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievesilver);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 9){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Gold Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievegold);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 10){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Gold Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievegold);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else{
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Your score is " + count);

                alertDialog.setIcon(R.drawable.ic_launcher);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Please enter your answer", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Sorry, but that is in incorrect", Toast.LENGTH_LONG).show();
            wrongSound.start();

            if(count == 5) {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Bronze Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievebronze);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 6){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Bronze Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievebronze);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 7){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Silver Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievesilver);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 8){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Silver Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievesilver);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 9){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Gold Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievegold);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 10){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Congratulations you've unlocked Gold Trophy achievement \nYour score is " + count);

                alertDialog.setIcon(R.drawable.achievegold);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else{
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Game Over");

                alertDialog.setMessage("Your score is " + count);

                alertDialog.setIcon(R.drawable.ic_launcher);

                alertDialog.setButton("SAVE SCORE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }

        }
    }
}
