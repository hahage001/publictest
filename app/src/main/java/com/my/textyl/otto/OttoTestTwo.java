package com.my.textyl.otto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.my.textyl.R;
import com.my.textyl.bean.EditBean;
import com.nightonke.blurlockview.BlurLockView;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.otto.Bus;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by 66km on 2018/7/4.
 */

public class OttoTestTwo extends AppCompatActivity {

    private Bus bus;
    private AVLoadingIndicatorView avi;
    String ssc = "[\n" +
            "            {\n" +
            "                \"goodsId\":\"525ce539-bd1f-4d41-a9c2-e6f127bdcc84\",\n" +
            "                \"goodsName\":\"空调滤清器\",\n" +
            "                \"brand\":\"耐诺思\",\n" +
            "                \"spec\":\"NC-9448\",\n" +
            "                \"outCode\":\"NC-9448\",\n" +
            "                \"price\":\"0.00\",\n" +
            "                \"goodsNumber\":4,\n" +
            "                \"sum\":\"0.00\",\n" +
            "                \"lastPrice\":\"0.00\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"goodsId\":\"37364dfc-1c04-416a-a91d-53b4ff05b07e\",\n" +
            "                \"goodsName\":\"空气滤清器\",\n" +
            "                \"brand\":\"博世\",\n" +
            "                \"spec\":\"0986AF2685\",\n" +
            "                \"outCode\":\"0986AF2685\",\n" +
            "                \"price\":\"0.00\",\n" +
            "                \"goodsNumber\":1,\n" +
            "                \"sum\":\"0.00\",\n" +
            "                \"lastPrice\":\"0.00\"\n" +
            "            }\n" +
            "        ]";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取实例
        bus = BusProvider.getInstance();
        //注册
        bus.register(this);
//        getWindow().setEnterTransition(new Slide().setDuration(1000));
//        getWindow().setExitTransition(new Slide().setDuration(1000));
        setContentView(R.layout.ottotwo_layout);

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.e("ssc"+ssc,"fadfdfei:hiehigh.");
        Logger.json("json:"+ssc);


        Button button=findViewById(R.id.id_btn);
        avi = findViewById(R.id.id_avi);
        ImageView img = findViewById(R.id.img);
        startAnim();
        BlurLockView blurLockView=findViewById(R.id.blurlockview);



        // Set the view that need to be blurred
        blurLockView.setBlurredView(img);

// Set the password
//        blurLockView.setCorrectPassword(getIntent().getStringExtra("PASSWORD"));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送
                EditBean editBean=new EditBean();
                editBean.setEdit1("ni");
                editBean.setEdit2(" hao");
                editBean.setTotal(" ma");
                bus.post(editBean);
            }
        });
    }

    void startAnim(){
        avi.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        avi.hide();
        // or avi.smoothToHide();
    }
}
