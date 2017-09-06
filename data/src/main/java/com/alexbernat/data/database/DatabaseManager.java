package com.alexbernat.data.database;

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

    public void insertUser(User user){
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO user ('name', 'age', 'countryId') ");
        sql.append("VALUES (");
        sql.append("'");
        sql.append(user.getName());
        sql.append("', ");
        sql.append(user.getAge());
        sql.append(", ");
        sql.append("");
        sql.append(user.getCountry().getId());
        sql.append(")");

        database.execSQL(sql.toString());

        Log.e("DatabaseManager", "insertUser() SQL request: " + sql.toString());
    }

    public void updateUser(User user){

    }

    public List<User> getUsers(){
        return null;
    }

    public User getUserById(int id){

        Cursor cursor = database.rawQuery("SELECT * FROM user INNER JOIN country ON " +
                "user.countryId = country.id WHERE id = ?",
                new String[]{String.valueOf(id)});

        if (cursor != null){
            User user = new User();
            Country country = new Country();

            cursor.moveToFirst();
            int userId = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            int countryId = cursor.getInt(3);
            String countryName = cursor.getString(4);
            cursor.close();

            user.setId(userId);
            user.setName(name);
            user.setAge(age);

            country.setId(countryId);
            country.setName(countryName);

            user.setCountry(country);

            return user;

        } else {
            Log.e("DatabaseManager" , "getUserById() cursor is null");
        }
        return null;
    }
}
