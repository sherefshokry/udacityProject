package com.example.dell.sh2tk_online;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by DELL on 7/1/2015.
 */
public class contactAdapter extends Common {

public String  [] AllColumns =
        {

        mycontactsTable.Name,
        mycontactsTable.PhoneNumber

       };



   public  contactAdapter(Context context , String TableName)
   {
       super(context,TableName);

   }

    public long Insert(String name , String phone )
    {
long result= -1;

        try{

openWrite();
            ContentValues content = new ContentValues();

            content.put(AllColumns[0] ,name );
            content.put(AllColumns[1] ,phone );
            result= _sql.insert(TABLE_NAME,null , content);
        }
catch (Exception ex)
{



}
return result;

    }


public int Delete (String phone)
{
int result = -1;

    try{

        openWrite();
result= _sql.delete(TABLE_NAME , AllColumns[1],null );
        close();
    }
    catch (Exception ex)
    {


    }
return result;


}



}
