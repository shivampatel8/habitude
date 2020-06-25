package com.habitude.admin.myapplication;

/**
 * Created by ADMIN on 22-09-2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper1 extends SQLiteOpenHelper {
    static String DBNAME = "mydb1";
    static String tblname = "bucketlist";
    static String col1 = "id";
    static String col2 = "text";
    static String col3 = "status";

    public DBhelper1(Context context, String name, CursorFactory factory, int version) {
        super(context, DBNAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tblname + " ( "
                + col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col2 + " TEXT, " + col3 + " TEXT)";
        db.execSQL(sql);
    }

    public void inRecords(String dream) {
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "insert into " + tblname + " values(null,'" + dream + "','pending');";
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

    /* public void deletetype(String tag)
     {
         SQLiteDatabase db=this.getWritableDatabase();
         String s ="DELETE FROM "+tblname+" WHERE tag='"+tag+"'";
         db.execSQL(s);
     }*/
    public Cursor selRecs() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select text from " + tblname, null);

    }

    public Cursor selRecs1() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select text from " + tblname + " WHERE status='Completed'", null);

    }

    public Cursor selRecs2() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select text from " + tblname + " WHERE status='pending'", null);

    }

    public void update(String dream) {
        SQLiteDatabase db = this.getWritableDatabase();


        String s = "UPDATE " + tblname + " SET status='Completed' WHERE " + col2 + " ='" + dream + "'";
        db.execSQL(s);
    }

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
