package com.frfphlapp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculatorView extends AppCompatActivity {

    private CalculatorController mCalculatorController;
    private TextView mTextView1;
    private TextView mTextView2;

    private int operationID;
    private double currentNumber = Double.NaN;
    private String numberDisplay = "";
    private boolean operationClick = false;


    Button dot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_model);

        mCalculatorController = new CalculatorController();
        mTextView1 = findViewById(R.id.upperTextView);
        mTextView2 = findViewById(R.id.lowerTextView);
        dot = findViewById(R.id.buttonDot);

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay = numberDisplay +".";
                Display();
                dot.setEnabled(false);
            }
        });
    }

    public void onEqualsClick(View view){
        mCalculatorController.addNum2(currentNumber);
        mTextView2.setText(""+mCalculatorController.calculate(operationID));
    }


    public  void onOperationClick(View view){
        operationID = view.getId();
        if(currentNumber != Double.NaN) operationClick = true;

    }

    public void onClick(View view){
        dot.setEnabled(true);

        if(operationClick){
            mCalculatorController.addNum1(currentNumber);
            numberDisplay = "";
            currentNumber = Double.NaN;
            mTextView1.setText("0");
            operationClick = false;
        }

        switch (view.getId()){
            case R.id.Button0: numberDisplay += "0";
                break;
            case R.id.button1: numberDisplay += "1";
                break;
            case R.id.button2: numberDisplay += "2";
                break;
            case R.id.button3: numberDisplay += "3";
                break;
            case R.id.button4: numberDisplay += "4";
                break;
            case R.id.button5: numberDisplay += "5";
                break;
            case R.id.button6: numberDisplay += "6";
                break;
            case R.id.button7: numberDisplay += "7";
                break;
            case R.id.button8: numberDisplay += "8";
                break;
            case R.id.button9: numberDisplay += "9";
                break;

            case R.id.Plus_minus_Sign :

                if(numberDisplay.charAt(0) != '-'){
                    numberDisplay = "-" + numberDisplay;

                }else {
                    numberDisplay = numberDisplay.substring(1);

                }

                break;
        }
        Display();
    }

    public void Display(){

        try {
            currentNumber = Double.parseDouble(numberDisplay);
            mTextView1.setText(numberDisplay);


        }catch (Exception e){

        }
    }
    public void onClear(View view){
        numberDisplay = "";
        currentNumber = Double.NaN;
        mCalculatorController.reset();
        mTextView1.setText("0");
        mTextView2.setText("");

    }



}
