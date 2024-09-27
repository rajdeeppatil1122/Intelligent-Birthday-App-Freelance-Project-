package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class NavigatorActivity4 extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, lll1, lll2, lll3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_BirthdayApp2);
        setContentView(R.layout.activity_navigator4);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        linearLayout1 = findViewById(R.id.ll1);
        linearLayout2 = findViewById(R.id.ll2);
        linearLayout3 = findViewById(R.id.ll3);
        lll1 = findViewById(R.id.lll1);
        lll2 = findViewById(R.id.lll2);
        lll3 = findViewById(R.id.lll3);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_left_to_right);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.translate_left_to_right);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.translate_left_to_right);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.startAnimation(animation);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.startAnimation(animation2);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.startAnimation(animation3);
            }
        });


        int color1 = ContextCompat.getColor(this, R.color.color11);
        int color2 = ContextCompat.getColor(this, R.color.color12);
        int color3 = ContextCompat.getColor(this, R.color.color13);
        int color4 = ContextCompat.getColor(this, R.color.color14);
        int color5 = ContextCompat.getColor(this, R.color.color15);
        int color6 = ContextCompat.getColor(this, R.color.color16);
        int color7 = ContextCompat.getColor(this, R.color.color17);

        int[] colors = {color1, color2, color3, color4, color5, color6, color7};

        ObjectAnimator colorAnimation = ObjectAnimator.ofInt(lll1, "backgroundColor", colors);
        ObjectAnimator colorAnimation2 = ObjectAnimator.ofInt(lll2, "backgroundColor", colors);
        ObjectAnimator colorAnimation3 = ObjectAnimator.ofInt(lll3, "backgroundColor", colors);

        colorAnimation.setDuration(5000); // 5 seconds
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        colorAnimation.setRepeatMode(ObjectAnimator.REVERSE);
        colorAnimation.start();

        colorAnimation2.setDuration(5000); // 5 seconds
        colorAnimation2.setEvaluator(new ArgbEvaluator());
        colorAnimation2.setRepeatCount(ObjectAnimator.INFINITE);
        colorAnimation2.setRepeatMode(ObjectAnimator.REVERSE);
        colorAnimation2.start();

        colorAnimation3.setDuration(5000); // 5 seconds
        colorAnimation3.setEvaluator(new ArgbEvaluator());
        colorAnimation3.setRepeatCount(ObjectAnimator.INFINITE);
        colorAnimation3.setRepeatMode(ObjectAnimator.REVERSE);
        colorAnimation3.start();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation started
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation ended, execute your code here
                Intent intent = new Intent(NavigatorActivity4.this, BirthdayCakeZoneActivity4.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeated
            }
        });

        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation started
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation ended, execute your code here
                Intent intent = new Intent(NavigatorActivity4.this, TriviaChallengeActivity5.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeated
            }
        });

        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation started
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation ended, execute your code here
                Intent intent = new Intent(NavigatorActivity4.this, MemoryBookActivity6.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.slide_out_left);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeated
            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();
        // Your task when the application is paused (e.g., save data, stop animations, release resources)
        Log.d("ActivityLifecycle", "App is paused");
        // Example: pause a MediaPlayer
        MusicUtil.pauseMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Your task when the application is resumed (e.g., reinitialize resources, restart animations)
        Log.d("ActivityLifecycle", "App is resumed");
        // Example: resume a MediaPlayer
        MusicUtil.unpauseMusic();
    }

}