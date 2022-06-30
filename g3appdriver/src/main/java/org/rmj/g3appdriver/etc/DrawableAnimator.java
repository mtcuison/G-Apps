package org.rmj.g3appdriver.etc;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public class DrawableAnimator {

    public static void Animate(Drawable drawable, ImageView imageView){
        AnimatedVectorDrawableCompat avdc;
        AnimatedVectorDrawable avd;
        if(drawable instanceof AnimatedVectorDrawableCompat){
            avdc = (AnimatedVectorDrawableCompat)drawable;
            imageView.setImageDrawable(avdc);
            AnimatedVectorDrawableCompat.registerAnimationCallback(drawable, new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    avdc.start();
                }
            });
            avdc.start();
        } else {
            if(drawable instanceof AnimatedVectorDrawable){
                avd = (AnimatedVectorDrawable) drawable;
                imageView.setImageDrawable(avd);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    avd.registerAnimationCallback(new Animatable2.AnimationCallback() {
                        @Override
                        public void onAnimationEnd(Drawable drawable) {
                            avd.start();
                        }
                    });
                }
                avd.start();
            }
        }
    }
}
