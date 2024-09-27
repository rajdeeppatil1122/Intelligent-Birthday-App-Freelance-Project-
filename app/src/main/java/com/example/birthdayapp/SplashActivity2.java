package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity2 extends AppCompatActivity {
    LottieAnimationView lottieAnimationView, lottieLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        lottieAnimationView = findViewById(R.id.lottieSplash);

        lottieLoading = findViewById(R.id.lottieLoading);
        lottieLoading.playAnimation();

        Animation fallFromTop = AnimationUtils.loadAnimation(this, R.anim.falling_down);
        // Start the animation
        lottieAnimationView.startAnimation(fallFromTop);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), WelcomeActivity3.class);
                startActivity(intent);

                finish();
            }
        }, 3500);
    }
}