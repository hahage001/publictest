package com.my.textyl.lv;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.my.textyl.R;

import java.util.ArrayList;
import java.util.List;

import it.carlom.stikkyheader.core.StikkyHeaderBuilder;

/**
 * Created by 66km on 2018/7/9.
 */

public class ListViewTest extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvlayout);
        ListView listView=findViewById(R.id.id_lv);
//        ImageView imageView=findViewById(R.id.id_head);
//        LinearLayout headLayout=findViewById(R.id.id_headlayout);
        List<String> list=new ArrayList<>();
        for(int i=0;i<100;i++){
           list.add(i+"");
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        LinearLayout view= (LinearLayout) LayoutInflater.from(this).inflate(R.layout.head_layout,null);
        StikkyHeaderBuilder.stickTo(listView)
                .setHeader(R.id.header, (ViewGroup) getWindow().getDecorView())
                .minHeightHeader(250)
//                .animator(new IconAnimator())
                .build();

    }
}
