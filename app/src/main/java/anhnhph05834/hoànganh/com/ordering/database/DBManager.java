package anhnhph05834.hoànganh.com.ordering.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import anhnhph05834.hoànganh.com.ordering.goiham;

import static anhnhph05834.hoànganh.com.ordering.goiham.tbBANAN;
import static anhnhph05834.hoànganh.com.ordering.goiham.tbLOAIMONAn;
import static anhnhph05834.hoànganh.com.ordering.goiham.tbMONAN;
import static anhnhph05834.hoànganh.com.ordering.goiham.tbNhanVIEN;
import static anhnhph05834.hoànganh.com.ordering.goiham.tbchitietgoimon;
import static anhnhph05834.hoànganh.com.ordering.goiham.tbgoimon;

public class DBManager extends SQLiteOpenHelper implements goiham {

    public DBManager( Context context) {
        super(context,"quanlynhahang", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbNhanVIEN);
        db.execSQL(tbMONAN);
        db.execSQL(tbLOAIMONAn);
        db.execSQL(tbBANAN);
        db.execSQL(tbgoimon);
        db.execSQL(tbchitietgoimon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
