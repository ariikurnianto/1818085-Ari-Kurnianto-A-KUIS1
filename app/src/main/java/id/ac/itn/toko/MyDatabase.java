package id.ac.itn.toko;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_usaha";
    private static final String tb_toko = "tb_toko";
    private static final String tb_tk_id = "id";
    private static final String tb_tk_nama = "nama";
    private static final String tb_tk_buka = "buka";
    private static final String tb_tk_tutup = "tutup";
    private static final String CREATE_TABLE_TOKO = "CREATE TABLE " +
            tb_toko + "("
            + tb_tk_id + " INTEGER PRIMARY KEY ,"
            + tb_tk_nama + " TEXT,"
            + tb_tk_buka + " TEXT,"
            + tb_tk_tutup + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TOKO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateToko (Toko mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tk_id, mdNotif.get_id());
        values.put(tb_tk_nama, mdNotif.get_nama());
        values.put(tb_tk_buka, mdNotif.get_buka());
        values.put(tb_tk_tutup, mdNotif.get_tutup());
        db.insert(tb_toko, null, values);
        db.close();
    }

    public List<Toko> ReadToko() {
        List<Toko> judulModelList = new ArrayList<Toko>();
        String selectQuery = "SELECT * FROM " + tb_toko;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Toko mdKontak = new Toko();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_buka(cursor.getString(2));
                mdKontak.set_tutup(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateToko (Toko mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tk_nama, mdNotif.get_nama());
        values.put(tb_tk_buka, mdNotif.get_buka());
        values.put(tb_tk_tutup, mdNotif.get_tutup());
        return db.update(tb_toko, values, tb_tk_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteToko (Toko mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_toko, tb_tk_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

