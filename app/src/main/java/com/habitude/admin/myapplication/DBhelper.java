package com.habitude.admin.myapplication;

/**
 * Created by ADMIN on 22-09-2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    static String DBNAME = "mydb";
    static String tblname = "Habittable";

    static String col1 = "id";
    static String col2 = "text";
    static String col3 = "time";
    static String col4 = "days";


    public DBhelper(Context context, String name, CursorFactory factory, int version) {
        super(context, DBNAME, null, 1);
        // TODO Auto-generated constructor stub
    }

   /* @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        String query="CREATE TABLE "+tblname+"("+col1+" text,"+col2+" text)";
        arg0.execSQL(query);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tblname + " ( "
                + col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col2 + " TEXT, " + col3 + " TEXT, "
                + col4 + " TEXT)";
        db.execSQL(sql);
    }

    public void inRecords(String habit, String days, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "insert into " + tblname + " values(null,'" + habit + "','" + days + "','" + time + "');";
        db.execSQL(s);
    }

    public Cursor getAllTitles() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + tblname, null);
    }

    public void deleterow(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "DELETE FROM " + tblname + " WHERE text ='" + id + "'";
        db.execSQL(s);
    }

    public Cursor selecttype(String tag) {
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "select text FROM " + tblname + " WHERE day=s'" + tag + "'";

        return db.rawQuery(s, null);
    }

    public Cursor selRecs() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select text from " + tblname, null);

    }

    public Cursor selRecs1() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select text from " + tblname, null);

    }

    /*public void update(String task){
        SQLiteDatabase db=this.getWritableDatabase();


        String s = "UPDATE taskTable SET tag='comp' WHERE task='"+task+"'";
        db.execSQL(s);
    }*/
    public void deleteall() {
        SQLiteDatabase db = this.getWritableDatabase();
        //String s ="DELETE FROM "+tblname+" WHERE text ='"+id+"'";
        db.execSQL("delete from " + tblname);

    }

    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "drop table " + tblname;
        db.execSQL("DROP TABLE IF EXISTS " + tblname);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
