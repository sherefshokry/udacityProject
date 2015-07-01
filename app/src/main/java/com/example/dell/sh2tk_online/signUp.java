package com.example.dell.sh2tk_online;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DELL on 6/24/2015.
 */
public class signUp  extends ActionBarActivity implements View.OnClickListener
{

    EditText _uname;
    EditText _email;
    EditText _password;
    EditText _phoneNumber;
    EditText _address;
    Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
      _uname = (EditText) findViewById(R.id.nametext);
        _email = (EditText) findViewById(R.id.emailtext);
        _password = (EditText) findViewById(R.id.passwordtext);
        _phoneNumber = (EditText) findViewById(R.id.phonetext);
        _address = (EditText) findViewById(R.id.addresstext);
        signupButton = (Button) findViewById(R.id.signupbtn);
        signupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        userController controller = new  userController();
        controller.signUp(_uname.getText().toString(),_email.getText().toString(),_password
                .getText().toString(),_phoneNumber.getText().toString(),_address.getText().toString());
    }

}
