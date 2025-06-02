package com.exemplo.sqlitegrud

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "PessoaDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Pessoa(id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT, idade INTEGER)")
    }