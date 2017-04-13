package com.example.android.financialquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int answerCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getResult(View view) {

        EditText editText = (EditText) findViewById(R.id.input);
        String keyboardAnswer = editText.getText().toString();
        boolean inputAnswer;

        if (keyboardAnswer.equalsIgnoreCase("Initial Public Offering")) inputAnswer = true;
        else inputAnswer = false;




        RadioButton radioButton1 = (RadioButton) findViewById(R.id.a_answer);
        boolean isAnswerA = radioButton1.isChecked();

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.b_answer);
        boolean isAnswerB = radioButton2.isChecked();

        RadioButton radioButton3 = (RadioButton) findViewById(R.id.c_answer);
        boolean isAnswerC = radioButton3.isChecked();

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.first_checkbox);
        boolean isFirtsAnswer = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.second_checkbox);
        boolean isSecondAnswer = checkBox2.isChecked();

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.third_checkbox);
        boolean isThirdAnswer = checkBox3.isChecked();

        RadioButton radioButton4 = (RadioButton) findViewById(R.id.currency_swap);
        boolean currencySwap = radioButton4.isChecked();

        RadioButton radioButton5 = (RadioButton) findViewById(R.id.indexed_swap);
        boolean indexedSwap = radioButton5.isChecked();

        RadioButton radioButton6 = (RadioButton) findViewById(R.id.interest_rate_swap);
        boolean interestRateSwap = radioButton6.isChecked();

        int score = calculateAnswers(inputAnswer, isAnswerA,isAnswerB,isAnswerC,isFirtsAnswer,isSecondAnswer,isThirdAnswer,currencySwap, indexedSwap,interestRateSwap);


        String message = scoreSummary(score);
        displayMessage(message);

        if (score >= 3){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_SHORT);
            toast1.show();
        }else if (score == 2){
            Toast toast2 = Toast.makeText(getApplicationContext(), "Not bad", Toast.LENGTH_SHORT);
            toast2.show();
        }else {
            Toast toast3 = Toast.makeText(getApplicationContext(),"Next time will be better", Toast.LENGTH_SHORT);
            toast3.show();
        }

    }

private int calculateAnswers(boolean inputAnswer, boolean isAnswerA, boolean isAnswerB, boolean isAnswerC, boolean isFirtsAnswer, boolean isSecondAnswer, boolean isThirdAnswer, boolean currencySwap,
boolean indexedSwap, boolean  interestRateSwap){
    if (isAnswerA && isFirtsAnswer && isThirdAnswer && interestRateSwap && inputAnswer && !isSecondAnswer){
        answerCounter = 4;
    }else if (isAnswerA && isFirtsAnswer && isThirdAnswer && interestRateSwap && !isSecondAnswer){
        answerCounter = 3;
    }else if (isAnswerA && isFirtsAnswer && isThirdAnswer && inputAnswer && !isSecondAnswer){
        answerCounter = 3;
    }else if (isFirtsAnswer && isThirdAnswer && interestRateSwap && inputAnswer && !isSecondAnswer){
        answerCounter = 3;
    }else if (isAnswerA && interestRateSwap && inputAnswer){
        answerCounter = 3;
    }else if (isAnswerA && inputAnswer){
        answerCounter = 2;
    }else if (isAnswerA && interestRateSwap){
        answerCounter = 2;
    }else if (isAnswerA && isFirtsAnswer && isThirdAnswer && !isSecondAnswer){
        answerCounter = 2;
    }else if (isFirtsAnswer && isThirdAnswer && interestRateSwap && !isSecondAnswer){
        answerCounter = 2;
    }else if (isFirtsAnswer && isThirdAnswer && inputAnswer && !isSecondAnswer){
        answerCounter = 2;
    }else if (interestRateSwap && inputAnswer){
        answerCounter = 2;
    }else if (isAnswerA){
        answerCounter = 1;
    }else if (isFirtsAnswer && isThirdAnswer && !isSecondAnswer){
        answerCounter = 1;
    }else if (interestRateSwap){
        answerCounter = 1;
    }else if (inputAnswer){
        answerCounter = 1;
    }else {
        answerCounter = 0;
    }
    return answerCounter;
}

    private String scoreSummary(int score){
        String message = "Your score is " + score;
        return message;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.score_summary);
        orderSummaryTextView.setText(message);
    }




}
