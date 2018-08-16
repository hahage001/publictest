package com.my.textyl;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.my.mylibrary.TextTest;
import com.my.textyl.adapter.EditAdapter;
import com.my.textyl.bean.EditBean;
import com.my.zttimeuitils.datePicker.CustomDatePicker;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditAdapter editAdapter;
    private List<EditBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView button = findViewById(R.id.id_ceshi);
        ListView listView=findViewById(R.id.id_listview);
        EditBean editBean;
        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            editBean=new EditBean();
            editBean.setEdit1(""+i);
            editBean.setEdit2(""+i);
            editBean.setTotal(""+i);
            list.add(editBean);
        }
        editAdapter = new EditAdapter(this, list);
        listView.setAdapter(editAdapter);
        editAdapter.setOnItemEditListener(new EditAdapter.OnItemEditListener() {
            @Override
            public void editListener(String s1, String s2, int position) {
                list.get(position).setEdit1(s1);
                list.get(position).setEdit2(s2);
                editAdapter.notifyDataSetChanged();

            }
        });






    }

    String forTime;

    public void SelectTime(final Button SelectTime) {
        if (TextUtils.isEmpty(SelectTime.getText().toString())) {
            forTime = TimeUtils.millis2String(System.currentTimeMillis());
            SelectTime.setText(forTime.split(" ")[0]);
        }
        CustomDatePicker customDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                SelectTime.setText(time.split(" ")[0]);
            }
        }, "1949-01-01 00:00", "3000-01-01 00:00", R.color.white, R.color.colorAccent); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(false); // 不显示时和分
        customDatePicker.setIsLoop(true); // 不允许循环滚动
        customDatePicker.show(SelectTime.getText().toString());
    }
}
