package com.my.textyl.otto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.my.textyl.R;
import com.my.textyl.bean.EditBean;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

/**
 * Created by 66km on 2018/8/14.
 */

public class OttoTestThird extends AppCompatActivity {
    private Bus bus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取实例
        bus = BusProvider.getInstance();
        //注册
        bus.register(this);
        setContentView(R.layout.ottothird_layout);
        Button btn1 = findViewById(R.id.id_third);
        Button btn2 = findViewById(R.id.id_third2);
    }
    @Produce
    public EditBean providerEvent(){
        EditBean eventData = new EditBean();
        eventData.setEdit1("hello world");
        return eventData;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}