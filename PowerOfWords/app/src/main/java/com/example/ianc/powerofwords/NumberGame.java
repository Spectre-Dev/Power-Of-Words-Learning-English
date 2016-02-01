package com.example.ianc.powerofwords;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class NumberGame extends ActionBarActivity {

    MediaPlayer content, correctSound, wrongSound;//variables for sound files
    ImageButton btn; //this variable is for changing the image in the advanced activity
    TextView scoreText, timeLimit; //this variable is used for updating the score info
    int score, scorePenalty;
    boolean counter = (true);
    boolean timeout = (true);
    String scoreString;
    boolean hint = (false);//used to determine if the user used any hints when outputting the score.
    private static final String FORMAT = "%02d:%02d";//this string defines the format of the countdown timer in the game

    private ArrayList<Integer> myList = new ArrayList<>();//this arraylist stores the game objects



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);

        timeLimit=(TextView)findViewById(R.id.CountdownLbl); //this variable updates the countdown ticker in the game

        correctSound = MediaPlayer.create(this, R.raw.correctans);
        wrongSound = MediaPlayer.create(this, R.raw.fail);

        //this code is for the instructions alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instructions.");
        alertDialog.setMessage("Here you can test your knowledge of numbers. " +
                "\ntap the number shown. " +
                "\nYou can tap the image to hear the word but be warned! " +
                "\nYou'll get more points without using up a hint!" );
        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(40000, 1000) { // adjust the milli seconds here - 1000 = 1 second

                    @TargetApi(Build.VERSION_CODES.GINGERBREAD)//this code lets the mnimum api to gingerbread. Froyo doesn't support countdown
                    public void onTick(long millisUntilFinished) {

                        timeLimit.setText(""+String.format(FORMAT,

                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) )));
                    }
                    public void onFinish() {//sets what will happen when the timer finishes
                        TimeOut();
                    }
                }.start();//starts the countdown timer
            }});

        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        scoreText = (TextView) findViewById(R.id.scoreTxt); //creating a variable for the text within the score label
        scoreText.setText("0");//setting the score text to 0

        btn = (ImageButton) findViewById(R.id.imageBtn);//identifying the image button to be changed in the colourse
        Random();//Running the random method to select which image button will be chosen.

    }

    public void TimeOut(){//this method stops the game when the timer gets to zero
        if (timeout = true) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            alertDialog.setTitle("Your Score:");
            alertDialog.setMessage("Your score is " + score +
                    "\nLets try beat that!");
            alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show
        }
    }

    public void Random() {//this method is resonnsible for storing the game objects and randomizing them
        scorePenalty = 3;
        while (counter == (true)) {//Making sure arraylist only writes initial values on first application load, not after every question.
            for (int i = 1; i < 20; i++) {//adding the numbers 1-3 to the indexes in the array
                myList.add(Integer.valueOf(i));//adding the i value to the arrayList. There's a BIG difference between int and Integer, I learned today.
            }
            Collections.shuffle(myList);//shuffling the array indexes around so int numbers are jumbled
            counter = (false);//used to ensure that population of the array only happens on first execution,
        }
        if (myList.isEmpty()){
            //TO DO: set a method here that tells them the game is over. thanks for playing, yadaydaydaa.
            //this alert ends the game an outputs the score
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            if (hint == (true)) {//shows user their score, lets them know if they lost points to using hints
                alertDialog.setTitle("Your Score:");
                alertDialog.setMessage("Your score is " + score +
                        "\nYou dropped some points for using hints!");
            }
            else if (hint == false && score == 57){//checked no hints were used and max points achieved, user == BOSS!
                alertDialog.setTitle("Your Score:");
                alertDialog.setMessage("Wow! You MAXED it! " +
                        "\nScore: " + score);
                Intent intent = new Intent(this, NumberActivity.class);//going back to the number learning page when game complete
                startActivity(intent);
            }
            else{//returns user score if they didn't use hints but didn't score max points.
                alertDialog.setTitle("Your Score:");
                alertDialog.setMessage("Your score is: " + score +
                        "\nLets try beat that!" );

            }
            alertDialog.setButton("Proceed", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {}});

            timeout = false;
            alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show
        }

        else if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set the question and answer to RED - answer is set in button methods below
            btn.setImageResource(R.drawable.one);
            content = MediaPlayer.create(this, R.raw.one);
        }
        else if (myList.get(0) == 2){//if the integer at index 0 is a 1, set the question and answer to YELLOW - answer is set in button methods below
            btn.setImageResource(R.drawable.two);
            content = MediaPlayer.create(this, R.raw.two);
        }
        else if (myList.get(0) == 3){//if the integer at index 0 is a 1, set the question and answer to PINK - answer is set in button methods below
            btn.setImageResource(R.drawable.three);
            content = MediaPlayer.create(this, R.raw.three);
        }
        else if (myList.get(0) == 4){//if the integer at index 0 is a 1, set the question and answer to GREEN - answer is set in button methods below
            btn.setImageResource(R.drawable.four);
            content = MediaPlayer.create(this, R.raw.four);
        }
        else if (myList.get(0) == 5){//if the integer at index 0 is a 1, set the question and answer to PURPLE - answer is set in button methods below
            btn.setImageResource(R.drawable.five);
            content = MediaPlayer.create(this, R.raw.five);
        }
        else if (myList.get(0) == 6){//if the integer at index 0 is a 1, set the question and answer to ORANGE - answer is set in button methods below
            btn.setImageResource(R.drawable.six);
            content = MediaPlayer.create(this, R.raw.six);
        }
        else if (myList.get(0) == 7){//if the integer at index 0 is a 1, set the question and answer to BLUE - answer is set in button methods below
            btn.setImageResource(R.drawable.seven);
            content = MediaPlayer.create(this, R.raw.seven);
        }
        else if (myList.get(0) == 8){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.eight);
            content = MediaPlayer.create(this, R.raw.eight);
        }
        else if (myList.get(0) == 9){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.nine);
            content = MediaPlayer.create(this, R.raw.nine);
        }
        else if (myList.get(0) == 10){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.ten);
            content = MediaPlayer.create(this, R.raw.ten);
        }
        else if (myList.get(0) == 11){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.twenty);
            content = MediaPlayer.create(this, R.raw.twenty);
        }
        else if (myList.get(0) == 12){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.thirty);
            content = MediaPlayer.create(this, R.raw.thirty);
        }
        else if (myList.get(0) == 13){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.forty);
            content = MediaPlayer.create(this, R.raw.forty);
        }
        else if (myList.get(0) == 14){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.fifty);
            content = MediaPlayer.create(this, R.raw.fifty);
        }
        else if (myList.get(0) == 15){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.sixty);
            content = MediaPlayer.create(this, R.raw.sixty);
        }
        else if (myList.get(0) == 16){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.seventy);
            content = MediaPlayer.create(this, R.raw.seventy);
        }
        else if (myList.get(0) == 17){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.eighty);
            content = MediaPlayer.create(this, R.raw.eighty);
        }
        else if (myList.get(0) == 18){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.ninety);
            content = MediaPlayer.create(this, R.raw.ninety);
        }
        else if (myList.get(0) == 19){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.hundred);
            content = MediaPlayer.create(this, R.raw.hundred);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_number_game, menu);
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
    public void imageBtn(View view) {//code for playing description sound
        content.start();
        scorePenalty = 1;
        hint = true;
    }

    public void one(View view){
        if(myList.get(0) == 1){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void two(View view){
        if(myList.get(0) == 2){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void three(View view){
        if(myList.get(0) == 3){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void four(View view){
        if(myList.get(0) == 4){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void five(View view){
        if(myList.get(0) == 5){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void six(View view){
        if(myList.get(0) == 6){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void seven(View view){
        if(myList.get(0) == 7){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void eight(View view){
        if(myList.get(0) == 8){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void nine(View view){
        if(myList.get(0) == 9){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void ten(View view){
        if(myList.get(0) == 10){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void twenty(View view){
        if(myList.get(0) == 11){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void thirty(View view){
        if(myList.get(0) == 12){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void forty(View view){
        if(myList.get(0) == 13){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void fifty(View view){
        if(myList.get(0) == 14){
            correctSound.start();
            score = score + scorePenalty;//add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void sixty(View view){
        if(myList.get(0) == 15){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void seventy(View view){
        if(myList.get(0) == 16){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void eighty(View view){
        if(myList.get(0) == 17){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void ninety(View view){
        if(myList.get(0) == 18){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void hundred(View view){
        if(myList.get(0) == 19){
            correctSound.start();
            score = score + scorePenalty; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }
}
