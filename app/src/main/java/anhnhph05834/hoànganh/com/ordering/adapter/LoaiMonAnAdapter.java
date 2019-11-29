package anhnhph05834.hoànganh.com.ordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import anhnhph05834.hoànganh.com.ordering.R;
import anhnhph05834.hoànganh.com.ordering.model.LoaiMonAn;


public class LoaiMonAnAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<LoaiMonAn> loaiMonAnList;
    private ViewHolder viewHolder;

    public LoaiMonAnAdapter(Context context, int layout, List<LoaiMonAn> loaiMonAnList) {
        this.context = context;
        this.layout = layout;
        this.loaiMonAnList = loaiMonAnList;
    }

    @Override
    public int getCount() {
        return loaiMonAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return loaiMonAnList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return loaiMonAnList.get(position).getMaLoai();
    }

    public class ViewHolder{
        TextView txtTenloai;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.custum_layoutspiner_loaithucdon,parent,false);
            viewHolder.txtTenloai=convertView.findViewById(R.id.txttenloai);

            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        LoaiMonAn loaiMonAn=loaiMonAnList.get(position);
        viewHolder.txtTenloai.setText(loaiMonAn.getTenloai());
        viewHolder.txtTenloai.setTag(loaiMonAn.getMaLoai());


        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.custum_layoutspiner_loaithucdon,parent,false);
            viewHolder.txtTenloai=convertView.findViewById(R.id.txttenloai);

            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        LoaiMonAn loaiMonAn=loaiMonAnList.get(position);
        viewHolder.txtTenloai.setText(loaiMonAn.getTenloai());
        viewHolder.txtTenloai.setTag(loaiMonAn.getMaLoai());


        return convertView;
    }
}
