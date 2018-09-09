package com.pk.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pk.databasedemo.data_model.GenreInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TBL_GENRE = "tbl_Genre";

    private static final  String DB_NAME ="MovieDb";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TBL_GENRE);
        sqLiteDatabase.execSQL("CREATE TABLE tbl_Genre (g_id INTEGER PRIMARY KEY, g_name TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE tbl_Movie (m_id INTEGER PRIMARY KEY, g_id INTEGER, m_name TEXT, year, TEXT, income INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertGenre(String gName){

        SQLiteDatabase db = this.getWritableDatabase();

        //"INSERT INTO TABLE_NAME (COl1, COl2) VALUES (Val1, Val2)"
        ContentValues cv = new ContentValues();
        cv.put("Name", gName);

        try{
            //db.execSQL("INSERT INTO tbl_Genre VALUES('"+gName+"')");
            db.insert("tbl_Genre", null, cv);
            return  true;
        }
        catch (Exception e){

        }

        db.close();
        return false;
    }

    public List<GenreInfo> getAllGenre(){
        List<GenreInfo> infoList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Genre", null);

        if(cursor.moveToFirst()){
            do{
                GenreInfo info = new GenreInfo();
                info.setG_id(cursor.getInt(cursor.getColumnIndex("g_id")));
                info.setG_name(cursor.getString(cursor.getColumnIndex("g_name")));
                infoList.add(info);
            }while (cursor.moveToNext());
        }

        return getAllGenre();
    }
}
