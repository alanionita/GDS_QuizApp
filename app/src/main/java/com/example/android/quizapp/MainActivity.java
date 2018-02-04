package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int correctGuesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        ResultsModal modal = new ResultsModal();
        modal.show(getFragmentManager(), "dialog");
        countCorrectGuesses();
        resetQuiz();
//        CharSequence text = "You have " + correctGuesses + " correct guesses!" + "\nWell done!";
//        if (correctGuesses == 0) {
//            text = "Wow! You're not very good at this are you?!!!";
//        } else if (correctGuesses == 1) {
//            text = "You have only " + correctGuesses + " correct guess!" + "\nThis must be a hard quiz!";
//        }
//        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();
    }

    private Boolean questionOneCorrectChoice() {
        final RadioButton answerC = findViewById(R.id.q1_c);
        return answerC.isChecked();
    }

    private Boolean questionTwoCorrectChoice() {
        final RadioButton answerB = findViewById(R.id.q2_b);
        return answerB.isChecked();
    }

    private Boolean questionThreeCorrectChoice() {
        final RadioButton answerB = findViewById(R.id.q3_b);
        return answerB.isChecked();
    }

    private Boolean questionFourCorrectChoice() {
        final RadioButton answerA = findViewById(R.id.q4_a);
        return answerA.isChecked();
    }

    private Boolean questionFiveCorrectChoice() {
        final RadioButton answerA = findViewById(R.id.q5_a);
        return answerA.isChecked();
    }

    private Boolean questionSixCorrectChoice() {
        final RadioButton answerB = findViewById(R.id.q6_b);
        return answerB.isChecked();
    }
    private Boolean questionSevenCorrectChoice() {
        final RadioButton answerB = findViewById(R.id.q7_b);
        return answerB.isChecked();
    }

    public int  countCorrectGuesses() {

        if (questionOneCorrectChoice()) correctGuesses++;
        if (questionTwoCorrectChoice()) correctGuesses++;
        if (questionThreeCorrectChoice()) correctGuesses++;
        if (questionFourCorrectChoice()) correctGuesses++;
        if (questionFiveCorrectChoice()) correctGuesses++;
        if (questionSixCorrectChoice()) correctGuesses++;
        if (questionSevenCorrectChoice()) correctGuesses++;

        return correctGuesses;
    }

    public void resetQuiz () {
        correctGuesses = 0;
    }

    public void onAnswersButtonClick (View answers) {
        if (answers.getId() == R.id.answers) {
            Intent i = new Intent(MainActivity.this, Answers.class);
            startActivity(i);
        }
    }
}
