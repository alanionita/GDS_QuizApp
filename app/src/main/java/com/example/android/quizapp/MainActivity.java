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
        return false;
    }

    private Boolean questionTwoCorrectChoice() {
        final RadioButton answerB = (RadioButton) findViewById(R.id.q2_b);
        if (answerB.isChecked()) return true;
        return false;
    }

    private Boolean questionThreeCorrectChoice() {
        final RadioButton answerB = (RadioButton) findViewById(R.id.q3_b);
        if (answerB.isChecked()) return true;
        return false;
    }

    private Boolean questionFourCorrectChoice() {
        final RadioButton answerA = (RadioButton) findViewById(R.id.q4_a);
        if (answerA.isChecked()) return true;
        return false;
    }

    private Boolean questionFiveCorrectChoice() {
        final RadioButton answerA = (RadioButton) findViewById(R.id.q5_a);
        if (answerA.isChecked()) return true;
        return false;
    }

    private Boolean questionSixCorrectChoice() {
        final RadioButton answerB = (RadioButton) findViewById(R.id.q6_b);
        if (answerB.isChecked()) return true;
        return false;
    }
    private Boolean questionSevenCorrectChoice() {
        final RadioButton answerB = (RadioButton) findViewById(R.id.q7_b);
        if (answerB.isChecked()) return true;
        return false;
    }

    private void countCorrectGuesses() {

        if (questionOneCorrectChoice()) correctGuesses++;
        if (questionTwoCorrectChoice()) correctGuesses++;
        if (questionThreeCorrectChoice()) correctGuesses++;
        if (questionFourCorrectChoice()) correctGuesses++;
        if (questionFiveCorrectChoice()) correctGuesses++;
        if (questionSixCorrectChoice()) correctGuesses++;
        if (questionSevenCorrectChoice()) correctGuesses++;

    }

    public void resetQuiz () {
        correctGuesses = 0;
    }



}
