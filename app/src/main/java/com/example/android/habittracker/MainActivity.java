package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.habittracker.data.HabitContract;
import com.example.android.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HabitDbHelper mDbHelper = new HabitDbHelper(this);
    }

    /**
     * Method to insert new habits into database
     */
    private void insertHabit() {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Learning Java");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DURATION, 3600);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    /**
     * Query database for selected columns
     *
     * @return Cursor object
     */
    private Cursor readDatabase() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = null;
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_DURATION,
        };

        // Perform a query on the habits table

        try {
            // Search Db and acquire Cursor object
            cursor = db.query(
                    HabitContract.HabitEntry.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null);
            cursor.moveToFirst();
            // Return Cursor object
            return cursor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //Close cursor and database
            cursor.close();
            db.close();
        }
    }
}
