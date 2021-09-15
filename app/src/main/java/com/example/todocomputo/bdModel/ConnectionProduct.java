package com.example.todocomputo.bdModel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ConnectionProduct extends SQLiteOpenHelper{
    String sql = "create table products" +
                    " (id INTEGER PRIMARY KEY," +
                    " product text," +
                    " price real," +
                    " quantity integer," +
                    " category VARCHAR(30)," +
                    " image blob)";
    public ConnectionProduct(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("DROP TABLE IF EXISTS products");
        onCreate(bd);
    }
}
