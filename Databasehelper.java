package com.appsplanet.test.androidtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "contacts";
    private String DB_TABLE = "Contact";
    public static final int DB_VERSION = 1;

    public Databasehelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Contact(_id integer primary key autoincrement,name text,email text,address text,gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Contact contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",contact.getName());
        values.put("email",contact.getEmail());
        values.put("address",contact.getAddress());
        values.put("gender",contact.getGender());
        db.insert(DB_TABLE,null,values);
    }

    public ArrayList<Contact> show(){
        SQLiteDatabase database = getWritableDatabase();
        ArrayList<Contact> contacts = new ArrayList<>();
        Cursor cursor = database.query(DB_TABLE,new String[]{"name","email","address","gender"},null,null,null,null,null);
        while (cursor.moveToNext()){
            contacts.add(new Contact(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
        }

        return contacts;
    }
}
