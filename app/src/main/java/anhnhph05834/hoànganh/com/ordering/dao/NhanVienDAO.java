package anhnhph05834.hoànganh.com.ordering.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import anhnhph05834.hoànganh.com.ordering.database.DBManager;
import anhnhph05834.hoànganh.com.ordering.goiham;
import anhnhph05834.hoànganh.com.ordering.model.NhanVien;


public class NhanVienDAO implements goiham {

    private DBManager dbManager;

    public NhanVienDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public long themnhanvien(NhanVien nhanVien) {

        SQLiteDatabase db = dbManager.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NHANVIEN_TENDANGNHAP, nhanVien.getTENDN());
        contentValues.put(NHANVIEN_MATKHAU, nhanVien.getMATKHAU());
        contentValues.put(NHANVIEN_SDT, nhanVien.getSODT());

        return db.insert(TB_NHANVIEN, null, contentValues);

    }

    public int KiemTraDangNhap(String tendangnhap, String matkhau){

        SQLiteDatabase db=dbManager.getWritableDatabase();
        String truyvan = "SELECT * FROM " + TB_NHANVIEN + " WHERE " + NHANVIEN_TENDANGNHAP + " = '" + tendangnhap
                + "' AND " + NHANVIEN_MATKHAU + " = '" + matkhau + "'";

        int manhanvien = 0;
        Cursor cursor = db.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            manhanvien = cursor.getInt(cursor.getColumnIndex(NHANVIEN_MANV));
            cursor.moveToNext();
        }

        return manhanvien;


    }

}
