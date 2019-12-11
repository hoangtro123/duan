package anhnhph05834.hoànganh.com.ordering.manchinh;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.zip.Inflater;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.fragment.ThucDon_Far;
import anhnhph05834.hoànganh.com.ordering.fragment.TrangChu_Far;
import anhnhph05834.hoànganh.com.ordering.themnhanvien;
import anhnhph05834.hoànganh.com.ordering.themthongke;


public class ManChinhActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tvnhanvien;
        NavigationView navigationView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chinh);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view=navigationView.getHeaderView(0);
        tvnhanvien=view.findViewById(R.id.tvtendangnhap);

        Intent intent=getIntent();
        String ten=intent.getStringExtra("tendn");
        tvnhanvien.setText(ten);
        Log.d("dulieu",ten);

        getSupportFragmentManager().beginTransaction().replace(R.id.con,new TrangChu_Far()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.man_chinh, menu);
//        return true;
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_trangchu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.con,new TrangChu_Far()).commit();
        } else if (id == R.id.nav_thucdon) {
            getSupportFragmentManager().beginTransaction().replace(R.id.con,new ThucDon_Far()).commit();

        } else if (id == R.id.nav_nhanvien) {
            getSupportFragmentManager().beginTransaction().replace(R.id.con,new themnhanvien()).commit();


        } else if (id == R.id.nav_thongke) {
            getSupportFragmentManager().beginTransaction().replace(R.id.con,new themthongke()).commit();

        } else if (id == R.id.nav_dangxuat) {
            super.onBackPressed();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}