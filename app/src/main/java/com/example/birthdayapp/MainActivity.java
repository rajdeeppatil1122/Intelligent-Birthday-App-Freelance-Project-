package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView giftlottie, huglottie, starslottie1, starslottie2, clickherelottie;
    TextView t1, t2, t3, clickheretext;
    ImageView girlimageview;

    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giftlottie = findViewById(R.id.firstlottie);
        huglottie = findViewById(R.id.huglottie);
        starslottie1 = findViewById(R.id.stars1);
        starslottie2 = findViewById(R.id.stars2);
        clickherelottie = findViewById(R.id.clickherelottie);
        clickheretext = findViewById(R.id.clickheretext);
        girlimageview = findViewById(R.id.girlimageview);

        final int[] huglottieFLAG = {0};


        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);



        // Left to Right Animation
        Animation leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        t1.startAnimation(leftToRight);


        // Initialize the MediaPlayer and set the audio file from res/raw
        mediaPlayer1 = MediaPlayer.create(this, R.raw.th1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.th2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.ts1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Right to Left Animation
                Animation rightToLeft = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_left);
                t2.startAnimation(rightToLeft);
                t2.setVisibility(View.VISIBLE);

                // Start playing the audio automatically
                mediaPlayer1.start();
            }
        }, 2000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                giftlottie.setVisibility(View.VISIBLE);
                giftlottie.playAnimation();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Pop-Up Animation
                        Animation popUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.pop_up);
                        t3.startAnimation(popUp);
                        t3.setVisibility(View.VISIBLE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                clickherelottie.setVisibility(View.VISIBLE);
                                clickherelottie.playAnimation();
                                clickherelottie.setRepeatCount(1000);
                                clickheretext.setVisibility(View.VISIBLE);
                            }
                        }, 2000);

                    }
                }, 2000);


            }
        }, 4000);


        giftlottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giftlottie.playAnimation();
                if(huglottieFLAG[0] == 0){
                    huglottie.setVisibility(View.VISIBLE);
                    huglottie.playAnimation();
                    huglottie.setRepeatCount(5);
                }
                if(huglottieFLAG[0] == 1){
                    starslottie1.setVisibility(View.VISIBLE);
                    starslottie2.setVisibility(View.VISIBLE);
                    starslottie1.playAnimation();
                    starslottie2.playAnimation();
                    starslottie1.setRepeatCount(5);
                    starslottie2.setRepeatCount(5);
                }
                huglottieFLAG[0] = 1;
                // Start playing the audio automatically
                mediaPlayer2.start();
            }
        });

        huglottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huglottie.playAnimation();
                huglottie.setRepeatCount(5);
                // Start playing the audio automatically
                mediaPlayer3.start();
            }
        });

        starslottie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starslottie1.playAnimation();
                starslottie1.setRepeatCount(5);
            }
        });

        starslottie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starslottie2.playAnimation();
                starslottie2.setRepeatCount(5);
            }
        });

        clickherelottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SplashActivity2.class);
                startActivity(intent);
            }
        });

    }
}