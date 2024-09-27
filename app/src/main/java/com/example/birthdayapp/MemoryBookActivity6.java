package com.example.birthdayapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer2;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookActivity6 extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_BirthdayApp2);
        setContentView(R.layout.activity_memory_book6);

        MusicUtil.pauseMusic();

        mediaPlayer = MediaPlayer.create(MemoryBookActivity6.this, R.raw.musicformemorybook);
        mediaPlayer.start();

        ViewPager2 myViewPager2;
        MyPagerAdapter myPagerAdapter;

        // Sample data
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.img1);
        imageList.add(R.drawable.img2);
        imageList.add(R.drawable.img3);
        imageList.add(R.drawable.img4);
        imageList.add(R.drawable.img5);
        imageList.add(R.drawable.img6);
        imageList.add(R.drawable.img7);
        imageList.add(R.drawable.img8);
        imageList.add(R.drawable.img9);
        imageList.add(R.drawable.img10);
        // Add more photos as needed

        // Get ViewPager2 and Set Adapter
        myViewPager2 = findViewById(R.id.viewPager2);
        myPagerAdapter = new MyPagerAdapter(this, imageList);
        myViewPager2.setAdapter(myPagerAdapter);

        // Create an object of page transformer
        BookFlipPageTransformer2 bookFlipPageTransformer = new BookFlipPageTransformer2();

        // Enable / Disable scaling while flipping. If true, then the next page will scale in (zoom in). By default, it's true.
        bookFlipPageTransformer.setEnableScale(true);

        // The amount of scale the page will zoom. By default, it's 5 percent.
        bookFlipPageTransformer.setScaleAmountPercent(10f);

        // Assign the page transformer to the ViewPager2.
        myViewPager2.setPageTransformer(bookFlipPageTransformer);

        // Repeat it Again
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mediaPlayer.stop();
        mediaPlayer.release();
        MusicUtil.unpauseMusic();
    }


}

