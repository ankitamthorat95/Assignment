package com.axxessassignmentapp.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.axxessassignmentapp.application.R;
import com.axxessassignmentapp.application.utils.Utility;

import static android.view.View.VISIBLE;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    Activity activity;
    //UserHolder response;
    ImageView img_view_logo;
    Animation fadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = SplashActivity.this;
        Utility.makeFullscreenActivity(activity);

        img_view_logo = findViewById(R.id.img_view_logo);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        img_view_logo.setVisibility(VISIBLE);
        img_view_logo.startAnimation(fadeIn);

        Handler handler;

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                  Utility.launchActivity(SplashActivity.this,HomeActivity.class,true);
            }
        }, 4500);
    }

}