package anhnhph05834.hoànganh.com.ordering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import anhnhph05834.hoànganh.com.ordering.account.DangNhapActivity;



public class ManChaoActivity extends AppCompatActivity {

    private ImageView imgchao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chao);

        imgchao = (ImageView) findViewById(R.id.imgchao);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(ManChaoActivity.this, DangNhapActivity.class));
                finish();
            }
        },1000);


    }
}
