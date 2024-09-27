package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class TriviaChallengeActivity5 extends AppCompatActivity {
    TextView textViewQuestion, textViewa1, textViewa2, textViewa3, textViewa4;
    MaterialButton materialButton;
    MediaPlayer mediaPlayer;

    private String[] questions = {
            "Q1. What is your favorite destination to travel to?",
            "Q2. What was your first dream to become in life?",
            "Q3. Which subject do you enjoy the most in Computer Science?",
            "Q4. Who is your favorite character from a TV show or movie?",
            "Q5. What is your favorite type of music?",
            "Q6. Which of these is your favorite programming language?",
            "Q7. What is your go-to comfort food?"
    };

    private String[][] answers = {
            {"Paris", "Tokyo", "New York", "Sydney"},
            {"Doctor", "Teacher", "Engineer", "Artist"},
            {"Programming", "Data Structures", "Algorithms", "Databases"},
            {"Harry Potter", "Sherlock Holmes", "Wonder Woman", "Iron Man"},
            {"Pop", "Rock", "Classical", "Jazz"},
            {"Python", "Java", "C++", "JavaScript"},
            {"Pizza", "Ice Cream", "Burger", "Chocolate"}
    };

    private int[] correctAnswers = {0, 2, 0, 1, 0, 2, 1}; // Index of the correct answer for each question
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int selectedAnswerIndex = -1;
    private TextView[] answerTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_BirthdayApp2);
        setContentView(R.layout.activity_trivia_challenge5);

        textViewQuestion = findViewById(R.id.questionTextView);
        textViewa1 = findViewById(R.id.ansTextView1);
        textViewa2 = findViewById(R.id.ansTextView2);
        textViewa3 = findViewById(R.id.ansTextView3);
        textViewa4 = findViewById(R.id.ansTextView4);
        materialButton = findViewById(R.id.submitBtn);

        MusicUtil.pauseMusic();

        mediaPlayer = MediaPlayer.create(TriviaChallengeActivity5.this, R.raw.micompressed);
        mediaPlayer.start();

        answerTextViews = new TextView[]{textViewa1, textViewa2, textViewa3, textViewa4};

        loadQuestion();

        textViewa1.setOnClickListener(v -> selectAnswer(0));
        textViewa2.setOnClickListener(v -> selectAnswer(1));
        textViewa3.setOnClickListener(v -> selectAnswer(2));
        textViewa4.setOnClickListener(v -> selectAnswer(3));
        materialButton.setOnClickListener(v -> checkAnswer());
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            textViewQuestion.setText(questions[currentQuestionIndex]);
            textViewa1.setText(answers[currentQuestionIndex][0]);
            textViewa2.setText(answers[currentQuestionIndex][1]);
            textViewa3.setText(answers[currentQuestionIndex][2]);
            textViewa4.setText(answers[currentQuestionIndex][3]);
            selectedAnswerIndex = -1;
            resetAnswerBackgrounds();
        } else {
            // Quiz finished, show score or end the quiz
            textViewQuestion.setText("Quiz finished! Your score: " + score);
            textViewa1.setVisibility(View.INVISIBLE);
            textViewa2.setVisibility(View.INVISIBLE);
            textViewa3.setVisibility(View.INVISIBLE);
            textViewa4.setVisibility(View.INVISIBLE);
            materialButton.setVisibility(View.INVISIBLE);
        }
    }

    private void selectAnswer(int index) {
        selectedAnswerIndex = index;
        resetAnswerBackgrounds();
        getTextViewByIndex(index).setBackgroundResource(R.drawable.rounded_rectangle_background5); // Highlight selected answer
    }

    private void resetAnswerBackgrounds() {
        for (TextView textView : answerTextViews) {
            textView.setBackgroundResource(R.drawable.rounded_rectangle_background3);
        }
    }

    private void checkAnswer() {
        if (selectedAnswerIndex == -1) return; // No answer selected

        if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
            score++;
            fadeInColor(getTextViewByIndex(selectedAnswerIndex), Color.GREEN);
        } else {
            fadeInColor(getTextViewByIndex(selectedAnswerIndex), Color.RED);
            fadeInColor(getTextViewByIndex(correctAnswers[currentQuestionIndex]), Color.GREEN);
        }

        currentQuestionIndex++;
        new Handler().postDelayed(this::loadQuestion, 1000); // Delay for 1 second before loading the next question
    }

    private TextView getTextViewByIndex(int index) {
        switch (index) {
            case 0: return textViewa1;
            case 1: return textViewa2;
            case 2: return textViewa3;
            case 3: return textViewa4;
            default: return null;
        }
    }

    private void fadeInColor(TextView textView, int color) {
        textView.setBackgroundColor(color);
        textView.animate().alpha(1.0f).setDuration(500).withEndAction(() -> textView.setAlpha(1.0f));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        MusicUtil.unpauseMusic();
        mediaPlayer.stop();
        mediaPlayer.release();
    }


}