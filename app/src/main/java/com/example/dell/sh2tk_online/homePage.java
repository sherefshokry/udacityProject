package com.example.dell.sh2tk_online;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by DELL on 6/24/2015.
 */
public class homePage   extends ActionBarActivity
{
    Button advertisment_btn;
    Button  sell_btn;
    Button  contact_btn;
    private String name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        new PhoneBookDBHelper(getApplicationContext()).getWritableDatabase();



        Bundle extras = getIntent().getExtras();

name="";
email="";
        // String status = extras.getString("status");

            name = extras.getString("name");
            email = extras.getString("email");


        contact_btn   = (Button) findViewById(R.id.contact);

        contact_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent Main = new Intent(ApplicationContextProvider.getContext(),
                        myContacts.class);

                startActivity(Main);

            }
        });

        advertisment_btn   = (Button) findViewById(R.id.add);

        advertisment_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent Main = new Intent(ApplicationContextProvider.getContext(),
                        advertisment.class);
                Main.putExtra("name", name);
                Main.putExtra("email", email);

                startActivity(Main);

            }
        });

        sell_btn   = (Button) findViewById(R.id.sell);

        sell_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userController controller = new  userController();
                controller.getSellFlats();
            }
        });




    }
}
