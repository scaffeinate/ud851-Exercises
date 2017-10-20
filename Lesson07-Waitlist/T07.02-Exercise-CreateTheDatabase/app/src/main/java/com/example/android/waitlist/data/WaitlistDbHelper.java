package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.waitlist.data.WaitlistContract.WaitlistEntry;

// COMPLETED (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // COMPLETED (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    public static final String DATABASE_NAME = "waitlist.db";

    // COMPLETED (3) Create a static final int called DATABASE_VERSION and set it to 1
    public static final int DATABASE_VERSION = 1;

    final String SQL_CREATE_WAITLIST_TABLE = " CREATE TABLE " + WaitlistEntry.TABLE_NAME + " (" +
            WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            WaitlistEntry.COLUMN_GUEST_NAME + " TEXT, " +
            WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER, " +
            WaitlistEntry.COLUMN_TIMESTAMP + " DATETIME " +
            "); ";


    // COMPLETED (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // COMPLETED (5) Override the onCreate method

    // COMPLETED (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table

    // COMPLETED (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // COMPLETED (8) Override the onUpgrade method

    // COMPLETED (9) Inside, execute a drop table query, and then call onCreate to re-create it
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WaitlistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}