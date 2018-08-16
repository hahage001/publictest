package com.my.textyl.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.my.textyl.R;
import com.my.textyl.recycler.adapter.GridViewAdapter1;
import com.my.textyl.recycler.adapter.RecyclerViewAdapter;
import com.my.textyl.recycler.views.StaggeredGridView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by 66km on 2018/8/15.
 */

public class RecyclerViewTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
//        RecyclerView recyclerView = findViewById(R.id.id_recycview);

        StaggeredGridView staggeredGridView = findViewById(R.id.id_staggered);
        com.etsy.android.grid.StaggeredGridView staggeredGridView2 = findViewById(R.id.grid_view);

        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.toolbar_height);
        staggeredGridView.setItemMargin(dimensionPixelOffset);
        staggeredGridView.setPadding(dimensionPixelOffset,0,dimensionPixelOffset,0);
        staggeredGridView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            @Override
            public void onItemClick(StaggeredGridView parent, View view, int position, long id) {

            }
        });
        Log.e("sss","1");


        List<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("http://i0.hdslb.com/bfs/archive/83a12dcbe6401c27e16a3333b1eba91191ac3c8e.jpg");
        }
        Log.e("sss","2");

        staggeredGridView.setLayoutMode(MODE_APPEND);
        GridViewAdapter1 gridViewAdapter=new GridViewAdapter1(this,list);
        staggeredGridView.setAdapter(gridViewAdapter);
        Log.e("sss","3");
        staggeredGridView2.setAdapter(gridViewAdapter);



      /*  RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this, list);
        recyclerView.setAdapter(recyclerViewAdapter);




        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        gridLayoutManager.offsetChildrenHorizontal(1);
//        recyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                if (position%4==0){
                    return 2;
                    //表示%4==0的position，其可以独占该行按照比例划分空间的2个位置，但是如果要是，一行就划分了3份空间，但是要让其占有比这个
                    //会怎么样，如图，图三：
                    //会显示Item at position 0 requires 5 spans but GridLayoutManager has only 3 spans.
                    //就是如果你将行空间划分为三份，但是你这里return 4那么就会程序就会崩溃
                }
                return 1;//其他的表示就占一份空间就好
            }
        });*/
//        recyclerView.setLayoutManager(gridLayoutManager);

    }
}
