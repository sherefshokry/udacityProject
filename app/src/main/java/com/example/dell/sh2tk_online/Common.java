package com.example.dell.sh2tk_online;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DELL on 7/1/2015.
 */
public class Common
{

public SQLiteDatabase _sql;
public PhoneBookDBHelper phone;
public String TABLE_NAME;


    public Common (Context context , String TABLE_NAME)
    {

        phone = new PhoneBookDBHelper (context);
        this.TABLE_NAME=TABLE_NAME;
    }

    public void openWrite()
    {

        _sql = phone.getWritableDatabase();

    }


    public void openRead()
    {

        _sql = phone.getReadableDatabase();

    }

    public void close()
    {
        phone.close();
    }

public boolean removeAll() {
   boolean result =true;
    try {
        openWrite();
      _sql.execSQL("DELETE FROM " + TABLE_NAME);
        close();
    } catch (Exception e) {


    }
    return result;
}
}
