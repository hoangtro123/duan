package anhnhph05834.hoànganh.com.ordering.account;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.dao.NhanVienDAO;
import anhnhph05834.hoànganh.com.ordering.database.DBManager;
import anhnhph05834.hoànganh.com.ordering.model.NhanVien;

public class DangKiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgback;
    private TextInputEditText tiedttendangnhap;
    private TextInputEditText tiedtmatkhau;
    private TextInputEditText tiedtsodienthoai;
    private RadioButton rdadmin;
    private RadioButton rdnhanvien;
    private Button btndangki;
    private TextView tvdangnhap;

    private NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        anhxa();

        nhanVienDAO = new NhanVienDAO(new DBManager(this));

        imgback.setOnClickListener(this);
        btndangki.setOnClickListener(this);
        tvdangnhap.setOnClickListener(this);

    }

    private void anhxa() {
        imgback = (ImageView) findViewById(R.id.imgback);
        tiedttendangnhap = (TextInputEditText) findViewById(R.id.tiedttendangnhap);
        tiedtmatkhau = (TextInputEditText) findViewById(R.id.tiedtmatkhau);
        tiedtsodienthoai = (TextInputEditText) findViewById(R.id.tiedtsodienthoai);
        rdadmin = (RadioButton) findViewById(R.id.rdadmin);
        rdnhanvien = (RadioButton) findViewById(R.id.rdnhanvien);
        btndangki = (Button) findViewById(R.id.btndangki);
        tvdangnhap = (TextView) findViewById(R.id.tvdangnhap);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgback:
                onBackPressed();
                break;

            case R.id.btndangki:
                xulydangki();
                break;

            case R.id.tvdangnhap:
                onBackPressed();
                break;

        }
    }

    public void xulydangki() {
        String tentaikhoan = tiedttendangnhap.getText().toString().trim();
        String matkhau = tiedtmatkhau.getText().toString().trim();
        String sdt = tiedtsodienthoai.getText().toString().trim();
        if (tentaikhoan.equals("") || matkhau.equals("") || sdt.equals("")) {
            Toast.makeText(DangKiActivity.this, "" + getString(R.string.loidangki), Toast.LENGTH_SHORT).show();
        } else {

            if (tentaikhoan.length()<6){
                tiedttendangnhap.setError(getString(R.string.loikitu));
            }
            else {
                int dienthoai = Integer.parseInt(sdt);
                NhanVien nhanVien = new NhanVien();
                nhanVien.setTENDN(tentaikhoan);
                nhanVien.setMATKHAU(matkhau);
                nhanVien.setSODT(dienthoai);
                nhanVienDAO.themnhanvien(nhanVien);
                Toast.makeText(DangKiActivity.this, "" + getString(R.string.themnhanvientanhcong), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
