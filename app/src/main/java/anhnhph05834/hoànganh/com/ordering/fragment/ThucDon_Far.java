package anhnhph05834.hoànganh.com.ordering.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.manchinh.ManChinhActivity;
import anhnhph05834.hoànganh.com.ordering.manchinh.ThemThucDonActivity;


public class ThucDon_Far extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thucdon, container, false);
        setHasOptionsMenu(true);
        ((ManChinhActivity)getActivity()).getSupportActionBar().setTitle(R.string.thucdon);


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem themthucdon=menu.add(1,R.id.themthucdon,1,R.string.themmonan);
        themthucdon.setIcon(android.R.drawable.ic_input_add);
        themthucdon.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.themthucdon:
                Intent intent=new Intent(getActivity(), ThemThucDonActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
