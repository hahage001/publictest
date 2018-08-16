package com.my.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 66km on 2018/6/26.
 */

public class TextTest {
    public static void showTest(Context context,String s ){
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }
}
