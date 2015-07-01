package com.example.dell.sh2tk_online;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DELL on 7/1/2015.
 */
public class myContacts extends ActionBarActivity {

    Button insert_btn;
    Button  delete_btn;
    Button  contacts_btn;
    EditText _name;
    EditText _phone;
    EditText _dphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycontacts_activity);

        new PhoneBookDBHelper(getApplicationContext()).getWritableDatabase();


        _name = (EditText) findViewById(R.id.nname);
        _phone = (EditText) findViewById(R.id.nphone);
        _dphone = (EditText) findViewById(R.id.dphone);

        insert_btn = (Button) findViewById(R.id.insert);

        insert_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                contactAdapter ad = new contactAdapter(ApplicationContextProvider.getContext(), "contacts");
                ad.Insert(_name.getText().toString(), _phone.getText().toString());

            }
        });

        delete_btn = (Button) findViewById(R.id.delete);

        delete_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                contactAdapter ad = new contactAdapter(ApplicationContextProvider.getContext(), "contacts");
                ad.Delete(_phone.getText().toString());


            }
        });


        contacts_btn = (Button) findViewById(R.id.contact);

        contacts_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });


    }
    }




