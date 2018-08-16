package com.my.textyl.broadcast;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.my.textyl.R;

/**
 * Created by 66km on 2018/7/4.
 */

public class BroadcastTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_layout);

        Button btn=findViewById(R.id.id_broadcast_ceshi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastIntent(v);
            }
        });
    }
    public void broadcastIntent(View view)
    {
        Intent intent = new Intent(BroadcastTest.this,MyReceiver.class);
//        intent.setAction("cn.uprogrammer.CUSTOM_INTENT");
        intent.putExtra("msg", "外卖到了");
        sendBroadcast(intent);
    }
}
