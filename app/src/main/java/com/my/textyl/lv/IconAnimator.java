package com.my.textyl.lv;

import android.graphics.Point;
import android.view.View;

import com.my.textyl.R;

import it.carlom.stikkyheader.core.animator.AnimatorBuilder;
import it.carlom.stikkyheader.core.animator.HeaderStikkyAnimator;

public class IconAnimator extends HeaderStikkyAnimator {

    @Override
    public AnimatorBuilder getAnimatorBuilder() {

        View viewToAnimate = getHeader().findViewById(R.id.icon);
        Point point = new Point(50, 100); // translate to the point with coordinate (50,100);
        float scaleX = 0.5f;//scale to the 50%
        float scaleY = 0.5f;//scale to the 50%
        float fade = 0.2f; // 20% fade

        AnimatorBuilder animatorBuilder = AnimatorBuilder.create()
                .applyScale(viewToAnimate, scaleX, scaleY)
                .applyTranslation(viewToAnimate, point)
                .applyFade(viewToAnimate, fade);

        return animatorBuilder;
    }
}