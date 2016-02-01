package com.example.ianc.powerofwords;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ScoreOptionsActivity extends ActionBarActivity implements View.OnClickListener {

    EditText editUserName, editScore;
    Button btnAdd, btnDelete, btnModify, btnViewAll;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_options);
        editUserName =(EditText)findViewById(R.id.editUserName);
        editScore =(EditText)findViewById(R.id.editScore);

        String test = getIntent().getExtras().getString("Key");
        editScore.setText(test);

        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnDelete=(Button)findViewById(R.id.btnDelete);
        btnModify=(Button)findViewById(R.id.btnModify);
        btnViewAll=(Button)findViewById(R.id.btnViewAll);

        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);

        db=openOrCreateDatabase("Scoreboard", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS scores(name VARCHAR,score INT);");

        //set home as up
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    public void onClick(View view)
    {
        //create score details into the database
        if(view==btnAdd)
        {
            if(editUserName.getText().toString().length()==0||
                    editScore.getText().toString().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO scores VALUES('"+ editUserName.getText()+"','"+ editScore.getText()+
                    "');");
            showMessage("Success", "Score added");
            clearText();

        }

        //delete score details from the database
        if(view==btnDelete)
        {
            if(editUserName.getText().toString().length()==0)
            {
                showMessage("Error", "Please enter Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM scores WHERE name='"+ editUserName.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM scores WHERE name='"+ editUserName.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Name");
            }
            clearText();
        }

        //update score details in the database
        if(view==btnModify)
        {
            if(editUserName.getText().toString().length()==0)
            {
                showMessage("Error", "Please enter Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM scores WHERE name='"+ editUserName.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("UPDATE scores SET score='"+ editScore.getText()+"' WHERE name='"+ editUserName.getText()+"'");
                showMessage("Success", "Record Modified");
            }
            else
            {
                showMessage("Error", "That name does not exist ");
            }
            clearText();
        }

        //read all score details from the database, method used to display leaderboard
        if(view==btnViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM scores ORDER BY score DESC", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No scores found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Name: "+c.getString(0)+"\n");
                buffer.append("Score: "+c.getString(1)+"\n");
                buffer.append("\n");
            }

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            alertDialog.setTitle("Leaderboard");

            alertDialog.setMessage(buffer.toString());

            alertDialog.setIcon(R.drawable.leaderboard);

            alertDialog.setButton("OK!", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {}});

            alertDialog.show();//this tells the above icon to show

        }

    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText(){
        editUserName.setText("");
        editScore.setText("");
        editUserName.requestFocus();
    }
}
