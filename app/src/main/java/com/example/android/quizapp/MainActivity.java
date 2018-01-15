package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctGuesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        countCorrectGuesses();
        CharSequence text = "You have " + correctGuesses + " correct guesses!" + "\nWell done!";
        if (correctGuesses == 0) {
            text = "Wow! You're not very good at this are you?!!!";
        } else if (correctGuesses == 1) {
            text = "You have only " + correctGuesses + " correct guess!" + "\nThis must be a hard quiz!";
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        resetQuiz();
    }

    private Boolean questionOneCorrectChoice() {
        final RadioButton answerC = (RadioButton) findViewById(R.id.q1_c);
        if (answerC.isChecked()) return true;
        else return false;
    }

    private void countCorrectGuesses() {

        if (questionOneCorrectChoice() == true) correctGuesses++;
    }

    public void resetQuiz () {
        correctGuesses = 0;
    }



}
