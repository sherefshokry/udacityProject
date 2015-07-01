package com.example.dell.sh2tk_online;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DELL on 6/26/2015.
 */
public class advertisment extends ActionBarActivity {

    Button addphoto_btn;
    Button record_btn;
    EditText _address;
    EditText _area;
    EditText _price;
    EditText _description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertismenrtform_activiry);

        Bundle extras = getIntent().getExtras();
        // String status = extras.getString("status");
      final  String Name;
        final String Email;
        Name = extras.getString("name");
        Email = extras.getString("email");

        _address = (EditText) findViewById(R.id.address);
        _area = (EditText) findViewById(R.id.area);
        _price = (EditText) findViewById(R.id.price);
        _description = (EditText) findViewById(R.id.description);
        addphoto_btn = (Button) findViewById(R.id.addphoto);
        record_btn = (Button) findViewById(R.id.record);


        addphoto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImage();

            }
        });


        record_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userController controller = new userController();
                controller.addAdvertisment(_address.getText().toString(), _area
                        .getText().toString(), _price.getText().toString(), _description.getText().toString(), Email,Name);

            }
        });

    }

    private void selectImage() {

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(advertisment.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
}