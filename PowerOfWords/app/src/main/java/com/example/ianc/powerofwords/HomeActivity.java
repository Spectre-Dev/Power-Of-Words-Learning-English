package com.example.ianc.powerofwords;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HomeActivity extends ActionBarActivity {
    Button signInBtn;
    Button signUpBtn;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //create an instance of the database
        dbHandler = new DatabaseHandler(this);

        //create instance of the buttons
        signInBtn = (Button) findViewById(R.id.signInBtn);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    //method that handles the clickEvent of the sign in button
    public void signIn(View view) {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.activity_sign_in);
        dialog.setTitle("Sign In");

        final EditText usernameEditText = (EditText)dialog.findViewById(R.id.usernameEditText);
        final EditText passwordEdiText = (EditText)dialog.findViewById(R.id.passwordEditText);

        Button signInButton = (Button)dialog.findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEdiText.getText().toString();

                String dbPassword = dbHandler.readUser(username);

                //if password entered matches the stored password in the database
                if(password.equals(dbPassword))
                {
                    dialog.dismiss();
                    Bundle b = new Bundle();
                    b.putString("Some Key", username);
                    Intent intent = new Intent(HomeActivity.this, LevelActivity.class);
                    intent.putExtras(b);
                    startActivity(intent);
                    Toast.makeText(HomeActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                }
                //if password entered does not match the stored password in the database
                else
                {
                    Toast.makeText(HomeActivity.this, "Username or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    public void signUp(View view) {
        Intent intentSignUP=new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intentSignUP);
    }
}
