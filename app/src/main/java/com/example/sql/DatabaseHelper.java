package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String dbname= "Student.db";
    public static final String tablename="Student";
    public static final String c1="ID";
    public static final String c2="name";
    public static final String c3="Surname";
    public static final String c4="Marks";


    public DatabaseHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +tablename+"(  id INTEGER primary key autoincrement,name text,surname text,marks integer )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+tablename);
        onCreate(db);

    }
    public boolean insertData(String Name,String Surname,int Marks){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(c2,Name);
        c.put(c3,Surname);
        c.put(c4,Marks);
        long r=sqLiteDatabase.insert(tablename,null,c);
        if(r== -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean updateData(String id,String Name,String Surname,int Marks){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(c1,id);
        c.put(c2,Name);
        c.put(c3,Surname);
        c.put(c4,Marks);
        long r=sqLiteDatabase.update(tablename,c,"ID=?",new String[]{id});
        if(r== -1){
            return false;
        }else{
            return true;
        }
    }
}