package anhnhph05834.hoànganh.com.ordering.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import anhnhph05834.hoànganh.com.ordering.R;


public class NgonNguActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgback;
    private TextView tvtienganh;
    private TextView tvtiengviet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngon_ngu);
        anhxa();

        tvtienganh.setOnClickListener(NgonNguActivity.this);
        tvtiengviet.setOnClickListener(this);
        imgback.setOnClickListener(this);

    }

    private void anhxa() {
        imgback = (ImageView) findViewById(R.id.imgback);
        tvtienganh = (TextView) findViewById(R.id.tvtienganh);
        tvtiengviet = (TextView) findViewById(R.id.tvtiengviet);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgback:
                onBackPressed();
                break;
            case R.id.tvtienganh:
                xulytienganha();
                break;

            case R.id.tvtiengviet:
                xulytienganha();
                break;
        }
    }

    public void xulytienganha(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(NgonNguActivity.this);
        dialog.setTitle("Bạn có muốn thay đổi ngôn ngữ");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // sử lý sau
                Toast.makeText(NgonNguActivity.this,"đợi em xíu nha a giai!!!",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
