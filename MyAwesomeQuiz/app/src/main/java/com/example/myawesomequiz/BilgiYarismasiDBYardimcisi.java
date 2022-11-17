package com.example.myawesomequiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myawesomequiz.BilgiYarışmasıSözleşmesi.*;

import java.util.ArrayList;
import java.util.List;

public class BilgiYarismasiDBYardimcisi extends SQLiteOpenHelper {
    private static final String VERİTABANI_ADI = "BenimHarikaSınavım.db";
    private static final int VERİTABANI_SÜRÜMÜ = 1;

    private SQLiteDatabase vt;

    public BilgiYarismasiDBYardimcisi(Context context) {
        super(context, VERİTABANI_ADI, null, VERİTABANI_SÜRÜMÜ);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.vt = vt;

        final String SQL_SORU_TABLOSU_OLUŞTURMA = "CREATE TABLE " +
                SoruTablosu.TABLO_ADI + " ( " +
                SoruTablosu._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SoruTablosu.SÜTUN_SORUSU + " Metin, " +
                SoruTablosu.SÜTUN_SEÇENEĞİ1 + " Metin, " +
                SoruTablosu.SÜTUN_SEÇENEĞİ2 + " Metin, " +
                SoruTablosu.SÜTUN_SEÇENEĞİ3 + " Metin, " +
                SoruTablosu.SÜTUN_CEVAP_NR + " Tamsayı" +
                ")";

        vt.execSQL(SQL_SORU_TABLOSU_OLUŞTURMA);
        fillSorularTablosu();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        vt.execSQL("DROP TABLE IF EXISTS " + SoruTablosu.TABLO_ADI);
        onCreate(vt);
    }

    private void fillSorularTablosu() {
        Soru s1 = new Soru("A Doğrudur", "A", "B", "C", 1);
        addSoru(s1);
        Soru s2 = new Soru("B Doğrudur", "A", "B", "C", 2);
        addSoru(s2);
        Soru s3 = new Soru("C Doğrudur", "A", "B", "C", 3);
        addSoru(s3);
        Soru s4 = new Soru("A Yine Doğrudur", "A", "B", "C", 1);
        addSoru(s4);
        Soru s5 = new Soru("B Yine Doğrudur", "A", "B", "C", 2);
        addSoru(s5);
    }

    private void addSoru(Soru soru) {
        ContentValues cv = new ContentValues();
        cv.put(SoruTablosu.SÜTUN_SORUSU, soru.getSoru());
        cv.put(SoruTablosu.SÜTUN_SEÇENEĞİ1, soru.getSecenek1());
        cv.put(SoruTablosu.SÜTUN_SEÇENEĞİ2, soru.getSecenek2());
        cv.put(SoruTablosu.SÜTUN_SEÇENEĞİ3, soru.getSecenek3());
        cv.put(SoruTablosu.SÜTUN_CEVAP_NR, soru.getCevapNr());
        vt.insert(SoruTablosu.TABLO_ADI, null, cv);
    }

    @SuppressLint("Range")
    public List<Soru> getsAllSorular() {

        List<Soru> soruList = new ArrayList<>();

        vt = getReadableDatabase();
        Cursor c = vt.rawQuery("SELECT * FROM " + SoruTablosu.TABLO_ADI, null);

        if (c.moveToFirst()) {
            do {
                Soru soru = new Soru();
                soru.setSoru(c.getString(c.getColumnIndex(SoruTablosu.SÜTUN_SORUSU)));
                soru.setSecenek1(c.getString(c.getColumnIndex(SoruTablosu.SÜTUN_SEÇENEĞİ1)));
                soru.setSecenek2(c.getString(c.getColumnIndex(SoruTablosu.SÜTUN_SEÇENEĞİ2)));
                soru.setSecenek3(c.getString(c.getColumnIndex(SoruTablosu.SÜTUN_SEÇENEĞİ3)));
                soru.setCevapNr(c.getInt(c.getColumnIndex(SoruTablosu.SÜTUN_CEVAP_NR)));
                soruList.add(soru);
            } while (c.moveToNext());
        }


        c.close();


        return soruList;


    }
}
