package com.example.dell.sh2tk_online;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DELL on 6/26/2015.
 */
public class sellFlats extends ActionBarActivity
{
    Button advertisment_btn;
    Button  sell_btn;
    Button  rent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellflats_activity);

        Bundle extras = getIntent().getExtras();

        // String status = extras.getString("status");
       String address = "";

        address = extras.getString("Address");




        final String[] addresses = address.split("#");

        ArrayAdapter<String> data;

        final List<String> userNames = new ArrayList<String>(Arrays.asList(addresses));

        data = new ArrayAdapter<String>(this, R.layout.listview ,
                R.id.view, userNames);

        final ListView list = (ListView) findViewById(R.id.ListItem);

        list.setAdapter(data);

/*        list.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

*/
    }
    }
