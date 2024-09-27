package com.example.birthdayapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class BirthdayCakeZoneActivity4 extends AppCompatActivity {
    LottieAnimationView caketobecut, knife, cake, cakeeating, thankyoulottie, mainlottie, exitlottie;
    Button zenModeButton, backButton, repeatbutton;
    int musicPlayerRunning = 0;
    TextView textView, textViewChangeMusic, quotesTextView, instructionTextView;
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
    int flag = 0;
    int exitLottieFlag = 0;
    int ifSetOnTouchListenerIsClickAtLeastOneTime = 0;
    int ifInZenMode = 0;

    private Handler handler2;
    private Runnable changeAnimationRunnable;
    private int currentAnimationIndex = 0;
    private String[] animationFiles = {"night.json", "morning.json", "trainbackground.json", "shootingstars.json", "autumn.json", "winter2.json", "winter3.json", "forest.json", "forest2.json", "alie.json", "dawn.json", "rainforest.json", "mountains.json", "swamp.json", "travel.json", "daynight.json", "daynighttwo.json", "daynightthree.json",
            "island.json", "island2.json", "alien.json", "countryside.json", "windmill.json","grassland.json", "grass.json", "vehiclegoing.json"};

    private String[] quotes = {
            "Growth begins at the end of your comfort zone.",
            "Believe in your infinite potential.",
            "Positive thoughts create positive realities.",
            "Embrace change for personal growth.",
            "Self-awareness is the key to personal growth.",
            "You are stronger than you think.",
            "Your attitude determines your direction.",
            "Every day is a chance to grow.",
            "Believe in yourself and all that you are.",
            "Personal growth is a lifelong journey.",
            "Positivity fuels personal development.",
            "Embrace your unique journey.",
            "Strength comes from overcoming challenges.",
            "Your potential is endless.",
            "Self-love is the foundation of growth.",
            "Progress, not perfection, is key.",
            "Your mindset shapes your reality.",
            "Learn, grow, and evolve continuously.",
            "Believe in the power of positive thinking.",
            "Personal growth requires patience and persistence.",
            "Small steps lead to big changes.",
            "Embrace your journey of self-discovery.",
            "Personal development is an ongoing process.",
            "Your best self is yet to come.",
            "Change your thoughts, change your life.",
            "Invest in yourself for lasting growth."
    };

    Animation fadeIn, fadeOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Apply the current theme before setting the content view
        setTheme(R.style.Theme_BirthdayApp2);
        setContentView(R.layout.activity_birthday_cake_zone4);
        fadeIn = AnimationUtils.loadAnimation(BirthdayCakeZoneActivity4.this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(BirthdayCakeZoneActivity4.this, R.anim.fade_out);

        caketobecut = findViewById(R.id.caketobecut);
        knife = findViewById(R.id.knife);
        cake = findViewById(R.id.cake);
        cakeeating = findViewById(R.id.cakeeating);
        thankyoulottie = findViewById(R.id.thankyoulottie);
        zenModeButton = findViewById(R.id.zenmodebutton);
        backButton = findViewById(R.id.backbutton);
        repeatbutton = findViewById(R.id.repeatbutton);
        textView = findViewById(R.id.textview);
        mainlottie = findViewById(R.id.mainLottie);
        exitlottie = findViewById(R.id.exitlottie);
        textViewChangeMusic = findViewById(R.id.changeMusicTextView);
        quotesTextView = findViewById(R.id.quotesTextView);
        instructionTextView = findViewById(R.id.instructionTextView);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.altosodessesy);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.windowtoaworldcut);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.amomentoftranquility);

        instructionTextView.setVisibility(View.VISIBLE);
        instructionTextView.startAnimation(fadeIn);
        TypeWriterAnimation typewriterAnimation = new TypeWriterAnimation("Swipe Finger Down On The Cake!", 50, instructionTextView);
        typewriterAnimation.animateText();

        Handler handler;
        handler = new Handler(Looper.getMainLooper());

        // Create the ScaleAnimation
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 1.23f, // Start and end values for the X axis scaling
                1.0f, 1.23f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f  // Pivot point of Y scaling
        );
        scaleAnimation.setDuration(7000); // Duration for one cycle
        scaleAnimation.setRepeatCount(Animation.INFINITE); // Repeat animation indefinitely
        scaleAnimation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the effect is continuous

        mainlottie.startAnimation(scaleAnimation);
        handler2 = new Handler();


        caketobecut.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Finger touches the screen
                        // Start cutting the cake animation
                        // You can use ObjectAnimator or other animation techniques here
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Finger moves on the screen
                        // Continue the cutting animation based on the finger movement
                        if(ifSetOnTouchListenerIsClickAtLeastOneTime == 0) {
                            instructionTextView.startAnimation(fadeOut);
                            instructionTextView.setVisibility(View.GONE);
                            ifSetOnTouchListenerIsClickAtLeastOneTime = 1;
                        }
                        if (flag == 0) {
                            knife.setVisibility(View.VISIBLE);
                            knife.setAnimation(fadeIn);
                            knife.playAnimation();
                            flag = 1;

                            caketobecut.playAnimation();
                        }

                        knife.addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                knife.setAnimation(fadeOut);
                                knife.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {
                                // Do nothing
                            }
                        });

                        caketobecut.addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                caketobecut.startAnimation(fadeOut);


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        caketobecut.setVisibility(View.GONE);
                                        cake.setVisibility(View.VISIBLE);
                                        cake.startAnimation(fadeIn);
                                        cake.playAnimation();
                                    }
                                }, 300); // 2 seconds delay

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {
                                // Do nothing
                            }
                        });


                        cake.addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                cake.startAnimation(fadeOut);


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        cake.setVisibility(View.GONE);
                                        cakeeating.setVisibility(View.VISIBLE);
                                        cakeeating.startAnimation(fadeIn);

                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                cakeeating.playAnimation();
                                            }
                                        }, 200); // 2 seconds delay

                                    }
                                }, 1500); // 2 seconds delay

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {
                                // Do nothing
                            }
                        });


                        cakeeating.addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                cakeeating.setAnimation(fadeOut);
                                cakeeating.setVisibility(View.GONE);
                                thankyoulottie.setVisibility(View.VISIBLE);
                                thankyoulottie.setAnimation(fadeIn);
                                thankyoulottie.playAnimation();
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {
                                // Do nothing
                            }
                        });


                        thankyoulottie.addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                zenModeButton.setVisibility(View.VISIBLE);
                                backButton.setVisibility(View.VISIBLE);
                                repeatbutton.setVisibility(View.VISIBLE);
                                zenModeButton.setAnimation(fadeIn);
                                backButton.setAnimation(fadeIn);
                                repeatbutton.setAnimation(fadeIn);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                // Do nothing
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {
                                // Do nothing
                            }
                        });

                        break;
                    case MotionEvent.ACTION_UP:
                        // Finger is lifted from the screen
                        // Finish the cutting animation and show the sliced cake
                        break;
                }
                return true;
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BirthdayCakeZoneActivity4.this, NavigatorActivity4.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        repeatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 0;
                thankyoulottie.setVisibility(View.GONE);
                caketobecut.setVisibility(View.VISIBLE);
                instructionTextView.setVisibility(View.VISIBLE);
                instructionTextView.startAnimation(fadeIn);
                TypeWriterAnimation typewriterAnimation = new TypeWriterAnimation("Swipe Finger Down On The Cake!", 50, instructionTextView);
                typewriterAnimation.animateText();
                ifSetOnTouchListenerIsClickAtLeastOneTime = 0;
            }
        });

        zenModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Pause the Happy Birthday Music
                MusicUtil.pauseMusic();

                ifInZenMode = 1;
                caketobecut.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
//                caketobecut, knife, cake, cakeeating, thankyoulottie, mainlottie, exitlottie;
                knife.setVisibility(View.GONE);
                cake.setVisibility(View.GONE);
                cakeeating.setVisibility(View.GONE);
                repeatbutton.setAnimation(fadeOut);
                backButton.setAnimation(fadeOut);
                zenModeButton.setAnimation(fadeOut);
                repeatbutton.setVisibility(View.GONE);
                backButton.setVisibility(View.GONE);
                zenModeButton.setVisibility(View.GONE);
                thankyoulottie.setVisibility(View.GONE);

                if(instructionTextView.getVisibility() == View.VISIBLE) {
                    instructionTextView.startAnimation(fadeOut);
                    instructionTextView.setVisibility(View.GONE);
                }

                quotesTextView.setVisibility(View.VISIBLE);
                quotesTextView.startAnimation(fadeIn);
                TypeWriterAnimation typewriterAnimation = new TypeWriterAnimation("RELAX IN ZEN-MODE~\n\nUse Earphones For The Best Experience!", 50, quotesTextView);
                typewriterAnimation.animateText();

                Random random = new Random();
                int randomNumber = random.nextInt(3) + 1; // Generate 1, 2, or 3
                if (randomNumber == 1) {
                    mediaPlayer1 = MediaPlayer.create(BirthdayCakeZoneActivity4.this, R.raw.altosodessesy);
                    mediaPlayer1.start();
                    musicPlayerRunning = 1;
                } else if (randomNumber == 2) {
                    mediaPlayer2 = MediaPlayer.create(BirthdayCakeZoneActivity4.this, R.raw.windowtoaworldcut);
                    mediaPlayer2.start();
                    musicPlayerRunning = 2;
                } else {
                    mediaPlayer3 = MediaPlayer.create(BirthdayCakeZoneActivity4.this, R.raw.amomentoftranquility);
                    mediaPlayer3.start();
                    musicPlayerRunning = 3;
                }

                changeAnimationRunnable = new Runnable() {
                    @Override
                    public void run() {
                        fadeOutAndChangeAnimation();
                    }
                };

                // Start the first animation change after a delay
                handler2.postDelayed(changeAnimationRunnable, 9500); // 5 seconds delay

            }
        });

        mainlottie.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ifInZenMode == 1) {
                    if (exitLottieFlag == 0) {
                        // Handle
                        exitlottie.setVisibility(View.VISIBLE);
                        exitlottie.startAnimation(fadeIn);
                        exitlottie.playAnimation();
                        exitLottieFlag = 1;
                        textViewChangeMusic.setVisibility(View.VISIBLE);
                        textViewChangeMusic.startAnimation(fadeIn);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textViewChangeMusic.startAnimation(fadeOut);
                                textViewChangeMusic.setVisibility(View.GONE);

                            }
                        }, 4000);

                    }
                }


                exitlottie.addAnimatorListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        // Do nothing
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        exitlottie.setAnimation(fadeOut);
                        exitlottie.setVisibility(View.GONE);
                        exitLottieFlag = 0;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        // Do nothing
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        // Do nothing
                    }
                });

                return true;
            }
        });

        exitlottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nunu = 1;
                MusicUtil.unpauseMusic();
                if(nunu == 1) {
                    // Remove callbacks to avoid memory leaks
                    handler2.removeCallbacks(changeAnimationRunnable);

                    if (musicPlayerRunning == 1) {
                        mediaPlayer1.stop();
                        mediaPlayer1.release();
                        musicPlayerRunning = 0;
                    } else if (musicPlayerRunning == 2) {
                        mediaPlayer2.stop();
                        mediaPlayer2.release();
                        musicPlayerRunning = 0;
                    } else {
                        mediaPlayer3.stop();
                        mediaPlayer3.release();
                        musicPlayerRunning = 0;
                    }

                    finish();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                else {      // We had a problem and that's why instead of going to the back page, we are going 2 pages back to avoid the lottie animation problems
                    ifInZenMode = 0;
                    exitlottie.cancelAnimation();
                    textView.setVisibility(View.VISIBLE);
                    repeatbutton.setAnimation(fadeIn);
                    backButton.setAnimation(fadeIn);
                    zenModeButton.setAnimation(fadeIn);
                    textView.setAnimation(fadeIn);
                    repeatbutton.setVisibility(View.VISIBLE);
                    backButton.setVisibility(View.VISIBLE);
                    zenModeButton.setVisibility(View.VISIBLE);
                    thankyoulottie.setVisibility(View.VISIBLE);
                    quotesTextView.setVisibility(View.GONE);

                    mainlottie.cancelAnimation();
                    mainlottie.clearAnimation();
                    mainlottie.setAnimation(R.raw.night);
                    mainlottie.startAnimation(scaleAnimation);
                    mainlottie.playAnimation();

                }


            }
        });

        textViewChangeMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(musicPlayerRunning == 1){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer1.stop();
                            mediaPlayer1.release();
                        }
                    }).start();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer2 = MediaPlayer.create(BirthdayCakeZoneActivity4.this, R.raw.windowtoaworldcut);
                            mediaPlayer2.start();
                            musicPlayerRunning = 2;
                        }
                    }).start();

                }
                else if(musicPlayerRunning == 2){

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer2.stop();
                            mediaPlayer2.release();
                        }
                    }).start();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer3 = MediaPlayer.create(BirthdayCakeZoneActivity4.this, R.raw.amomentoftranquility);
                            mediaPlayer3.start();
                            musicPlayerRunning = 3;
                        }
                    }).start();

                }
                else{

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer3.stop();
                            mediaPlayer3.release();
                        }
                    }).start();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer1 = MediaPlayer.create(BirthdayCakeZoneActivity4.this, R.raw.altosodessesy);
                            mediaPlayer1.start();
                            musicPlayerRunning = 1;
                        }
                    }).start();

                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        quotesTextView.setVisibility(View.GONE);
        if(musicPlayerRunning == 1){
            mediaPlayer1.stop();
            mediaPlayer1.release();
            musicPlayerRunning = 0;
        }
        else if(musicPlayerRunning == 2){
            mediaPlayer2.stop();
            mediaPlayer2.release();
            musicPlayerRunning = 0;
        }
        else if (musicPlayerRunning == 3){
            mediaPlayer3.stop();
            mediaPlayer3.release();
            musicPlayerRunning = 0;
        }
        finish();
    }

    private void fadeOutAndChangeAnimation() {
        if(ifInZenMode == 1) {
            ObjectAnimator fadeOut1 = ObjectAnimator.ofFloat(mainlottie, "alpha", 1f, 0f);
            fadeOut1.setDuration(1300); // duration of fade out animation
            fadeOut1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    changeAnimationFile();
                    fadeIn();
                }
            });
            fadeOut1.start();
            quotesTextView.startAnimation(fadeOut);
        }
    }

    private void changeAnimationFile() {
        if(ifInZenMode == 1) {
            // Set Lottie File
            currentAnimationIndex = (currentAnimationIndex + 1) % animationFiles.length;
            mainlottie.setAnimation(animationFiles[currentAnimationIndex]);

            // Set TextView
//            quotesTextView.setText(quotes[currentAnimationIndex]);
            quotesTextView.setVisibility(View.VISIBLE);
            quotesTextView.startAnimation(fadeIn);
            TypeWriterAnimation typewriterAnimation = new TypeWriterAnimation(quotes[currentAnimationIndex], 50, quotesTextView);
            typewriterAnimation.animateText();
        }
    }

    private void fadeIn() {
        if(ifInZenMode == 1) {
            ObjectAnimator fadeIn1 = ObjectAnimator.ofFloat(mainlottie, "alpha", 0f, 1f);
            fadeIn1.setDuration(1300); // duration of fade in animation
            fadeIn1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    // Schedule the next animation change
                    handler2.postDelayed(changeAnimationRunnable, 9500); // 5 seconds delay
                }
            });
            fadeIn1.start();
            quotesTextView.startAnimation(fadeIn);
            mainlottie.playAnimation();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MusicUtil.unpauseMusic();
        // Remove callbacks to avoid memory leaks
        handler2.removeCallbacks(changeAnimationRunnable);
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