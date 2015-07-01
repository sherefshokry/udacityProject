package com.example.dell.sh2tk_online;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DELL on 6/24/2015.
 */
public class logIn  extends ActionBarActivity  implements View.OnClickListener
{

    EditText _email;
    EditText _password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        _email = (EditText) findViewById(R.id.emailtext);
        _password = (EditText) findViewById(R.id.passwordtext);
        loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        userController controller = new  userController();
        controller.login(_email.getText().toString(),_password
                .getText().toString());
    }

}
