package anhnhph05834.hoànganh.com.ordering;

import android.view.View;

public interface goiham {

    String TB_NHANVIEN = "nhanvien";

    String NHANVIEN_MANV = "manv";
    String NHANVIEN_TENDANGNHAP = "tendangnhap";
    String NHANVIEN_MATKHAU = "matkhau";
    String NHANVIEN_SDT = "sodienthoai";

    String tbNhanVIEN = "CREATE TABLE " + TB_NHANVIEN + " ( " +
            NHANVIEN_MANV + " INTEGER primary key autoincrement, " +
            NHANVIEN_TENDANGNHAP + " TEXT, " +
            NHANVIEN_MATKHAU + " TEXT, " +
            NHANVIEN_SDT + " INTEGER )";


    String TB_MONAN = "monan";

    String MONAN_MAMONAN = "mamonan";
    String MONAN_TENMONAN = "tenmonan";
    String MONAN_GIATIEN = "giatien";
    String MONAN_MALOAI = "maloai";
    String MONAN_HINHANH="hinhanh";

    String tbMONAN = " CREATE TABLE " + TB_MONAN + " ( " +
            MONAN_MAMONAN + " INTEGER primary key autoincrement, " +
            MONAN_TENMONAN + " TEXT, " +
            MONAN_MALOAI + " INTEGER, " +
            MONAN_GIATIEN + " TEXT " +
            MONAN_HINHANH+ " TEXT ) ";


    String TB_LOAIMONAN = "loaimonan";
    String LOAIMONAN_MALOAI = "maloai";
    String LOAIMONAN_TENLOAI = "tenloai";

    String tbLOAIMONAn = " CREATE TABLE " + TB_LOAIMONAN + " ( " +
            LOAIMONAN_MALOAI + " INTEGER primary key autoincrement, " +
            LOAIMONAN_TENLOAI + " TEXT )";


    String TB_BANAN = "banan";
    String BANAN_MABAN = "maban";
    String BANAN_TENBAN = "tenban";
    String BANAN_TINHTRANG = "tinhtrang";

    String tbBANAN = " CREATE TABLE " + TB_BANAN + " ( " +
            BANAN_MABAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BANAN_TENBAN + " TEXT, " +
            BANAN_TINHTRANG + " TEXT ) ";


    String TB_GOIMON = "goimon";

    String GOIMON_MAGoIMON = "magoimon";
    String GOIMON_MANV = "manv";
    String GOIMON_NgAYGOI = "ngygoi";
    String GOIMON_TINHTRANG = "tinhtrang";
    String GOIMON_MABAN = "maban";

    String tbgoimon = " CREATE TABLE " + TB_GOIMON + " ( " +
            GOIMON_MAGoIMON + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GOIMON_MANV + " INTEGER, " +
            GOIMON_NgAYGOI + " TEXT, " +
            GOIMON_TINHTRANG + " text, " +
            GOIMON_MABAN + " INTEGER )";


    String TB_CHITIETGOIMON = "chitietgoimon";

    String CHITIETGOIMON_MAGOIMON = "magoimon";
    String CHITIETGOIMON_MAMONAN = "mamonan";
    String CHITIETGOIMON_SOLUONG = "soluong";

    String tbchitietgoimon = " CREATE TABLE " + TB_CHITIETGOIMON + " ( " +

            CHITIETGOIMON_MAGOIMON + " INTEGER, " +
            CHITIETGOIMON_MAMONAN + " INTEGER, " +
            CHITIETGOIMON_SOLUONG + " INTEGER, " +
            " Primary key ( " + CHITIETGOIMON_MAGOIMON + "," + CHITIETGOIMON_MAMONAN + " )) ";


}
