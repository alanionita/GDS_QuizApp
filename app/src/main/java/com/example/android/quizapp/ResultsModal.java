package com.example.android.quizapp;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by alanionita on 04/02/2018.
 */

public class ResultsModal extends DialogFragment {
    public Button answersButton;
    public Button backToQuiz;
    public String nameEntered;
    public TextView introText;
    public String resourceText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View resultsView = inflater.inflate(R.layout.results_modal, container, false);
        getDialog().setTitle("Results of the quiz!");

        // gets intro text from the modal
        introText = resultsView.findViewById(R.id.intro);

        // references the nameField from main activity
        EditText nameField = (EditText) ((MainActivity)getActivity()).findViewById(R.id.enter_name);

        // gets the entered value
        nameEntered = (String) nameField.getText().toString();

        // gets the resource value for the modal intro text and passes as param the entered name
        resourceText = (String) getString(R.string.modal_main_text, nameField.getText().toString());

        // sets the new intro text to the new value
        introText.setText(resourceText);

        // gets the answer button and sets a listener that points to the answers view
        answersButton = resultsView.findViewById(R.id.answers_button);
        answersButton.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {
            Intent i = new Intent(ResultsModal.this.getActivity(), Answers.class);
            startActivity(i);
        }
        });

        // gets the back button and sets a listener that leads back to the quiz
        backToQuiz = resultsView.findViewById(R.id.back_to_quiz_button);
        backToQuiz.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {
            Intent i = new Intent(ResultsModal.this.getActivity(), MainActivity.class);
            startActivity(i);
        }
        });

        TextView correctAnswers = resultsView.findViewById(R.id.guess);
        int correctGuesses = ((MainActivity)getActivity()).countCorrectGuesses();
        Log.i("correct guesses", String.valueOf(correctGuesses));
        correctAnswers.setText(String.valueOf(correctGuesses));
        return resultsView;
    }
}

