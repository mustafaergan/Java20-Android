package com.mustafaergan.java20.kutuphane;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vektorel on 05.08.2017.
 */
public class MyDB extends SQLiteOpenHelper {

    static final String dbName = "KUTUPHANE";
    static  final int dbVersion = 3;

    String kitaplarTablosu = "CREATE TABLE KITAP(ID INTEGER PRIMARY KEY,NAME TEXT)";
    String getKitapSQL = "SELECT * FROM KITAP";



    public MyDB(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(kitaplarTablosu);
    }

    public List<Kitap> getKitapListesi(){
        List<Kitap> kitapList = new ArrayList<>();
        SQLiteDatabase db = super.getReadableDatabase();
        Cursor cursor = db.rawQuery(getKitapSQL,null);
        while (cursor.moveToNext()){
            Kitap kitap = new Kitap();
            kitap.setId(cursor.getInt(0));
            kitap.setName(cursor.getString(1));
            kitapList.add(kitap);
        }
        return kitapList;
    }

    public List<String> getKitapListesiString(){
        List<String> kitapList = new ArrayList<>();
        SQLiteDatabase db = super.getReadableDatabase();
        Cursor cursor = db.rawQuery(getKitapSQL,null);
        while (cursor.moveToNext()){
            kitapList.add(cursor.getString(1));
        }
        return kitapList;
    }


    public void insertKitap(Kitap kitap){
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID",kitap.getId());
        values.put("NAME",kitap.getName());
        db.insert("KITAP",null,values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
