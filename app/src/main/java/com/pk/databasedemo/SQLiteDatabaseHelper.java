package com.pk.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pk.databasedemo.data_model.MovieInfo;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    private final String TABLE_NAME = "tbl_Student";
    public SQLiteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (id INTEGER PRIMARY KEY, name TEXT, age INTEGER, major TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertStudent(String name, int age, String major){
        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("INSERT INTO "+TABLE_NAME+ " (name, age, major) VALUES ('John', 18, 'Englis')");

        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);
        cv.put("major", major);

        db.insert("tbl_Student", null, cv);
    }

    public void insertMovie(MovieInfo info){
        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("INSERT INTO "+TABLE_NAME+ " (name, age, major) VALUES ('John', 18, 'Englis')");

        ContentValues cv = new ContentValues();
        cv.put("mName", info.getmNmae());
        cv.put("year", info.getYear());
        cv.put("income", info.getIncome());

        db.insert("tbl_Movie", null, cv);
    }

    public boolean insertMovie(String mName, int year, double income){

        boolean result = false;

        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("INSERT INTO "+TABLE_NAME+ " (name, age, major) VALUES ('John', 18, 'Englis')");

        ContentValues cv = new ContentValues();
        cv.put("mName", mName);
        cv.put("year", year);
        cv.put("income", income);

        try {
            db.insert("tbl_Movie", null, cv);
            result = true;
        }

        catch (Exception ex){

        }
        return  result;
    }
}
