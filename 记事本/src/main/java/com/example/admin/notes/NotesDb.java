package com.example.admin.notes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2015-07-01.
 */
public class NotesDb extends SQLiteOpenHelper {
    public static final String DB_NAME = "notes";
    public static final String TABLE_NAME = "notes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_VIDEO = "video";
    public static final String COLUMN_DATE = "date";

    public NotesDb(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" +
                COLUMN_ID + " integer not null primary key autoincrement," +
                COLUMN_CONTENT + " text," +
                COLUMN_IMAGE + " text," +
                COLUMN_VIDEO + " text," +
                COLUMN_DATE + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
