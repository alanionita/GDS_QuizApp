package com.example.android.quizapp;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by alanionita on 04/02/2018.
 */

public class ResultsModal extends DialogFragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.results_modal, container, false);
        getDialog().setTitle("Results of the quiz!");
        TextView correctAnswers = view.findViewById(R.id.guess);
        int correctGuesses = ((MainActivity)getActivity()).countCorrectGuesses();
        Log.i("correct guesses", String.valueOf(correctGuesses));
        correctAnswers.setText(String.valueOf(correctGuesses));
        return view;
    }

}

