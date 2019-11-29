package anhnhph05834.hoànganh.com.ordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.model.BanAn;


public class BanAnAdapter extends BaseAdapter  implements View.OnClickListener {
    private Context context;
    private int layout;
    private List<BanAn> banAnList;
    private ViewHolder viewHolder;

    public BanAnAdapter(Context context, int layout, List<BanAn> banAnList) {
        this.context = context;
        this.layout = layout;
        this.banAnList = banAnList;
    }

    @Override
    public int getCount() {
        return banAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return banAnList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return banAnList.get(position).getMabanan();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.custum_banan, parent, false);

            viewHolder.txtTenBanAn = (TextView) convertView.findViewById(R.id.txtTenBanAn);
            viewHolder.imBanAn = (ImageView) convertView.findViewById(R.id.imBanAn);
            viewHolder.imGoiMon = (ImageView) convertView.findViewById(R.id.imGoiMon);
            viewHolder.imThanhToan = (ImageView) convertView.findViewById(R.id.imThanhToan);
            viewHolder.imAnButton = (ImageView) convertView.findViewById(R.id.imAnButton);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BanAn banAn = banAnList.get(position);
        viewHolder.txtTenBanAn.setText(banAn.getTenbanan());

        //khi dc tao thi luu vitri
        viewHolder.imBanAn.setTag(position);
        if (banAnList.get(position).isChonvitri()){
            duocchon();
        }
        else {
            khongchon();
        }

        viewHolder.imBanAn.setOnClickListener(this);

        return convertView;
    }

    public class ViewHolder {
        TextView txtTenBanAn;
        ImageView imBanAn;
        ImageView imGoiMon;
        ImageView imThanhToan;
        ImageView imAnButton;

    }

    private void duocchon(){
        viewHolder.imGoiMon.setVisibility(View.VISIBLE);
        viewHolder.imThanhToan.setVisibility(View.VISIBLE);
        viewHolder.imAnButton.setVisibility(View.VISIBLE);

    }
    private void khongchon(){
        viewHolder.imAnButton.setVisibility(View.INVISIBLE);
        viewHolder.imThanhToan.setVisibility(View.INVISIBLE);
        viewHolder.imGoiMon.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewHolder= (ViewHolder) ((View)v.getParent()).getTag();
        switch (id) {
            case R.id.imBanAn:
          int vitri= (int) v.getTag();
          banAnList.get(vitri).setChonvitri(true);
              duocchon();
                break;

        }

    }

}

