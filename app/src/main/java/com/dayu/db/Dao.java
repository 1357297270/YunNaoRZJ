package com.dayu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/10/10.
 */

public class Dao {
    private MyHelper helper;
    //类的构造方法
    public Dao(Context context) {
        helper = new MyHelper( context );

    }
    //添加的方法
    public void addData(String path,String json){
        SQLiteDatabase database = helper.getWritableDatabase();
//删除的方法
        database.delete( "goods","urlpath=?",new String[]{path});
        ContentValues contentValues = new ContentValues();
        contentValues.put( "urlpath",path );
        contentValues.put( "jsondata",json );
        long good = database.insert( "goods", null, contentValues );

    }
    //查询的方法
    public String select(String path){
        String data="";
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor query = db.query( "goods", null, "urlpath=?", new String[]{path}, null, null, null );
        while (query.moveToNext()){
            data=query.getString( query.getColumnIndex( "jsondata" ) );

        }
        return data;
    }
}
