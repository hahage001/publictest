package com.my.textyl.gv;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.my.textyl.R;
import com.my.textyl.gv.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 66km on 2018/7/9.
 */

public class GridViewTest_Activity extends Activity {

    private List<GVbean> listbean;
    private List<GridView> gridList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewtest_layout);

        //添加view
        listbean = new ArrayList<>();
        gridList = new ArrayList<>();
        initView();


    }

    private void initView() {
        ViewPager viewPager=findViewById(R.id.id_vp);
        //圆点指示器
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setVisibility(View.VISIBLE);
        //初始化数据
        for (int i = 0; i < 17; i++) {
            GVbean bean = new GVbean();
            bean.setDes( "第" + (i + 1) + "条数据");
            listbean.add(bean);
        }
        //计算viewpager一共显示几页
        int pageSize = listbean.size() % 8 == 0 ? listbean.size() / 8 : listbean.size() / 8 + 1;
        for (int i = 0; i < pageSize; i++) {
            GridView gridView = new GridView(this);
            GridViewAdapter adapter = new GridViewAdapter(listbean, i);
            gridView.setNumColumns(4);
            gridView.setAdapter(adapter);
            gridList.add(gridView);
        }
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(gridList);
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
    }
}
