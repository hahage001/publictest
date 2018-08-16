package com.my.textyl.service;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.my.textyl.MainActivity;
import com.my.textyl.R;

/**
 * Created by 66km on 2018/7/4.
 */

public class MyService extends Service {

    private MyBinder mybinder;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("onBind","onBind");
        return mybinder;
    }

    @Override
    public void onDestroy() {
        Log.e("onDestroy","onDestroy");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("onStartCommand","onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        Log.e("onCreate","onCreate");
        //设定一个PendingIntent，来表示点击通知栏时跳转到哪里
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        Notification.Builder builder = new Notification.Builder(this);
        //建立一个notificationManager来管理通知的出现
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //构造通知的样式，包括图片，标题，内容，时间。
        builder.setSmallIcon(R.mipmap.ic_launcher).
                setWhen(System.currentTimeMillis()).
                setContentTitle("我是标题").
                setContentText("我是内容").
                setTicker("在启动时弹出一个消息").//这个Android5.0以上可能会失效
                setWhen(System.currentTimeMillis()).
                setContentIntent(contentIntent);
        //最后通过build建立好通知
        Notification notification = builder.build();
        //通过manager来显示通知，这个1为notification的id
        notificationManager.notify(1,notification);
        //启动为前台服务,这个1为notification的id
        startForeground(1,notification);
        super.onCreate();
    }

    class MyBinder extends Binder {
        public void MyStart(){
            Log.d("Service", "MyStart: MyStart");
        }
    }
}
