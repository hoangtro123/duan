package anhnhph05834.hoànganh.com.ordering.manchinh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.adapter.LoaiMonAnAdapter;
import anhnhph05834.hoànganh.com.ordering.dao.LoaiMonAnDAO;
import anhnhph05834.hoànganh.com.ordering.dao.MonAnDAO;
import anhnhph05834.hoànganh.com.ordering.database.DBManager;
import anhnhph05834.hoànganh.com.ordering.model.LoaiMonAn;
import anhnhph05834.hoànganh.com.ordering.model.MonAn;



public class ThemThucDonActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imHinhThucDon;
    private EditText edThemTenMonAn;
    private EditText edThemGiaTien;
    private Spinner spinLoaiMonAn;
    private ImageButton imThemLoaiThucDon;
    private Button btnDongYThemMonAn;
    private Button btnThoatThemMonAn;

    private LoaiMonAnDAO loaiMonAnDAO;
    private LoaiMonAnAdapter anAdapter;
    private List<LoaiMonAn> loaiMonAnList;
    private String duonganhinh;
    private MonAnDAO monAnDAO;
    private List<MonAn> monAnList;

    public static int REQUEST_CODE_THEMLOAITHUCDON = 112;
    public static int REQUEST_CODE_HINHANH = 12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themmonan);

        monAnDAO=new MonAnDAO(new DBManager(this));
        anhxa();
        sukienclick();
        hienthispiner();

    }

    private void sukienclick() {
        imThemLoaiThucDon.setOnClickListener(this);
        imHinhThucDon.setOnClickListener(this);
        btnThoatThemMonAn.setOnClickListener(this);
        btnDongYThemMonAn.setOnClickListener(this);

    }

    private void hienthispiner() {

        loaiMonAnDAO = new LoaiMonAnDAO(new DBManager(this));
        loaiMonAnList = loaiMonAnDAO.dsloaimonan();
        anAdapter = new LoaiMonAnAdapter(this, R.layout.custum_layoutspiner_loaithucdon, loaiMonAnList);
        spinLoaiMonAn.setAdapter(anAdapter);
        anAdapter.notifyDataSetChanged();

    }

    private void anhxa() {
        imHinhThucDon = (ImageView) findViewById(R.id.imHinhThucDon);
        edThemTenMonAn = (EditText) findViewById(R.id.edThemTenMonAn);
        edThemGiaTien = (EditText) findViewById(R.id.edThemGiaTien);
        spinLoaiMonAn = (Spinner) findViewById(R.id.spinLoaiMonAn);
        imThemLoaiThucDon = (ImageButton) findViewById(R.id.imThemLoaiThucDon);
        btnDongYThemMonAn = (Button) findViewById(R.id.btnDongYThemMonAn);
        btnThoatThemMonAn = (Button) findViewById(R.id.btnThoatThemMonAn);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imThemLoaiThucDon:
                Intent intent = new Intent(ThemThucDonActivity.this, ThemLoaithucDonActivity.class);
                startActivityForResult(intent, REQUEST_CODE_THEMLOAITHUCDON);
                break;
            case R.id.btnDongYThemMonAn:

                int vitri=spinLoaiMonAn.getSelectedItemPosition();
                int maloai=loaiMonAnList.get(vitri).getMaLoai();
                String tenmonan=edThemTenMonAn.getText().toString().trim();
                String giatien=edThemGiaTien.getText().toString().trim();

                if (tenmonan!=null && giatien !=null && !tenmonan.equals("") && !giatien.equals("")){
                    MonAn monAn=new MonAn();
                    monAn.setTenMonAn(tenmonan);
                    monAn.setGiatien(giatien);
                    monAn.setMaLoai(maloai);
                    monAn.setHinhanh(duonganhinh);

                    boolean kiemtra=monAnDAO.themmonan(monAn);

                    if (kiemtra){
                        Toast.makeText(this, getResources().getString(R.string.themthanhcong), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, getResources().getString(R.string.themthatbai), Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this, getResources().getString(R.string.loinull), Toast.LENGTH_SHORT).show();
                }

                Log.d("vitri",vitri+"");

                break;

            case R.id.btnThoatThemMonAn:
                finish();
                break;

            case R.id.imHinhThucDon:
                Intent hinhchon = new Intent();
                hinhchon.setType("image/*");
                hinhchon.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(hinhchon, getString(R.string.mohinhanh)), REQUEST_CODE_HINHANH);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_THEMLOAITHUCDON) {
            if (resultCode == Activity.RESULT_OK) {
                Intent dulieutrave = data;
                boolean ketqua = dulieutrave.getBooleanExtra("kqtrave", false);

                if (ketqua) {
                    hienthispiner();
                    Toast.makeText(this, getResources().getString(R.string.themthanhcong), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, getResources().getString(R.string.themthatbai), Toast.LENGTH_SHORT).show();

                }
            }
        } else if (requestCode == REQUEST_CODE_HINHANH) {
            if (resultCode == Activity.RESULT_OK) {

                duonganhinh=data.getData().toString();
                imHinhThucDon.setImageURI(data.getData());
            }
        }
    }
}
