package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Iva on 20.12.2016..
 */

public final class HabitContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private HabitContract() {}{
}
/* Inner class that defines the table contents */
public static class HabitEntry implements BaseColumns {
    public static final String TABLE_NAME = "habits";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_HABIT_NAME = "name";
    public static final String COLUMN_HABIT_DURATION = "duration";
}
}
