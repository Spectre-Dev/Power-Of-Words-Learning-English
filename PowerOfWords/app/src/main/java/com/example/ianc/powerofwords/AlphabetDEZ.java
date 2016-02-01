package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;


public class AlphabetDEZ extends ActionBarActivity {
    MediaPlayer content, correctSound, wrongSound;
    ImageButton btn;
    Boolean counter = (true);

    private ArrayList<Integer> myList = new ArrayList<>();//arraylist to hold sequential numbers from 1 to however many objects needed.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_dez);

        //alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instructions.");
        alertDialog.setMessage("Try to find the missing letter. " +
                "\nLets see how much you can get right!");
        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        correctSound = MediaPlayer.create(this, R.raw.success);
        wrongSound = MediaPlayer.create(this, R.raw.wrong);

        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        content = MediaPlayer.create(this, R.raw.drop);

        btn = (ImageButton) findViewById(R.id.dropBtn);//image button to be changed
        Random();//Running the random method
    }

    public void Random() {
        while (counter == (true)) {
            for (int i = 1; i < 27; i++) {
                myList.add(Integer.valueOf(i));
            }
            Collections.shuffle(myList);
            counter = (false);
        }

        if (myList.isEmpty()) {
            //TO DO: set a method here that tells them the game is over.
            //this alert ends the game an outputs the score
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Hooray!!");
            alertDialog.setMessage("Congratulations, Your learning! ");
            alertDialog.setButton("Proceed", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });


            //commented out sound since not needed at the moment.
        }
        if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set image to NAIL.
            btn.setImageResource(R.drawable.nail);
            //  content = MediaPlayer.create(this, R.raw.nail);
        } else if (myList.get(0) == 2) {//if the integer at index 0 is a 2, set image to BOSS.
            btn.setImageResource(R.drawable.boss);
            //  content = MediaPlayer.create(this, R.raw.boss);
        } else if (myList.get(0) == 3) {//if the integer at index 0 is a 3, set image to ACID.
            btn.setImageResource(R.drawable.acid);
            // content = MediaPlayer.create(this, R.raw.acid);
        } else if (myList.get(0) == 4) {//if the integer at index 0 is a 4, set image to IDOL.
            btn.setImageResource(R.drawable.idol);
            //  content = MediaPlayer.create(this, R.raw.idol);
        } else if (myList.get(0) == 5) {//if the integer at index 0 is a 5, set image to LEAF.
            btn.setImageResource(R.drawable.leaf);
            ///  content = MediaPlayer.create(this, R.raw.leaf);
        } else if (myList.get(0) == 6) {//if the integer at index 0 is a 6, set image to FARM.
            btn.setImageResource(R.drawable.farm);
            //  content = MediaPlayer.create(this, R.raw.farm);
        } else if (myList.get(0) == 7) {//if the integer at index 0 is a 7, set image to DRAG.
            btn.setImageResource(R.drawable.drag);
            //  content = MediaPlayer.create(this, R.raw.drag);
        } else if (myList.get(0) == 8) {//if the integer at index 0 is a 8, set image to HAIR.
            btn.setImageResource(R.drawable.hair2);
            //  content = MediaPlayer.create(this, R.raw.hair);
        } else if (myList.get(0) == 9) {//if the integer at index 0 is a 9, set image to MILK.
            btn.setImageResource(R.drawable.milk);
            //  content = MediaPlayer.create(this, R.raw.milk);
        } else if (myList.get(0) == 10) {//if the integer at index 0 is a 10, set image to JAZZ.
            btn.setImageResource(R.drawable.jazz);
            //  content = MediaPlayer.create(this, R.raw.jazz);
        } else if (myList.get(0) == 11) {//if the integer at index 0 is a 11, set image to KNEEE.
            btn.setImageResource(R.drawable.kneee);
            content = MediaPlayer.create(this, R.raw.kneee);
        } else if (myList.get(0) == 12) {//if the integer at index 0 is a 12, set image to LIME.
            btn.setImageResource(R.drawable.lime);
            //  content = MediaPlayer.create(this, R.raw.lime);
        } else if (myList.get(0) == 13) {//if the integer at index 0 is a 13, set image to JUMP.
            btn.setImageResource(R.drawable.jump);
            // content = MediaPlayer.create(this, R.raw.jump);
        } else if (myList.get(0) == 14) {//if the integer at index 0 is a 14, set image to SENT.
            btn.setImageResource(R.drawable.sent);
            // content = MediaPlayer.create(this, R.raw.sent);
        } else if (myList.get(0) == 15) {//if the integer at index 0 is a 15, set image to WOOD.
            btn.setImageResource(R.drawable.wood);
            // content = MediaPlayer.create(this, R.raw.wood);
        } else if (myList.get(0) == 16) {//if the integer at index 0 is a 16, set image to COPY.
            btn.setImageResource(R.drawable.copy);
            //  content = MediaPlayer.create(this, R.raw.copy);
        } else if (myList.get(0) == 17) {//if the integer at index 0 is a 17, set image to QUIZ.
            btn.setImageResource(R.drawable.quiz);
            // content = MediaPlayer.create(this, R.raw.quiz);
        } else if (myList.get(0) == 18) {//if the integer at index 0 is a 18, set image to DROP.
            btn.setImageResource(R.drawable.drop);
            //  content = MediaPlayer.create(this, R.raw.drop);
        } else if (myList.get(0) == 19) {//if the integer at index 0 is a 19, set image to CASEE.
            btn.setImageResource(R.drawable.casee);
            //  content = MediaPlayer.create(this, R.raw.casee);
        } else if (myList.get(0) == 20) {//if the integer at index 0 is a 20, set image to TEXT.
            btn.setImageResource(R.drawable.text);
            //  content = MediaPlayer.create(this, R.raw.text);
        } else if (myList.get(0) == 21) {//if the integer at index 0 is a 21, set image to UNIT.
            btn.setImageResource(R.drawable.unit);
            //  content = MediaPlayer.create(this, R.raw.unit);
        } else if (myList.get(0) == 22) {//if the integer at index 0 is a 22, set image to LOVE.
            btn.setImageResource(R.drawable.love);
            // content = MediaPlayer.create(this, R.raw.love);
        } else if (myList.get(0) == 23) {//if the integer at index 0 is a 23, set image to SNOW.
            btn.setImageResource(R.drawable.snow);
            // content = MediaPlayer.create(this, R.raw.snow);
        } else if (myList.get(0) == 24) {//if the integer at index 0 is a 24, set image to TAXI.
            btn.setImageResource(R.drawable.taxi);
            // content = MediaPlayer.create(this, R.raw.taxi);
        } else if (myList.get(0) == 25) {//if the integer at index 0 is a 25, set image to BABY.
            btn.setImageResource(R.drawable.baby);
            // content = MediaPlayer.create(this, R.raw.baby);
        } else if (myList.get(0) == 26) {//if the integer at index 0 is a 26, set image to ZONE.
            btn.setImageResource(R.drawable.zone);
            // content = MediaPlayer.create(this, R.raw.zone);
        }
    }



    public void playSound(View view) {
        content.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_alphabet_dez, menu);
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

    public void dropBtn(View view) {//code for playing description sound
        content.start();
    }

    public void ABtn(View view) {
        if (myList.get(0) == 1) {
            correctSound.start();
        } else {
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void BBtn(View view) {
        if (myList.get(0) == 2) {
            correctSound.start();
        } else {
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void CBtn(View view) {
        if (myList.get(0) == 3) {
            correctSound.start();
        } else {
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void DBtn(View view) {
        if (myList.get(0) == 4) {
            correctSound.start();
        } else {
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void EBtn(View view){
        if(myList.get(0) == 5){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void FBtn(View view){
        if(myList.get(0) == 6){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void GBtn(View view){
        if(myList.get(0) == 7){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void HBtn(View view){
        if(myList.get(0) == 8){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void IBtn(View view){
        if(myList.get(0) == 9){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void JBtn(View view){
        if(myList.get(0) == 10){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void KBtn(View view){
        if(myList.get(0) == 11){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void LBtn(View view){
        if(myList.get(0) == 12){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }


    public void MBtn(View view){
        if(myList.get(0) == 13){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void NBtn(View view){
        if(myList.get(0) == 14){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void OBtn(View view){
        if(myList.get(0) == 15){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void PBtn(View view){
        if(myList.get(0) == 16){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void QBtn(View view){
        if(myList.get(0) == 17){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void RBtn(View view){
        if(myList.get(0) == 18){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void SBtn(View view){
        if(myList.get(0) == 19){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void TBtn(View view){
        if(myList.get(0) == 20){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void UBtn(View view){
        if(myList.get(0) == 21){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void VBtn(View view){
        if(myList.get(0) == 22){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void WBtn(View view){
        if(myList.get(0) == 23){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void XBtn(View view){
        if(myList.get(0) == 24){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void YBtn(View view){
        if(myList.get(0) == 25){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void ZBtn(View view){
        if(myList.get(0) == 26){
            correctSound.start();
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again.
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }
}