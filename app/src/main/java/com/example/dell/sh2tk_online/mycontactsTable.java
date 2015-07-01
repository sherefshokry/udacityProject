package com.example.dell.sh2tk_online;

/**
 * Created by DELL on 7/1/2015.
 */
public class mycontactsTable {

public static final String TABLE_NAME = "contacts";

    public static final String PhoneNumber= "phone number";
    public static final String Name = "name";

    public static final String CREATE_TABLE = "CREATE TABLE " +  TABLE_NAME + "("
            + Name  + " TEXT, "
            + PhoneNumber + " TEXT );";


}
