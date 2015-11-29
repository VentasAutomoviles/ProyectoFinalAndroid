package com.example.christopher.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Christopher on 27/11/2015.
 */
public class DatabaseManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "carroDB.db";
    private static final String TABLE_CARROS = "carros";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_DNI = "dni";
    public static final String COLUMN_MARCA = "marca";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CARRO_TABLE = "CREATE TABLE " +
                TABLE_CARROS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NOMBRE + " TEXT,"
                + COLUMN_APELLIDO + " TEXT,"
                + COLUMN_DNI + " INTEGER,"
                + COLUMN_MARCA + " TEXT"
                + ")";
        db.execSQL(CREATE_CARRO_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARROS);
        onCreate(db);
    }

    public Carro comprar1(Carro carro) {
        Log.d("db", "addContact");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, carro.get_nombre());
        values.put(COLUMN_APELLIDO, carro.get_apellido());
        values.put(COLUMN_DNI, carro.get_dni());
        values.put(COLUMN_MARCA, carro.get_marca());
        long id = db.insert(TABLE_CARROS, null, values);
        carro.set_id(id);
        db.close();
        return carro;
    }

    public Cursor mostrarVentas() {
        String selectQuery = "SELECT  * FROM " + TABLE_CARROS;
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(selectQuery, null);
    }

    Carro mostrarVenta(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_CARROS, new String[]{COLUMN_ID, COLUMN_NOMBRE, COLUMN_APELLIDO, COLUMN_DNI, COLUMN_MARCA}, COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Carro carro = new Carro(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4));
            carro.set_id(cursor.getLong(0));
            return carro;
        }
        return null;
    }

    public void eliminarVenta(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CARROS, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        db.close();
    }
}
