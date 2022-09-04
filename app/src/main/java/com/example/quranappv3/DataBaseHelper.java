package com.example.quranappv3;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHELPER";
    public static final String DBNAME = "Quran.db";
    public static final int DBVERSION = 1;
    public static final String TABLE_ITEM = "tsurah";
    SQLiteDatabase mDB;
    public DataBaseHelper(Context context) {
        super(context,DBNAME,null,DBVERSION);
        if (!ifDBExists(context)) {
            if (!copyDBFromAssets(context)) {
                throw new RuntimeException("Failed to Copy Database From Assets Folder");
            }
        }
        mDB = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Do NOTHING in here as the database has been copied from the assets
        // if it did not already exist
        Log.d(TAG, "METHOD onCreate called");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"METHOD onUpgrade called");
    }
    private boolean copyDBFromAssets(Context context) {
        Log.d("CPYDBINFO","Starting attemtpt to cop database from the assets file.");
        String DBPATH = context.getDatabasePath(DBNAME).getPath();
        InputStream
                is;
        OutputStream
                os;
        int buffer_size = 8192;
        int length = buffer_size;
        long bytes_read = 0;
        long bytes_written = 0;
        byte[] buffer = new byte[length];

        try {

            is = context.getAssets().open(DBNAME);
        } catch (IOException e) {
            Log.e("CPYDB FAIL - NO ASSET","Failed to open the Asset file " + DBNAME);
            e.printStackTrace();
            return false;
        }

        try {
            os = new FileOutputStream(DBPATH);
        } catch (IOException e) {
            Log.e("CPYDB FAIL - OPENDB","Failed to open the Database File at " + DBPATH);
            e.printStackTrace();
            return false;
        }
        Log.d("CPYDBINFO","Initiating copy from asset file" + DBNAME + " to " + DBPATH);
        while (length >= buffer_size) {
            try {
                length = is.read(buffer,0,buffer_size);
            } catch (IOException e) {
                Log.e("CPYDB FAIL - RD ASSET",
                        "Failed while reading in data from the Asset. " +
                                String.valueOf(bytes_read) +
                                " bytes read successfully."
                );
                e.printStackTrace();
                return false;
            }
            bytes_read = bytes_read + length;
            try {
                os.write(buffer,0,buffer_size);
            } catch (IOException e) {
                Log.e("CPYDB FAIL - WR ASSET","failed while writing Database File " +
                        DBPATH +
                        ". " +
                        String.valueOf(bytes_written) +
                        " bytes written successfully.");
                e.printStackTrace();
                return false;

            }
            bytes_written = bytes_written + length;
        }
        Log.d("CPYDBINFO",
                "Read " + String.valueOf(bytes_read) + " bytes. " +
                        "Wrote " + String.valueOf(bytes_written) + " bytes."
        );
        try {
            os.flush();
            is.close();
            os.close();
        } catch (IOException e ) {
            Log.e("CPYDB FAIL - FINALISING","Failed Finalising Database Copy. " +
                    String.valueOf(bytes_read) +
                    " bytes read." +
                    String.valueOf(bytes_written) +
                    " bytes written."
            );
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private boolean ifDBExists(Context context) {
        String dbparent = context.getDatabasePath(DBNAME).getParent();
        File f = context.getDatabasePath(DBNAME);
        if (!f.exists()) {
            Log.d("NODB MKDIRS","Database file not found, making directories."); //<<<< remove before the App goes live.
            File d = new File(dbparent);
            d.mkdirs();
            //return false;
        }
        return f.exists();
    }
    public ArrayList<Surah> getSurahs()
    {
        SQLiteDatabase sqdb = this.getReadableDatabase();
        ArrayList<Surah> surahs = new ArrayList<>();
        Cursor c = sqdb.rawQuery("select * from tsurah",null);
        if (c.moveToFirst()) {
            do {
                String id = Integer.toString(c.getInt(0));
                surahs.add(new Surah(id,c.getString(1),c.getString(2),c.getString(3),
                        c.getString(4)));
            } while (c.moveToNext());
        }
        c.close();
        return surahs;
    }

    public ArrayList<Ayat> getAyat()
    {
        SQLiteDatabase sqdb = this.getReadableDatabase();
        ArrayList<Ayat> ayat = new ArrayList<>();
        Cursor c = sqdb.rawQuery("select * from tayah",null);
        if (c.moveToFirst()) {
            do {
                String ayatId = Integer.toString(c.getInt(0));
                String surahId = Integer.toString(c.getInt(1));
                String ayatNo = Integer.toString(c.getInt(2));
                String rakuId = Integer.toString(c.getInt(8));
                String prakuId = Integer.toString(c.getInt(9));
                String paraId = Integer.toString(c.getInt(10));

                ayat.add(new Ayat(ayatId,surahId,ayatNo,c.getString(3),c.getString(4),
                        c.getString(5),
                        c.getString(6),c.getString(7),rakuId,prakuId,paraId));
            } while (c.moveToNext());
        }
        c.close();
        return ayat;
    }


}