package com.almanbet11.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    TextView answerTextView;
    double answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent output = getIntent();
        answer = output.getDoubleExtra("answer", 0);

        displayAnswer(answer);
    }

    public void displayAnswer(double answer){

        makeEditors();

        if ((answer == Math.floor(answer)) && !Double.isInfinite(answer)) {
            answerTextView.setText(String.format("%d", (int) answer));
        }
        else{
            answerTextView.setText(String.format("%.2f", answer));
        }
    }

    private void makeEditors(){
        answerTextView = findViewById(R.id.answerNumber);
    }
}
