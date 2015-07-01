package com.example.dell.sh2tk_online;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {


private Button   _login , _signUp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _login = (Button) findViewById(R.id.loginbtn);
        _signUp = (Button) findViewById(R.id.signupbtn);


        _login.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent loginIntent = new Intent(getApplicationContext(),logIn.class);
                startActivity(loginIntent);
            }
        });

        _signUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent registerationIntent = new Intent(getApplicationContext(),signUp.class);
                startActivity(registerationIntent);
            }
        });

    }


}
