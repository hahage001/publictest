package com.my.textyl.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.my.textyl.R;

import java.util.List;

/**
 * Created by 66km on 2018/8/15.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public Context context;
    public List<String> listS;

    public RecyclerViewAdapter(Context context, List<String> listS) {
        this.context = context;
        this.listS = listS;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent,false);


        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(listS.get(position)).asBitmap().into(holder.iv);
    }
    @Override
    public int getItemCount() {
        return listS.size();
    }

    /*
    * 写ViewHolder，解决控件的复用。
    * */
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_img);
        }

    }
}
