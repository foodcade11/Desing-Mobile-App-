package com.example.desindmobile;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MysqliteDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="user_db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="userinfo";
    private static final String USER_C="username";
    private static final String PASS_C="pass";


    String createTble="create table "+TABLE_NAME+"(id integer primary key autoincrement ,"+USER_C+" text, "+PASS_C+" text)";

     Context ctx;

    public MysqliteDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(createTble);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table " +TABLE_NAME);
        onCreate(db);
    }

    public void  addNewUserToDatabase(String user,String pass)
    {
  SQLiteDatabase db=this.getWritableDatabase();
        ContentValues Values=new ContentValues();
        Values.put(USER_C,user);
        Values.put(PASS_C,pass);
  db.insert(TABLE_NAME, null,Values);
  showSms("USER SAVED");

    }



    void showSms(String sms)
    {
        Toast.makeText(ctx, sms, Toast.LENGTH_SHORT).show();
    }

    public void checkUserInfo(String user, String pass) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.query(TABLE_NAME,
                null,USER_C+"=? and "+PASS_C+"=?",
                new String[]{user,pass},
                null,
                null,
                null);
        if (c.getCount()>0){

            Intent goMain=new Intent(ctx,Example.class);
           ctx.startActivity(goMain);
        }
        else{
            showSms("username or password are not incorrect");
        }
    }
}
