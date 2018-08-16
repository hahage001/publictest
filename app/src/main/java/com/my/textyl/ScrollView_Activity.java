package com.my.textyl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by 66km on 2018/7/18.
 * 重写setOnScrollChangeListener方法，有五个参数:
 * 第一个参数NestedScrollView v:是NestedScrollView的对象
 * 第二个参数:scrollX是目前的（滑动后）的X轴坐标
 * 第三个参数:ScrollY是目前的（滑动后）的Y轴坐标
 * 第四个参数:oldScrollX是之前的（滑动前）的X轴坐标
 * 第五个参数:oldScrollY是之前的（滑动前）的Y轴坐标
 */

public class ScrollView_Activity extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_layout);
        tv = findViewById(R.id.id_tv);
        NestedScrollView sv = findViewById(R.id.id_sv);

        sv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY/3  > dip2px(ScrollView_Activity.this, 45)) {
                    tv.setBackgroundColor(Color.parseColor("#000000"));
                    Log.e("scrollY",scrollY+"");
                    tv.getBackground().setAlpha(0);//0~255透明度值//0透明
                    tv.setTextColor(Color.argb(0, 0, 0, 0));  //文字透明度
                } else {
                    tv.setBackgroundColor(Color.parseColor("#000000"));
                    tv.getBackground().setAlpha(scrollY/3>=255?0:255-scrollY/3);//0~255透明度值
                    tv.setTextColor(Color.argb(scrollY/3>=255?0:255-scrollY/3, 25, 150, 200));  //文字透明度
                }
            }
        });
    }

    //将dp转换为px
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //将px转换为dp
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
