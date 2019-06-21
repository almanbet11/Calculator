package com.almanbet11.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1EditText;
    EditText number2EditText;
    TextView signTextView;

    double firstNumber ;
    double secondNumber ;
    String sign = "";

    double answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeEditors();

        if (savedInstanceState != null){
            signTextView.setText(savedInstanceState.getString("sign"));
            sign = savedInstanceState.getString("sign");
        }

    }

    //methods for making a sign on the screen appear
    public void makePlus(View view){
        sign = "+";

        displaySign(sign);
    }

    public void makeMinus(View view){
        sign = "-";

        displaySign(sign);
    }

    public void makeMultiplication(View view){
        sign = "*";

        displaySign(sign);
    }

    public void makeDivision(View view){
        sign = "/";

        displaySign(sign);
    }

    private void displaySign(String sign) {
        TextView signTextView = findViewById(R.id.sign);
        signTextView.setText(sign);
    }

    private void makeEditors(){
        number1EditText = findViewById(R.id.firstNumber);
        number2EditText = findViewById(R.id.secondNumber);
        signTextView = findViewById(R.id.sign);
    }


    //this method is for switching to output activity
    public void openOutputActivity(View view){
        makeEditors();
        Intent output = new Intent(this, OutputActivity.class);

        if (number1EditText.getText().toString().isEmpty() == true ||
            number2EditText.getText().toString().isEmpty() == true ||
            signTextView.getText().toString().isEmpty() == true){
            Toast.makeText(getApplicationContext(), "Check out if every field is filled!", Toast.LENGTH_LONG).show();
        }

        else if (Double.parseDouble(number2EditText.getText().toString()) == 0 && signTextView.getText().toString() == "/"){
            Toast.makeText(getApplicationContext(), "No division by ZERO!", Toast.LENGTH_LONG).show();
        }

        else{
            startActivity(output);
        }

    }


    //this method is for clearing everything from the screen
    public void clearEverything(View view){
        makeEditors();

        number1EditText.setText("");
        number2EditText.setText("");
        signTextView.setText("");


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sign", sign);
    }
}
