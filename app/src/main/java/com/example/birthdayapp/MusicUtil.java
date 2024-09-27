package com.example.birthdayapp;

import android.media.MediaPlayer;

public class MusicUtil {
    private static MediaPlayer mediaPlayer;

    public static void setMediaPlayer(MediaPlayer player) {
        mediaPlayer = player;
    }

    public static void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public static void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public static void unpauseMusic() {
            mediaPlayer.start();
    }
}

