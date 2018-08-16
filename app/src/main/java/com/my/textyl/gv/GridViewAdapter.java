package com.my.textyl.gv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.textyl.MainActivity;
import com.my.textyl.R;

import java.util.ArrayList;
import java.util.List;


class GridViewAdapter extends BaseAdapter {
    private List<GVbean> dataList;

    GridViewAdapter(List<GVbean> datas, int page) {
        dataList = new ArrayList<>();
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * 8;
        int end = start + 8;
        while ((start < datas.size()) && (start < end)) {
            dataList.add(datas.get(start));
            start++;
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gridview, viewGroup, false);
            mHolder.iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            mHolder.tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        GVbean bean = dataList.get(i);
        if (bean != null) {
            mHolder.iv_img.setImageResource(R.mipmap.ic_launcher);
            mHolder.tv_text.setText(bean.getDes());
        }
        return itemView;
    }

    private class ViewHolder {
        private ImageView iv_img;
        private TextView tv_text;
    }
}
