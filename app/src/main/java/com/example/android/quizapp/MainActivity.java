package com.example.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Stores the amount of correct guesses made by a user
    private int correctGuesses;

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
        // Count the results
        countCorrectGuesses();

        // Define toast params
        Context context = getApplicationContext();
        String toastMessageFormat = "";

        // Change message depending on the quiz results
        if (correctGuesses > 1) {
            toastMessageFormat = getResources().getString(R.string.toast_message_plural);
        } else if (correctGuesses == 1) {
            toastMessageFormat = getResources().getString(R.string.toast_message_singular);
        } else {
            toastMessageFormat = getResources().getString(R.string.toast_message_none);
        }

        String toastMessage = String.format(toastMessageFormat, correctGuesses);
        int duration = Toast.LENGTH_SHORT;

        // Create toast
        Toast toast = Toast.makeText(context, toastMessage, duration);

        // Create ResultsModal
        ResultsModal modal = new ResultsModal();

        // Show the new view: Modal, Toast
        modal.show(getFragmentManager(), "dialog");
        toast.show();

        // reset the score via resetQuiz()
        resetQuiz();
    }

    private Boolean questionOneCorrectChoice() {
        final RadioButton correctAnswer = findViewById(R.id.q1_c);
        return correctAnswer.isChecked();
    }

    private Boolean questionTwoCorrectChoice() {
        final RadioButton correctAnswer = findViewById(R.id.q2_b);
        return correctAnswer.isChecked();
    }

    private Boolean questionThreeCorrectChoice() {
        EditText q3EditText = (EditText)findViewById(R.id.q3_enter_answer);
        String enteredAnswer = (String) q3EditText.getText().toString();
        String correctAnswer = (String) "No";
        return correctAnswer.equals(enteredAnswer);
    }

    private Boolean questionFourCorrectChoice() {
        final RadioButton correctAnswer = findViewById(R.id.q4_a);
        return correctAnswer.isChecked();
    }

    private Boolean questionFiveCorrectChoice() {
        final RadioButton correctAnswer = findViewById(R.id.q5_a);
        return correctAnswer.isChecked();
    }

    private Boolean questionSixCorrectChoice() {
        final RadioButton correctAnswer = findViewById(R.id.q6_b);
        return correctAnswer.isChecked();
    }
    private Boolean questionSevenCorrectChoice() {
        final RadioButton correctAnswer = findViewById(R.id.q7_b);
        return correctAnswer.isChecked();
    }

    private Boolean questionEightCorrectChoices() {
        Boolean result = false;
        final CheckBox answerA = findViewById(R.id.q8_a);
        final CheckBox answerB = findViewById(R.id.q8_b);
        final CheckBox answerC = findViewById(R.id.q8_c);
        final CheckBox answerD = findViewById(R.id.q8_d);
        final CheckBox answerE = findViewById(R.id.q8_e);
        final CheckBox answerF = findViewById(R.id.q8_f);
        final CheckBox answerG = findViewById(R.id.q8_g);
        if (answerA.isChecked() && answerB.isChecked() && answerC.isChecked() && answerD.isChecked() && answerE.isChecked() && answerF.isChecked()) {
            result = true;
        }
        return result;
    }

    public int  countCorrectGuesses() {
        if (questionOneCorrectChoice()) correctGuesses++;
        if (questionTwoCorrectChoice()) correctGuesses++;
        if (questionFourCorrectChoice()) correctGuesses++;
        if (questionFiveCorrectChoice()) correctGuesses++;
        if (questionSixCorrectChoice()) correctGuesses++;
        if (questionSevenCorrectChoice()) correctGuesses++;
        if (questionEightCorrectChoices()) correctGuesses++;
        if (questionThreeCorrectChoice()) correctGuesses++;
        Log.i("question3", questionThreeCorrectChoice().toString());

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
