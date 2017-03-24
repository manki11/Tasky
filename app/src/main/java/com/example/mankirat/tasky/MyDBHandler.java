package com.example.mankirat.tasky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Mankirat on 18-02-2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="tasks.db";

    public static final String TABLE_TASKS ="tasks";
    private static final String COLUMN_ID ="_id";
    private static final String COLUMN_DATE ="date";
    private static final String COLUMN_TIME ="time";
    private static final String COLUMN_LOCATION ="location";
    private static final String COLUMN_TITLE ="title";
    private static final String COLUMN_CATEGORY ="category";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ TABLE_TASKS + "( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_CATEGORY + " TEXT); ";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP_TABLE_IF_EXISTS "+ TABLE_TASKS);
        onCreate(db);
    }

    public void addTask(Whattodo whattodo){
        Log.e("database handler:","database add from position" );
        ContentValues values=new ContentValues();
        values.put(COLUMN_DATE,whattodo.getDate());
        values.put(COLUMN_TIME,whattodo.getTime());
        values.put(COLUMN_LOCATION,whattodo.getLocation());
        values.put(COLUMN_TITLE,whattodo.getTitle());
        values.put(COLUMN_CATEGORY,whattodo.getCategory());

        SQLiteDatabase db= getWritableDatabase();

        db.insert(TABLE_TASKS,null,values);
//        db.close();
    }

    public void deleteTask(int id){
        SQLiteDatabase db= getWritableDatabase();
        Log.e("database handler:","database delete from position" + id);
        db.execSQL("DELETE FROM " + TABLE_TASKS +" WHERE " + COLUMN_ID + " = " + id + ";");


    }

    public ArrayList<Whattodo> retrieveList(){
        ArrayList<Whattodo> List=new ArrayList<>();

        SQLiteDatabase db= getReadableDatabase();
//        String query="SELECT * FROM "+ TABLE_TASKS +" WHERE 1";
        Cursor c=db.query(TABLE_TASKS,null,null,null,null,null,null);
//        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while(c.moveToNext()){
            Whattodo whattodo=new Whattodo();
            if(c.getString(c.getColumnIndex(COLUMN_DATE))!=null){
                whattodo.setDate(c.getString(c.getColumnIndex(COLUMN_DATE)));
                Log.e("database","date");
            }

            if(c.getString(c.getColumnIndex(COLUMN_TIME))!=null){
                whattodo.setTime(c.getString(c.getColumnIndex(COLUMN_TIME)));
                Log.e("database","time");
            }

            if(c.getString(c.getColumnIndex(COLUMN_LOCATION))!=null){
                whattodo.setLocation(c.getString(c.getColumnIndex(COLUMN_LOCATION)));
                Log.e("database","location");
            }

            if(c.getString(c.getColumnIndex(COLUMN_TITLE))!=null){
                whattodo.setTitle(c.getString(c.getColumnIndex(COLUMN_TITLE)));
                Log.e("database","title");
            }

            if(c.getString(c.getColumnIndex(COLUMN_CATEGORY))!=null){
                whattodo.setCategory(c.getString(c.getColumnIndex(COLUMN_CATEGORY)));
                Log.e("database","category");
            }


            List.add(whattodo);

        }


//        db.close();
        return List;
    }
}
