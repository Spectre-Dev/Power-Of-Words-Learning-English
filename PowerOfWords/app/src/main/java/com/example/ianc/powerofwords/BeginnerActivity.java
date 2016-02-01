package com.example.ianc.powerofwords;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BeginnerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
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

    public void signOut(View view) {
        final Dialog dialog;
        dialog = new Dialog(BeginnerActivity.this);
        dialog.setContentView(R.layout.activity_sign_out);
        dialog.setTitle("Sign Out");

        Button yesBtn = (Button) dialog.findViewById(R.id.yesBtn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(BeginnerActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        Button noBtn = (Button) dialog.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void readAndListenBtn(View view) {
        Intent intent = new Intent(this, ReadAndListen.class);
        startActivity(intent);

    }

    public void AlfaB(View view) {
        Intent intent = new Intent(this, AlphabetDEZ.class);
        startActivity(intent);
    }

    public void WD(View view){
        Intent intent = new Intent(this, WeekDays.class);
        startActivity(intent);
    }
}
