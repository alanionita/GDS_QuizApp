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
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by alanionita on 04/02/2018.
 */

public class ResultsModal extends DialogFragment {
    public Button answersButton;
    public Button backToQuiz;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View resultsView = inflater.inflate(R.layout.results_modal, container, false);
        answersButton = resultsView.findViewById(R.id.answers_button);
        backToQuiz = resultsView.findViewById(R.id.back_to_quiz_button);
        getDialog().setTitle("Results of the quiz!");

        answersButton.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {
            Intent i = new Intent(ResultsModal.this.getActivity(), Answers.class);
            startActivity(i);
        }
        });

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

