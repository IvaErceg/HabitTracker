package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HabitsTracker.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = "INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" +
                    HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY," +
                    HabitContract.HabitEntry.COLUMN_HABIT_NAME + TEXT_TYPE + " NOT NULL" + COMMA_SEP +
                    HabitContract.HabitEntry.COLUMN_HABIT_DURATION + INT_TYPE  + " NOT NULL)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //simply discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

