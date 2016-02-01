package com.example.ianc.powerofwords;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainWindowDyslexia extends ActionBarActivity {

    ImageButton s;
    ImageButton L;
    ImageButton M;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window_dyslexia);

        s = (ImageButton) findViewById(R.id.SimilarBTN);
        L = (ImageButton) findViewById(R.id.Listening);
        M = (ImageButton) findViewById(R.id.Multi);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_window_dyslexia, menu);
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


    public void SimilarWords(View view) {
        Intent intent = new Intent(this, SimilarWordsGame.class);
        startActivity(intent);
    }

    public void Listen(View view) {
        Intent intent = new Intent(this, Listen.class);
        startActivity(intent);
    }

    public void ThisMultiChoice(View view) {
        Intent intent = new Intent(this, MultiChoice.class);
        startActivity(intent);
    }
}
