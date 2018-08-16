package com.my.textyl.gv;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 66km on 2018/7/9.
 */

public class ViewPagerAdapter extends PagerAdapter {
    public List<GridView> listGV = new ArrayList<>();

    public ViewPagerAdapter(List<GridView> lis) {
//        if (listGV.size() > 0) {
//            listGV.clear();
//        }
//        listGV.addAll(lis);
        this.listGV=lis;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return listGV == null ? 0 : listGV.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listGV.get(position));
        return listGV.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
