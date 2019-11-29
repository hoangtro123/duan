package anhnhph05834.hoànganh.com.ordering.manchinh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.dao.BanAnDAO;
import anhnhph05834.hoànganh.com.ordering.database.DBManager;


public class ThemBanAnActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtthemtenbanan;
    private Button btndongy;
    private BanAnDAO banAnDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ban_an);

        edtthemtenbanan =  findViewById(R.id.edtthemtenbanan);
        btndongy =  findViewById(R.id.btndongy);

        banAnDAO=new BanAnDAO(new DBManager(this));

        btndongy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndongy:
                String tenbanan=edtthemtenbanan.getText().toString().trim();

                if (!tenbanan.equals("")){
                    boolean kiemtra= banAnDAO.insertbanban(tenbanan);
                    Intent intent=new Intent();
                    intent.putExtra("ketquathem",kiemtra);
                    setResult(Activity.RESULT_OK,intent);
                    finish();

                }
                else {
                    Toast.makeText(ThemBanAnActivity.this,R.string.loinull,Toast.LENGTH_SHORT).show();
                }

            break;
        }
    }
}
