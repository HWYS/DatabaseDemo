package com.pk.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pk.databasedemo.data_model.CommentInfo;
import com.pk.databasedemo.data_model.GenreInfo;
import com.pk.databasedemo.data_model.StatusInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTest extends SQLiteOpenHelper {
    public DatabaseTest(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tbl_Status(id INTEGER PRIMARY KEY," +
                "status TEXT, name TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE tbl_Comment(c_id INTEGER PRIMARY KEY," +
                "id INTEGER, name TEXT, comment TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertGenre(String name, int age, String address, Double salary){

        SQLiteDatabase db = this.getWritableDatabase();

        //"INSERT INTO TABLE_NAME (COl1, COl2) VALUES (Val1, Val2)"
        ContentValues cv = new ContentValues();
        cv.put("Name", name);
        cv.put("age", age);
        cv.put("address", address);
        cv.put("salary", salary);

        try{
            db.execSQL("INSERT INTO tbl_Genre (Name, age, address, salary" +
                    ") VALUES('"+name+"')");

            db.insert("tbl_Genre", null, cv);
            return  true;
        }
        catch (Exception e){

        }

        db.close();
        return false;
    }

    public boolean insertPost(String status, String name){

        SQLiteDatabase db = this.getWritableDatabase();

        //"INSERT INTO TABLE_NAME (COl1, COl2) VALUES (Val1, Val2)"
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("status", status);

        try{
            /*db.execSQL("INSERT INTO tbl_Genre (Name, age, address, salary" +
                    ") VALUES('"+name+"')");*/

            db.insert("tbl_Status", null, cv);
            return  true;
        }
        catch (Exception e){

        }

        db.close();
        return false;
    }

    public boolean insertComment(CommentInfo info){

        SQLiteDatabase db = this.getWritableDatabase();

        //"INSERT INTO TABLE_NAME (COl1, COl2) VALUES (Val1, Val2)"
        ContentValues cv = new ContentValues();
        cv.put("id", info.getId());
        cv.put("name", info.getName());
        cv.put("comment", info.getComment());

        try{
            /*db.execSQL("INSERT INTO tbl_Genre (Name, age, address, salary" +
                    ") VALUES('"+name+"')");*/

            db.insert("tbl_Comment", null, cv);
            return  true;
        }
        catch (Exception e){

        }

        db.close();
        return false;
    }

    public List<StatusInfo> getAllStatus(){
        List<StatusInfo> infoList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Status", null);

        if(cursor.moveToFirst()){
            do{
                infoList.add(new StatusInfo(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("status"))));
            }while (cursor.moveToNext());
        }

        return infoList;
    }

    public List<CommentInfo> getAllCommentById(int status_id){
        List<CommentInfo> infoList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Comment WHERE id="+status_id, null);

        if(cursor.moveToFirst()){
            do{
                infoList.add(new CommentInfo(cursor.getInt(cursor.getColumnIndex("c_id")),
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("comment"))));
            }while (cursor.moveToNext());
        }

        return infoList;
    }
}
