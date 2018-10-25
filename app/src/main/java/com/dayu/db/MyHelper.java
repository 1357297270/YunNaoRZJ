package com.dayu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/10/10.
 */

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context) {
        super( context, "mydb", null, 1 );
    }
    //创建数据库表的方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table goods(id integer primary key autoincrement,urlpath text,jsondata text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
