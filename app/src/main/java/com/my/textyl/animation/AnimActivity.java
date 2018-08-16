package com.my.textyl.animation;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.my.textyl.R;

import is.arontibo.library.ElasticDownloadView;

/**
 * Created by 66km on 2018/7/19.
 */

public class AnimActivity extends AppCompatActivity {

    private ElasticDownloadView mElasticDownloadView;
    private CountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_layout);
        ImageView viewById = findViewById(R.id.id_anim_img);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_c1);
        animation.setFillAfter(true);//动画停止后保持原样


//设置插值效果
//        animation.setInterpolator(Interpolator);
//对view执行动画
        viewById.startAnimation(animation);

        mElasticDownloadView = findViewById(R.id.elastic_download_view);
        mElasticDownloadView.startIntro();



        findViewById(R.id.id_s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });
        findViewById(R.id.id_f).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mElasticDownloadView.startIntro();
                mElasticDownloadView.setProgress(80);
                mElasticDownloadView.fail();
            }
        });
    }
    /**
     * 倒计时
     */
    public void setTime() {
        timer = new CountDownTimer(6000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                mElasticDownloadView.setProgress((6-(millisUntilFinished/1000))*10);

            }

            @Override
            public void onFinish() {
                mElasticDownloadView.success();
                timer.cancel();
            }
        };
        timer.start();
    }

}
