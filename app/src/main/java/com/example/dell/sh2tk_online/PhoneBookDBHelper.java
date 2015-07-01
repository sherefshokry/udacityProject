package com.example.dell.sh2tk_online;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DELL on 7/1/2015.
 */
public class PhoneBookDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "phonebook.db";
    public static final int DB_VERSION = 1;

    public PhoneBookDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("create table : "," 1 ");
        db.execSQL(mycontactsTable.CREATE_TABLE);
        Log.e("create table : "," 2 ");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + mycontactsTable.TABLE_NAME);
        db.execSQL(mycontactsTable.CREATE_TABLE);

    }
}
