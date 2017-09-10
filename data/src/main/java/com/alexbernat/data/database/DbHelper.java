package com.alexbernat.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Александр on 06.09.2017.
 */
class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("DBHelper", "onCreate()");

        sqLiteDatabase.execSQL(
                "CREATE TABLE user " +
                        "('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "'name' TEXT, " +
                        "'age' INTEGER , " +
                        "'countryCode' TEXT)");

        sqLiteDatabase.execSQL(
                "CREATE TABLE country " +
                        "('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "'code' TEXT, " +
                        "'name' TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e("DBHelper", "onUpgrade()");

    }
}
