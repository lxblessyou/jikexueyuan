package com.example.admin.scalee2d;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends Activity implements Animation.AnimationListener {
    private FrameLayout mFl;
    private ImageView mImg1;
    private ImageView mImg2;
    private ScaleAnimation mScaAnim1 = new ScaleAnimation(1f, 0f, 1f, 1f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    private ScaleAnimation mScaAnim2 = new ScaleAnimation(1f, 0f, 1f, 1f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mScaAnim1.setDuration(200);
        mScaAnim2.setDuration(200);
        mScaAnim1.setAnimationListener(this);
        mScaAnim2.setAnimationListener(this);
        mFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImg1.getVisibility() == View.VISIBLE) {
                    mImg1.startAnimation(mScaAnim1);
                } else {
                    mImg2.startAnimation(mScaAnim2);
                }
            }
        });
    }

    private void hideImg1() {
        mImg1.setVisibility(View.GONE);
        mImg2.setVisibility(View.VISIBLE);
    }

    private void hideImg2() {
        mImg1.setVisibility(View.VISIBLE);
        mImg2.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == mScaAnim1) {
            hideImg1();
        } else {
            hideImg2();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
