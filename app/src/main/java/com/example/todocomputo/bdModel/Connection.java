package com.example.todocomputo.bdModel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Connection extends SQLiteOpenHelper{

    String sql = "CREATE TABLE user(" +
                 "username VARCHAR(30)," +
                 "fullname VARCHAR(80)," +
                 "password VARCHAR(60)," +
                 "email VARCHAR(60))";
    public Connection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("DROP TABLE IF EXISTS user");
        onCreate(bd);
    }
}
