package com.example.birthdayapp;

import android.os.Handler;
import android.widget.TextView;

public class TypeWriterAnimation {
    private CharSequence mText;
    private int mIndex;
    private long mDelay;
    private TextView mTextView;
    private Handler mHandler = new Handler();

    public TypeWriterAnimation(CharSequence text, long delay, TextView textView) {
        mText = text != null ? text : "";
        mIndex = 0;
        mDelay = delay;
        mTextView = textView;
        textView.setText("");
    }

    public void animateText() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mText != null) {
                    mTextView.setText(mText.subSequence(0, mIndex++));
                    if (mIndex <= mText.length()) {
                        mHandler.postDelayed(this, mDelay);
                    }
                }
            }
        }, mDelay);
    }
}
