package anhnhph05834.hoànganh.com.ordering.manchinh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.dao.LoaiMonAnDAO;
import anhnhph05834.hoànganh.com.ordering.database.DBManager;


public class ThemLoaithucDonActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edThemLoaiThucDon;
    private Button btnDongYThemLoaiThucDon;
    private LoaiMonAnDAO loaiMonAnDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_loaithuc_don);
        edThemLoaiThucDon = (EditText) findViewById(R.id.edThemLoaiThucDon);
        btnDongYThemLoaiThucDon = (Button) findViewById(R.id.btnDongYThemLoaiThucDon);

        loaiMonAnDAO=new LoaiMonAnDAO(new DBManager(this));
            btnDongYThemLoaiThucDon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String loaithucdon=edThemLoaiThucDon.getText().toString().trim();
        if (loaithucdon!=null||!loaithucdon.equals("")){
            boolean kiemtra=loaiMonAnDAO.themloaimonan(loaithucdon);
            Intent intent =new Intent();
            intent.putExtra("kqtrave",kiemtra);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
        else {
            Toast.makeText(ThemLoaithucDonActivity.this,R.string.loinull,Toast.LENGTH_SHORT).show();
        }

    }
}
