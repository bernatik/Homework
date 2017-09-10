package com.alexbernat.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alexbernat.data.dbentity.Country;
import com.alexbernat.data.dbentity.User;

import java.util.List;

/**
 * Created by Александр on 06.09.2017.
 */
public class DatabaseManager {

    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }

    public void open(boolean isWritable){
        if (isWritable)
            database = dbHelper.getWritableDatabase();
        else
            database = dbHelper.getReadableDatabase();
    }

    public void close(){
        if (database != null){
            database.close();
        }
    }

    public long insertUser(User user){
        Log.e("DatabaseManager", "insertUser() ");

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("age", user.getAge());
        values.put("countryCode", user.getCountry().getCode());

        return database.insert("user", null, values);

    }

    public void updateUser(User user){

    }

    public List<User> getUsers(){
        return null;
    }

    public User getUserById(int id){

//        Cursor cursor = database.rawQuery("SELECT * FROM user INNER JOIN country ON " +
//                "user.countryCode = country.code WHERE user.id = ?",
//                new String[]{String.valueOf(id)});
        Cursor cursor =
                database.rawQuery("SELECT * FROM user WHERE id = ?",
                        new String[]{String.valueOf(id)});

        if (cursor != null){
            Log.e("getUser()", "cursor not null");
            cursor.moveToFirst();

            User user = new User();
            Country country = new Country();

            int userId = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String countryCode = cursor.getString(3);
//            String countryName = cursor.getString(4);
            cursor.close();

            user.setId(userId);
            user.setName(name);
            user.setAge(age);

            country.setCode(countryCode);
//            country.setName(countryName);

            user.setCountry(country);

            return user;

        } else {
            Log.e("DatabaseManager" , "getUserById() cursor is null");
        }
        return null;
    }
}
