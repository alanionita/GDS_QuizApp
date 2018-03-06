package com.example.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int correctGuesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Targets the editTextView
        EditText targetEditText = (EditText)findViewById(R.id.enter_name);

        // Sets an onClick Listener to the EditText
        targetEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        // Hide keyboard
                        hideSoftKeyboard(MainActivity.this);

                        // Clear view focus
                        v.clearFocus();

                        // Request focus from the parent view
                        CardView leadingCard = (CardView)findViewById(R.id.leading_card);
                        leadingCard.requestFocus();
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    // Method for hiding the soft keyboard, mostly used on the leading EditText
    public static void hideSoftKeyboard(Activity activity) {
        if (activity == null) return;
        if (activity.getCurrentFocus() == null) return;

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void submitAnswers(View view) {
        ResultsModal modal = new ResultsModal();
        modal.show(getFragmentManager(), "dialog");
        countCorrectGuesses();
        resetQuiz();
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

    private Boolean questionEightCorrectChoices() {
        final CheckBox answerG = findViewById(R.id.q8_g);
        return answerG.isChecked();
    }

    public int  countCorrectGuesses() {
        if (questionOneCorrectChoice()) correctGuesses++;
        if (questionTwoCorrectChoice()) correctGuesses++;
        if (questionThreeCorrectChoice()) correctGuesses++;
        if (questionFourCorrectChoice()) correctGuesses++;
        if (questionFiveCorrectChoice()) correctGuesses++;
        if (questionSixCorrectChoice()) correctGuesses++;
        if (questionSevenCorrectChoice()) correctGuesses++;
        if (!questionEightCorrectChoices()) correctGuesses++;

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
