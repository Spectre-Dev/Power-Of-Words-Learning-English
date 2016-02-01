package com.example.ianc.powerofwords;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class LevelActivity extends ActionBarActivity implements View.OnClickListener {
    ImageView userImageView;
    ImageButton childButton;
    ImageButton phonicsButton;
    ImageButton advancedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        userImageView = (ImageView) findViewById(R.id.userImageView);
        childButton = (ImageButton) findViewById(R.id.childButton);
        phonicsButton = (ImageButton) findViewById(R.id.phonicsButton);
        advancedButton = (ImageButton) findViewById(R.id.advancedButton);

        String test = getIntent().getExtras().getString("Some Key");
        TextView usernameTextView = (TextView) findViewById(R.id.usernameTextView);
        usernameTextView.setText(test);

        childButton.setOnClickListener(this);
        phonicsButton.setOnClickListener(this);
        advancedButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level, menu);
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

    public void startProfileImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), 1);
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqCode == 1) {
                //imageUri = data.getData();
                userImageView.setImageURI(data.getData());
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.childButton){
            Intent intent = new Intent(this, KidsActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.phonicsButton){
            Intent intent = new Intent(this, PhonicsActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.advancedButton){
            Intent intent = new Intent(this, LandingPage.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.beginnerButton){
            Intent intent = new Intent(this, BeginnerActivity.class);
            startActivity(intent);
        }

    }

    public void openDyslexic(View view) {
        Intent intent = new Intent(this, MainWindowDyslexia.class);
        startActivity(intent);
    }

    public void beginnerButton(View view) {
        Intent intent = new Intent(this, BeginnerActivity.class);
        startActivity(intent);
    }
}
