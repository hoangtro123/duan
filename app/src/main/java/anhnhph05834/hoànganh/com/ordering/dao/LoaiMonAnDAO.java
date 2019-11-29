package anhnhph05834.hoànganh.com.ordering.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import anhnhph05834.hoànganh.com.ordering.database.DBManager;
import anhnhph05834.hoànganh.com.ordering.goiham;
import anhnhph05834.hoànganh.com.ordering.model.LoaiMonAn;

public class LoaiMonAnDAO implements goiham {
    private DBManager dbManager;

    public LoaiMonAnDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public boolean themloaimonan(String tenloai){
        SQLiteDatabase db=dbManager.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(LOAIMONAN_TENLOAI,tenloai);
        long kiemtra=db.insert(TB_LOAIMONAN,null,contentValues);
        if (kiemtra!=0){
            return true;
        }
        else {
            return false;
        }

    }
    public List<anhnhph05834.hoànganh.com.ordering.model.LoaiMonAn> dsloaimonan(){
        SQLiteDatabase db=dbManager.getWritableDatabase();
        List<LoaiMonAn> loaiMonAnList=new ArrayList<>();

        String truvan="SELECT * FROM " + TB_LOAIMONAN;
        Cursor cursor=db.rawQuery(truvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiMonAn loaiMonAn=new LoaiMonAn();
            loaiMonAn.setMaLoai(cursor.getInt(cursor.getColumnIndex(LOAIMONAN_MALOAI)));
            loaiMonAn.setTenloai(cursor.getString(cursor.getColumnIndex(LOAIMONAN_TENLOAI)));

            loaiMonAnList.add(loaiMonAn);
            cursor.moveToNext();
        }

        return loaiMonAnList;

    }
}
