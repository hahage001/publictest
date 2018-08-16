package com.my.textyl.otto;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.my.textyl.R;
import com.my.textyl.bean.EditBean;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by 66km on 2018/7/4.
 */

public class OttoTestOne extends AppCompatActivity {

    private Bus bus;
    private Button button,button2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ottoone_layout);
        //订阅
        bus = BusProvider.getInstance();
        bus.register(this);
        button = findViewById(R.id.id_two);
        button2 = findViewById(R.id.id_two2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OttoTestOne.this,OttoTestThird.class);
                startActivity(intent);
//                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(OttoTestOne.this).toBundle());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OttoTestOne.this, OttoTestTwo.class);

                /*startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation
                                (OttoTestOne.this, Pair.create(v, "myButton1"),
                                        Pair.create(v, "myButton1"))
                                .toBundle());*/
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation
                                (OttoTestOne.this, v, "myButton1")
                                .toBundle());

            }
        });
    }
    @Subscribe
    public void setText(String textstring) {
        button.setText(textstring);
        Log.e("检测1",textstring+"");
    }
    @Subscribe
    public void setText2(EditBean textstring) {
        button2.setText(textstring.getEdit1()+""+textstring.getEdit2());
        Log.e("检测2", textstring.getEdit1()+""+textstring.getEdit2());
        button.setText(textstring.getEdit1());
    }
    /**
     * 取消订阅
     * */
    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }
}
