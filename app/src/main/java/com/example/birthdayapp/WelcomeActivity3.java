package com.example.birthdayapp;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

public class WelcomeActivity3 extends AppCompatActivity {
    LottieAnimationView lottieLoading, confitee1, confitee2, falling_lottie, lottieFrameAnimation, goldenconfitee1, goldenconfitee2, k1lottie, k2lottie, k3lottie, heart1, heart2;
    LottieAnimationView frameLottieAnimation, c1LottieAnimation, c2LottieAnimation, c3LottieAnimation, decorationballon, decorationrockets, cakenotsoimportant, happypipannilottie, dogdecoration;
    LottieAnimationView goarrowlottie;
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5;
    TextView happyBirthdayText, textviewTouchMe, wishTextView;
    int counterForWishText = 0;
    ImageView girlimageview;
    int flag2 = 0;
    boolean animationRunning = false;
    RelativeLayout relativelayoutid;
    int flag = 0; // frame1, 1 indicates frame2
    FrameLayout framelayout;
    CardView girlImageID;
    CardView imageViewGirl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome3);

        happyBirthdayText = findViewById(R.id.happyBirthdayText);
        imageViewGirl = findViewById(R.id.girlimageID);
        confitee1 = findViewById(R.id.confettie1);
        confitee2 = findViewById(R.id.confettie2);
        falling_lottie = findViewById(R.id.falling_lottie);
        framelayout = findViewById(R.id.framelayout);
        girlimageview = findViewById(R.id.girlimageview);
        textviewTouchMe = findViewById(R.id.textviewTouchMe);
        lottieFrameAnimation = findViewById(R.id.lottieFrameAnimation);
        frameLottieAnimation = findViewById(R.id.lottieFrameAnimation);
        c1LottieAnimation = findViewById(R.id.c1LottieAnimation);
        c2LottieAnimation = findViewById(R.id.c2LottieAnimation);
        c3LottieAnimation = findViewById(R.id.c3LottieAnimation);
        relativelayoutid = findViewById(R.id.relativelayoutid);
        wishTextView = findViewById(R.id.wishTextView);
        decorationballon = findViewById(R.id.decorationballon);
        decorationrockets = findViewById(R.id.decorationrockets);
        dogdecoration = findViewById(R.id.dogdecoration);
        happypipannilottie = findViewById(R.id.happypipannilottie);
        cakenotsoimportant = findViewById(R.id.cakenotsoimportant);
        goldenconfitee1 = findViewById(R.id.goldenconfitee1);
        goldenconfitee2 = findViewById(R.id.goldenconfitee2);
        k1lottie = findViewById(R.id.k1lottie);
        k2lottie = findViewById(R.id.k2lottie);
        k3lottie = findViewById(R.id.k3lottie);
        heart1 = findViewById(R.id.heart1);
        heart2 = findViewById(R.id.heart2);
        goarrowlottie = findViewById(R.id.goarrowlottie);
        girlImageID = findViewById(R.id.girlimageID);

        // for adjusting the textview SP if the linearlayout starts from more than 50% of screen's height
        RelativeLayout mainRelativeLayout = findViewById(R.id.mainRelativeLayout);

        int color1 = ContextCompat.getColor(this, R.color.color1);
        int color2 = ContextCompat.getColor(this, R.color.color2);
        int color3 = ContextCompat.getColor(this, R.color.color3);
        int color4 = ContextCompat.getColor(this, R.color.color4);
        int color5 = ContextCompat.getColor(this, R.color.color5);
        int color6 = ContextCompat.getColor(this, R.color.color6);
        int color7 = ContextCompat.getColor(this, R.color.color7);

        int[] colors = {color1, color2, color3, color4, color5, color6, color7};

        ObjectAnimator colorAnimation = ObjectAnimator.ofInt(mainRelativeLayout, "backgroundColor", colors);
        colorAnimation.setDuration(10000); // 5 seconds
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        colorAnimation.setRepeatMode(ObjectAnimator.REVERSE);
        colorAnimation.start();

        // Get the SCREEN HEIGHT IN DP
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float screenHeightDp = displayMetrics.heightPixels / displayMetrics.density;


        mediaPlayer1 = MediaPlayer.create(this, R.raw.cr2);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.confettiparty2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.pianoprimary);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.lofi);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.pianosecondary);

        // Start the first MediaPlayer
        mediaPlayer3.start();
        // Set the media player in the utility class
        MusicUtil.setMediaPlayer(mediaPlayer3);

        // Set OnCompletionListener for mediaPlayer1
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer4.start();
                // Set the media player in the utility class
                MusicUtil.setMediaPlayer(mediaPlayer4);
            }
        });

        // Set OnCompletionListener for mediaPlayer2
        mediaPlayer4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer5.start();
                // Set the media player in the utility class
                MusicUtil.setMediaPlayer(mediaPlayer5);
            }
        });

        // Set OnCompletionListener for mediaPlayer3
        mediaPlayer5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer3.start();
                // Set the media player in the utility class
                MusicUtil.setMediaPlayer(mediaPlayer3);
            }
        });

        happyBirthdayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(animationRunning == false) {     // this ensures that animation will not run again if it is already running
                    if (flag2 == 0) {
                        animationRunning = true;
                        Animation rotate = AnimationUtils.loadAnimation(WelcomeActivity3.this, R.anim.rotate_anim);
                        happyBirthdayText.startAnimation(rotate);
                        rotate.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                // Animation started
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                // Animation ended
                                flag2 = 1; // Update flag here only when it ends
                                animationRunning = false;
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                                // Animation repeated, not needed for this case
                            }
                        });
                    } else {
                        animationRunning = true;
                        Animation rotate2 = AnimationUtils.loadAnimation(WelcomeActivity3.this, R.anim.rotate_anim_reverse);
                        happyBirthdayText.startAnimation(rotate2);
                        rotate2.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                // Animation started
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                // Animation ended
                                flag2 = 0; // Update flag here only when it ends
                                animationRunning = false;
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                                // Animation repeated, not needed for this case
                            }
                        });
                    }
                }
            }
        });

        Animation moveUp = AnimationUtils.loadAnimation(this, R.anim.translate_up);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        happyBirthdayText.setAnimation(moveUp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                girlImageID.setVisibility(View.VISIBLE);
                girlImageID.setAnimation(fadeIn);
                goarrowlottie.setVisibility(View.VISIBLE);
                goarrowlottie.setAnimation(fadeIn);
                // Start the first animation
                heart1.setVisibility(View.VISIBLE);
                heart1.setAnimation(fadeIn);
                heart1.playAnimation();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        confitee1.setVisibility(View.VISIBLE);
                        confitee2.setVisibility(View.VISIBLE);
                        confitee1.playAnimation();
                        confitee2.playAnimation();
                        c1LottieAnimation.setVisibility(View.VISIBLE);
                        c1LottieAnimation.playAnimation();
                        goarrowlottie.setVisibility(View.VISIBLE);
                        goarrowlottie.loop(true);
                        goarrowlottie.playAnimation();

                        runCr1Music();

                    }
                }, 1500);

            }
        }, 2000);

        goarrowlottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity3.this, NavigatorActivity4.class);
                startActivity(intent);
            }
        });


        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        // Get the position on the screen and adjust TextView font size if needed
        linearLayout.post(new Runnable() {
            @Override
            public void run() {
                int[] location = new int[2];
                linearLayout.getLocationOnScreen(location);
                float linearLayoutStartYDp = location[1] / displayMetrics.density;

                // Check if LinearLayout starts from 51% or more of the screen height
                if (linearLayoutStartYDp >= 0.51 * screenHeightDp) {
                    // Decrease TextView font size by 3sp
                    float currentSizeSp = wishTextView.getTextSize() / displayMetrics.scaledDensity;
                    wishTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentSizeSp - 4);
                }
            }
        });


        // lottie frame
        Handler handler;
        handler = new Handler(Looper.getMainLooper());

        lottieFrameAnimation.setRepeatCount(0); // Ensure it doesn't loop automatically


        lottieFrameAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    lottieFrameAnimation.setAnimation(R.raw.frame2);
                    flag = 1;
                } else if (flag == 1) {
                    lottieFrameAnimation.setAnimation(R.raw.frame3);
                    flag = 2;
                } else if (flag == 2) {
                    lottieFrameAnimation.setAnimation(R.raw.frame);
                    flag = 0;
                }

            }
        });

        lottieFrameAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lottieFrameAnimation.playAnimation();
                    }
                }, 1700); // 2 seconds delay
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

        //------------------

        // Set OnCompleteListener for the first animation
        heart1.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // Start the second animation immediately after the first one ends
                // Delay the start of the first animation by 5 seconds
                heart1.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        heart2.setVisibility(View.VISIBLE);
                        heart2.playAnimation();
                    }
                }, 2000);
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

        // Set OnCompleteListener for the second animation
        heart2.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // Delay the start of the first animation by 5 seconds
                heart2.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        heart1.setVisibility(View.VISIBLE);
                        heart1.playAnimation();
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
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


        c1LottieAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                c1LottieAnimation.setVisibility(View.GONE);
                c2LottieAnimation.setVisibility(View.VISIBLE);
                c2LottieAnimation.playAnimation();
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

        c2LottieAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                c2LottieAnimation.setVisibility(View.GONE);
                c3LottieAnimation.setVisibility(View.VISIBLE);
                c3LottieAnimation.playAnimation();
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

        c3LottieAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                c3LottieAnimation.setVisibility(View.GONE);
                relativelayoutid.setVisibility(View.VISIBLE);
                lottieFrameAnimation.setVisibility(View.VISIBLE);
                lottieFrameAnimation.playAnimation();

                // typewrite animation
                wishTextView.setVisibility(View.VISIBLE);
                String text = "Happy Birthday, Sushant! Wishing you a day filled with laughter, love, and everything you’ve ever dreamed of! ☺";
                long delay = 50; // Delay in milliseconds between each character
                TypeWriterAnimation typewriterAnimation = new TypeWriterAnimation(text, delay, wishTextView);
                typewriterAnimation.animateText();
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

        wishTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterForWishText++;
                if (counterForWishText < 2) {
                    wishTextView.setVisibility(View.VISIBLE);
                    String text = "Happy Birthday, Sushant! Wishing you a day filled with laughter, love, and everything you’ve ever dreamed of! ☺";
                    long delay = 50; // Delay in milliseconds between each character
                    TypeWriterAnimation typewriterAnimation = new TypeWriterAnimation(text, delay, wishTextView);
                    typewriterAnimation.animateText();
                } else if (counterForWishText == 2) {
                    relativelayoutid.setVisibility(View.GONE);
                    lottieFrameAnimation.setVisibility(View.GONE);
                    wishTextView.setVisibility(View.GONE);

                    decorationballon.setVisibility(View.VISIBLE);
                    decorationballon.playAnimation();

                    decorationballon.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            // Do nothing
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            decorationballon.setVisibility(View.GONE);
                            decorationrockets.setVisibility(View.VISIBLE);
                            decorationrockets.playAnimation();
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

                    decorationrockets.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            // Do nothing
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            decorationrockets.setVisibility(View.GONE);
                            cakenotsoimportant.setVisibility(View.VISIBLE);
                            cakenotsoimportant.playAnimation();
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

                    cakenotsoimportant.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            // Do nothing
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cakenotsoimportant.setVisibility(View.GONE);
                            dogdecoration.setVisibility(View.VISIBLE);
                            dogdecoration.playAnimation();
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

                    dogdecoration.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            // Do nothing
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            dogdecoration.setVisibility(View.GONE);
                            happypipannilottie.setVisibility(View.VISIBLE);
                            happypipannilottie.playAnimation();
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
                    happypipannilottie.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            // Do nothing
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            happypipannilottie.setVisibility(View.GONE);

                            // open frame and text layout
                            relativelayoutid.setVisibility(View.VISIBLE);
                            lottieFrameAnimation.setVisibility(View.VISIBLE);
                            wishTextView.setVisibility(View.VISIBLE);

                            lottieFrameAnimation.playAnimation();
                            counterForWishText = 0;
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
                }
            }
        });


        girlimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first thing is make the text invisible
                textviewTouchMe.setVisibility(View.INVISIBLE);

                ScaleAnimation scaleUp = new ScaleAnimation(
                        1.0f, 1.1f,  // Start and end values for the X axis scaling
                        1.0f, 1.1f,  // Start and end values for the Y axis scaling
                        ScaleAnimation.RELATIVE_TO_SELF, 0.5f,  // Pivot point of X scaling
                        ScaleAnimation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
                scaleUp.setFillAfter(true); // Needed to keep the result of the animation
                scaleUp.setDuration(1000);

                scaleUp.setRepeatCount(3); // Repeat 3 times as 1 time is already repeated at first
                scaleUp.setRepeatMode(Animation.REVERSE); // Reverse the animation

                imageViewGirl.startAnimation(scaleUp);
                k1lottie.setVisibility(View.VISIBLE);
                k2lottie.setVisibility(View.VISIBLE);
                k3lottie.setVisibility(View.VISIBLE);
                k1lottie.playAnimation();
                k2lottie.playAnimation();
                k3lottie.playAnimation();
            }
        });

        confitee1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confitee1.playAnimation();
//                mediaPlayer2.start();
                falling_lottie.setVisibility(View.VISIBLE);
                falling_lottie.setVisibility(View.VISIBLE);
                falling_lottie.playAnimation();
                falling_lottie.setRepeatCount(3);
                goldenconfitee2.setVisibility(View.VISIBLE);
                goldenconfitee2.playAnimation();
                k1lottie.setVisibility(View.VISIBLE);
                k2lottie.setVisibility(View.VISIBLE);
                k3lottie.setVisibility(View.VISIBLE);
                k1lottie.playAnimation();
                k2lottie.playAnimation();
                k3lottie.playAnimation();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runCr1Music();
                    }
                }, 450);


            }
        });

        confitee2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confitee2.playAnimation();
                goldenconfitee1.setVisibility(View.VISIBLE);
                goldenconfitee1.playAnimation();
                falling_lottie.setVisibility(View.VISIBLE);
                falling_lottie.playAnimation();
                falling_lottie.setRepeatCount(3);
                k1lottie.setVisibility(View.VISIBLE);
                k2lottie.setVisibility(View.VISIBLE);
                k3lottie.setVisibility(View.VISIBLE);
                k1lottie.playAnimation();
                k2lottie.playAnimation();
                k3lottie.playAnimation();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runCr1Music();
                    }
                }, 450);
//                runCr1Music();
            }
        });

        goldenconfitee1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goldenconfitee1.playAnimation();
                mediaPlayer2.start();
                falling_lottie.setVisibility(View.VISIBLE);
                falling_lottie.playAnimation();
                falling_lottie.setRepeatCount(3);
                k1lottie.setVisibility(View.VISIBLE);
                k2lottie.setVisibility(View.VISIBLE);
                k3lottie.setVisibility(View.VISIBLE);
                k1lottie.playAnimation();
                k2lottie.playAnimation();
                k3lottie.playAnimation();
            }
        });
        goldenconfitee2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goldenconfitee2.playAnimation();
                mediaPlayer2.start();
                falling_lottie.setVisibility(View.VISIBLE);
                falling_lottie.playAnimation();
                falling_lottie.setRepeatCount(3);
                k1lottie.setVisibility(View.VISIBLE);
                k2lottie.setVisibility(View.VISIBLE);
                k3lottie.setVisibility(View.VISIBLE);
                k1lottie.playAnimation();
                k2lottie.playAnimation();
                k3lottie.playAnimation();
            }
        });

    }


    public void runCr1Music() {

        // for running only 8 times
        final int[] playCount = {0};
        final int maxPlays = 1;

        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playCount[0]++;
                if (playCount[0] < maxPlays) {
                    mediaPlayer1.start();
                } else {
//                    mediaPlayer1.release(); // Release the media player after 8 plays
                }
            }
        });


        mediaPlayer1.start();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MusicUtil.stopMusic();
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