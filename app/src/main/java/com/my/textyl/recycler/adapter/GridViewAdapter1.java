package com.my.textyl.recycler.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.my.textyl.R;

import java.util.List;

/**
 * Created by 66km on 2018/8/15.
 */

public class GridViewAdapter1 extends BaseAdapter {
    public Context context;
    public List<String> list;

    public GridViewAdapter1(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.gvImg = convertView.findViewById(R.id.iv_img);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load("http://i0.hdslb.com/bfs/archive/83a12dcbe6401c27e16a3333b1eba91191ac3c8e.jpg").asBitmap().into(viewHolder.gvImg);


        return convertView;
    }

    class ViewHolder {
        ImageView gvImg;


    }
}
