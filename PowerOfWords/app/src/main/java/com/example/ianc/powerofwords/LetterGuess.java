package com.example.ianc.powerofwords;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class LetterGuess extends ActionBarActivity {
    MediaPlayer content, correctSound, wrongSound;//variables for sound files
    ImageButton btn; //this variable is for changing the image in the advanced activity
    TextView scoreText, timeLimit; //this variable is used for updating the score info
    int score, scorePenalty;
    boolean counter = (true);
    boolean timeout = (true);
    String scoreString;
    boolean hint = (false);//used to determine if the user used any hints when outputting the score.
    private static final String FORMAT = "%02d:%02d";//this string defines the format of the countdown timer in the game

    private ArrayList<Integer> myList = new ArrayList<>();//arraylist to hold sequential numbers from 1 to however many objects I need.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_guess);

        timeLimit=(TextView)findViewById(R.id.CountdownLbl); //this variable updates the countdown ticker in the game

        correctSound = MediaPlayer.create(this, R.raw.correctans);
        wrongSound = MediaPlayer.create(this, R.raw.fail);

        //this code is for the instructions alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instructions.");
        alertDialog.setMessage("Here you can test your knowledge of words. " +
                "\nTap the letter that corresponds with the word shown. " +
                "\nYou can tap the image to hear the word but be warned! " +
                "\nYou'll get more points without using up a hint!" );
        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                new CountDownTimer(60000, 1000) { // adjust the milli seconds here - 1000 = 1 second

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

    public void Random() {
        scorePenalty = 3;//resetting the score penalty value to 3 after it was set to one by using the hints.
        while (counter == (true)) {//Making sure arraylist only writes initial values on first application load, not after every question.
            for (int i = 1; i < 27; i++) {//adding the numbers 1-3 to the indexes in the array
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
            else if (hint == false && score == 78){//checked no hints were used and max points achieved, user == BOSS!
                alertDialog.setTitle("Your Score:");
                alertDialog.setMessage("Wow! You MAXED it! " +
                        "\nScore: " + score);
            }
            else{//returns user score if they didn't use hints but didn't score max points.
                alertDialog.setTitle("Your Score:");
                alertDialog.setMessage("Congratulations, Your score is " + score);
            }
            alertDialog.setButton("Proceed", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {}});

            timeout = false;
            alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show
        }
        else if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set the question and answer to RED - answer is set in button methods below
            btn.setImageResource(R.drawable.arnold);
            content = MediaPlayer.create(this, R.raw.arnold);
        }
        else if (myList.get(0) == 2){//if the integer at index 0 is a 1, set the question and answer to YELLOW - answer is set in button methods below
            btn.setImageResource(R.drawable.bicycle2);
            content = MediaPlayer.create(this, R.raw.bicyclelet);
        }
        else if (myList.get(0) == 3){//if the integer at index 0 is a 1, set the question and answer to PINK - answer is set in button methods below
            btn.setImageResource(R.drawable.chair);
            content = MediaPlayer.create(this, R.raw.chair);
        }
        else if (myList.get(0) == 4){//if the integer at index 0 is a 1, set the question and answer to GREEN - answer is set in button methods below
            btn.setImageResource(R.drawable.debt);
            content = MediaPlayer.create(this, R.raw.debt);
        }
        else if (myList.get(0) == 5){//if the integer at index 0 is a 1, set the question and answer to PURPLE - answer is set in button methods below
            btn.setImageResource(R.drawable.echo);
            content = MediaPlayer.create(this, R.raw.ehco);
        }
        else if (myList.get(0) == 6){//if the integer at index 0 is a 1, set the question and answer to ORANGE - answer is set in button methods below
            btn.setImageResource(R.drawable.france);
            content = MediaPlayer.create(this, R.raw.france);
        }
        else if (myList.get(0) == 7){//if the integer at index 0 is a 1, set the question and answer to BLUE - answer is set in button methods below
            btn.setImageResource(R.drawable.garage);
            content = MediaPlayer.create(this, R.raw.garage);
        }
        else if (myList.get(0) == 8){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.hair);
            content = MediaPlayer.create(this, R.raw.hair);
        }
        else if (myList.get(0) == 9){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.invent);
            content = MediaPlayer.create(this, R.raw.invent);
        }
        else if (myList.get(0) == 10){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.junior);
            content = MediaPlayer.create(this, R.raw.junior);
        }
        else if (myList.get(0) == 11){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.know);
            content = MediaPlayer.create(this, R.raw.knowlet);
        }
        else if (myList.get(0) == 12){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.latvia);
            content = MediaPlayer.create(this, R.raw.latvia);
        }
        else if (myList.get(0) == 13){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.mother);
            content = MediaPlayer.create(this, R.raw.mother);
        }
        else if (myList.get(0) == 14){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.narnia);
            content = MediaPlayer.create(this, R.raw.narnia);
        }
        else if (myList.get(0) == 15){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.oscar);
            content = MediaPlayer.create(this, R.raw.oscar);
        }
        else if (myList.get(0) == 16){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.puppy);
            content = MediaPlayer.create(this, R.raw.puppy);
        }
        else if (myList.get(0) == 17){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.quay);
            content = MediaPlayer.create(this, R.raw.quay);
        }
        else if (myList.get(0) == 18){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.richie);
            content = MediaPlayer.create(this, R.raw.richie);
        }
        else if (myList.get(0) == 19){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.shore);
            content = MediaPlayer.create(this, R.raw.shore);
        }
        else if (myList.get(0) == 20){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.ticket);
            content = MediaPlayer.create(this, R.raw.ticket);
        }
        else if (myList.get(0) == 21){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.undo);
            content = MediaPlayer.create(this, R.raw.undo);
        }
        else if (myList.get(0) == 22){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.victory);
            content = MediaPlayer.create(this, R.raw.victory);
        }
        else if (myList.get(0) == 23){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.woolen);
            content = MediaPlayer.create(this, R.raw.woolen);
        }
        else if (myList.get(0) == 24){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.xerox);
            content = MediaPlayer.create(this, R.raw.xerox);
        }
        else if (myList.get(0) == 25){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.yacht);
            content = MediaPlayer.create(this, R.raw.yacht);
        }
        else if (myList.get(0) == 26){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(R.drawable.zigzag);
            content = MediaPlayer.create(this, R.raw.zigzag);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_letter_guess, menu);
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

    public void ABtn(View view){
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

    public void BBtn(View view){
        if(myList.get(0) == 2){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random();//regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void CBtn(View view){
        if(myList.get(0) == 3){
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

    public void DBtn(View view){
        if(myList.get(0) == 4){
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

    public void EBtn(View view){
        if(myList.get(0) == 5){
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

    public void FBtn(View view){
        if(myList.get(0) == 6){
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

    public void GBtn(View view){
        //if(blue == (true)){
        if(myList.get(0) == 7){
            correctSound.start(); //outputting the sound to indicate correct answer
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start(); //outputting the sound to indicate incorrect answer
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void HBtn(View view){
        if(myList.get(0) == 8){
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

    public void IBtn(View view){
        if(myList.get(0) == 9){
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

    public void JBtn(View view){
        if(myList.get(0) == 10){
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

    public void KBtn(View view){
        if(myList.get(0) == 11){
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

    public void LBtn(View view){
        if(myList.get(0) == 12){
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

    public void MBtn(View view){
        if(myList.get(0) == 13){
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

    public void NBtn(View view){
        if(myList.get(0) == 14){
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

    public void OBtn(View view){
        if(myList.get(0) == 15){
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

    public void PBtn(View view){
        if(myList.get(0) == 16){
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

    public void QBtn(View view){
        if(myList.get(0) == 17){
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

    public void RBtn(View view){
        if(myList.get(0) == 18){
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

    public void SBtn(View view){
        if(myList.get(0) == 19){
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

    public void TBtn(View view){
        if(myList.get(0) == 20){
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

    public void UBtn(View view){
        if(myList.get(0) == 21){
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

    public void VBtn(View view){
        if(myList.get(0) == 22){
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

    public void WBtn(View view){
        if(myList.get(0) == 23){
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

    public void XBtn(View view){
        if(myList.get(0) == 24){
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

    public void YBtn(View view){
        if(myList.get(0) == 25){
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

    public void ZBtn(View view){
        if(myList.get(0) == 26){
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
}
