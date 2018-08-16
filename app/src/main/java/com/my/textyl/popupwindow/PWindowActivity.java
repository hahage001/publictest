package com.my.textyl.popupwindow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.my.textyl.R;

/**
 * Created by 66km on 2018/7/18.
 * 弹出框测试
 */

public class PWindowActivity extends AppCompatActivity {

    private FinishProjectPopupWindows mFinishProjectPopupWindow;
    private Button pp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwindow_layout);
        pp = findViewById(R.id.id_pp);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFinishProjectPopupWindow.showAtLocation(pp, Gravity.BOTTOM,0,0);
            }
        });

        // 显示PopupWindowmFinishProjectPopupWindow.showAtLocation(MapFragmentActivity.this.findViewById(R.id.main), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        mFinishProjectPopupWindow = new FinishProjectPopupWindows(PWindowActivity.this, itemsOnClick);

    }
    private View.OnClickListener itemsOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            mFinishProjectPopupWindow.dismiss();
            }



    };

}
