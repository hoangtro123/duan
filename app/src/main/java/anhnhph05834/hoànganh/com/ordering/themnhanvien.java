package anhnhph05834.hoànganh.com.ordering;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import anhnhph05834.hoànganh.com.ordering.manchinh.ManChinhActivity;

public class themnhanvien extends Fragment {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_themnhanvien, container, false);
        setHasOptionsMenu(true);
        button = view.findViewById(R.id.btnThemNv);
        ((ManChinhActivity) getActivity()).getSupportActionBar().setTitle(R.string.thucdon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NhanVienAct.class));
            }
        });
        return view;
    }


}
