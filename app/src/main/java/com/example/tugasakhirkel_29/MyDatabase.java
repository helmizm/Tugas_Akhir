package com.example.tugasakhirkel_29;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kue";
    private static final String tb_model_kue = "tb_model_kue";
    private static final String tb_jenis_id = "id";
    private static final String tb_jenis_nama = "nama";
    private static final String tb_jenis_jenis = "jenis";
    private static final String tb_jenis_warna = "warna";
    private static final String tb_jenis_harga = "harga";
    private static final String CREATE_TABLE_MODEL_KUE = "CREATE TABLE " +
            tb_model_kue + "("
            + tb_jenis_id + " INTEGER PRIMARY KEY ,"
            + tb_jenis_nama + " TEXT,"
            + tb_jenis_jenis + " TEXT,"
            + tb_jenis_warna + " TEXT, "
            + tb_jenis_harga + " TEXT " + " )";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MODEL_KUE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateJenisKue (JenisKue mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jenis_id, mdNotif.get_id());
        values.put(tb_jenis_nama, mdNotif.get_nama());
        values.put(tb_jenis_jenis, mdNotif.get_jenis());
        values.put(tb_jenis_warna, mdNotif.get_warna());
        values.put(tb_jenis_harga, mdNotif.get_harga());
        db.insert(tb_model_kue, null, values);
        db.close();
    }

    public List<JenisKue> ReadJenisKue() {
        List<JenisKue> judulModelList = new ArrayList<JenisKue>();
        String selectQuery = "SELECT * FROM " + tb_model_kue;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                JenisKue mdKontak = new JenisKue();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_jenis(cursor.getString(2));
                mdKontak.set_warna(cursor.getString(3));
                mdKontak.set_harga(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateJenisKue (JenisKue mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jenis_nama, mdNotif.get_nama());
        values.put(tb_jenis_jenis, mdNotif.get_jenis());
        values.put(tb_jenis_warna, mdNotif.get_warna());
        values.put(tb_jenis_harga, mdNotif.get_harga());
        return db.update(tb_model_kue, values, tb_jenis_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteJenisKue (JenisKue mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_model_kue, tb_jenis_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
