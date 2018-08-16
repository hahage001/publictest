package com.my.textyl.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.my.textyl.R;

/**
 * Created by 66km on 2018/7/4.
 */

public class ServiceTest extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_layout);
        Button ceshi = findViewById(R.id.id_broadcast_ceshi);
        ceshi.setText("服务测试");
        ceshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent=new Intent(ServiceTest.this,MyService.class);
//                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                startService(bindIntent);
            }
        });
    }
    private MyService.MyBinder myBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//绑定调用
            myBinder=(MyService.MyBinder) service;
            myBinder.MyStart();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
//j解绑调用
        }
    };
}
