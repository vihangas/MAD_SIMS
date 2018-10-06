package com.example.deshan.mad_sims.Marks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABSE_NAME = "Marks.db";
    public static final String TABLE_NAME = "marks";

    public DBHelper(Context context){
        super(context,DATABSE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(id integer primary key AUTOINCREMENT, semesterID text, examID text, subjectID text, attendance text, marks integer)");
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists " +TABLE_NAME);
    }

    public boolean insertData(String semesterID, String examID, String subjectID, String attendance, int marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("semesterID", semesterID);
        values.put("examID", examID);
        values.put("subjectID", subjectID);
        values.put("attendance", attendance);
        values.put("marks", marks);
        long result = db.insert(TABLE_NAME,null,values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String semesterID, String examID, String subjectID, String attendance, int marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("semesterID", semesterID);
        values.put("examID", examID);
        values.put("subjectID", subjectID);
        values.put("attendance", attendance);
        values.put("marks", marks);

        long result = db.update(TABLE_NAME,values,"semesterID=? AND examID=? AND subjectID=?",new String[]{semesterID,examID,subjectID});
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME, null);
        return  res;
    }

    public boolean deleteData(String semestrID, String examID, String subjectID){
        SQLiteDatabase db = this.getWritableDatabase();
        long resu = db.delete(TABLE_NAME,"semesterID = ? AND examID = ? AND subjectID = ?",new String[]{semestrID,examID,subjectID});
        if(resu == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(String semesterID, String examID, String subjectID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resu = db.rawQuery("SELECT * FROM " +TABLE_NAME+ " WHERE semesterID = ? AND examID = ? AND subjectID = ?",new String[]{semesterID,examID,subjectID});
        return resu;
    }
}
