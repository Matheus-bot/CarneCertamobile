package com.example.carnecertamobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "carnecerta.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabela = "CREATE TABLE carnes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT)";

        db.execSQL(tabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS carnes");

        onCreate(db);

    }

    public void inserirCarne(String nome) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nome", nome);

        db.insert("carnes", null, values);

    }

    public String listarCarnes() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM carnes",
                null
        );

        StringBuilder lista = new StringBuilder();

        while(cursor.moveToNext()) {

            lista.append(
                    cursor.getString(1)
            ).append("\n");

        }

        return lista.toString();

    }
}