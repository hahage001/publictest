package com.my.textyl.lvbottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.my.textyl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 66km on 2018/7/20.
 */

public class LVbottomActivity extends AppCompatActivity {

    private ArrayAdapter arrayAdapter;
    private View inflate;
    private PullToRefreshListView ptrlv;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvbottom);
        ListView listView = findViewById(R.id.id_lvbtm_lv);
        ptrlv = findViewById(R.id.listview);

        inflate = LayoutInflater.from(this).inflate(R.layout.bottom, null);
        //定义LayoutParams，将它添加至headView
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        inflate.setLayoutParams(layoutParams);
//获取PullToRefreshListView 中的ListView
        listView.addFooterView(inflate);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("diyi " + i);
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        ptrlv.setAdapter(arrayAdapter);

        ptrlv.setOnScrollListener(new AbsListView.OnScrollListener() {
            /**
             * 滚动状态改变时调用
             */
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 不滚动时保存当前滚动到的位置
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    position = ptrlv.getRefreshableView().getFirstVisiblePosition();
                }
            }
            /**
             * 滚动时调用
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
        inflate.setVisibility(View.INVISIBLE);
        ptrlv.getRefreshableView().addFooterView(inflate);
        ptrlv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                ptrlv.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                ptrlv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                arrayAdapter.notifyDataSetChanged();
                //设置在notifyDataSetChanged之后才起作用，setSelect设置在之前。
                ptrlv.getRefreshableView().smoothScrollToPosition(list.size(), list.size());
                ptrlv.getRefreshableView().setSelection(5);
//                ptrlv.clearFocus();
                inflate.setVisibility(View.VISIBLE);
                ptrlv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrlv.onRefreshComplete();//解决失效问题
                    }
                }, 0);
            }
        });
        ptrlv.setMode(PullToRefreshBase.Mode.BOTH);
    }
}
