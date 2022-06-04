package com.example.mobilecomputing

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class MyDatabase {
    object MyDBContract{
        object MyEntry : BaseColumns {
            const val TABLE_NAME = "myDBf"
            const val c1 = "name"
            const val c2 = "date"
            const val c3 = "loc"
            const val c4 = "who"
            const val c5 = "go"
        }
    }
    class MyDbHelper(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
        val SQL_CREATE_ENTRIES =
            "Create Table ${MyDBContract.MyEntry.TABLE_NAME} ("+
                    "${BaseColumns._ID} INTEGER PRIMARY KEY,"+
                    "${MyDBContract.MyEntry.c1} TEXT,"+
                    "${MyDBContract.MyEntry.c2} TEXT,"+
                    "${MyDBContract.MyEntry.c3} TEXT,"+
                    "${MyDBContract.MyEntry.c4} TEXT,"+
                    "${MyDBContract.MyEntry.c5} TEXT)"
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MyDBContract.MyEntry.TABLE_NAME}"
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(SQL_CREATE_ENTRIES)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        }

        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }
        companion object {
            // if you change the database schema, you must increase old version.
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "myDBf.db"
        }
    }
}