package com.frfphlapp.calculator;

import android.widget.Button;

public class CalculatorController {

    private CalculatorModel mCalculatorModel;

    public CalculatorController() {
        mCalculatorModel = new CalculatorModel();
    }

    public void addNum1(double num){
        mCalculatorModel.setNum1(num);
    }

    public void addNum2(double num){
        mCalculatorModel.setNum2(num);
    }

    public void reset(){
        mCalculatorModel = new CalculatorModel();
    }

    public double getResult() {
        return mCalculatorModel.getResult();
    }

    public double calculate(int button){
        switch (button){
            case R.id.ButtonAdd : mCalculatorModel.setResult(mCalculatorModel.getNum1() + mCalculatorModel.getNum2());
                break;
            case R.id.ButtonSubtract: mCalculatorModel.setResult(mCalculatorModel.getNum1() - mCalculatorModel.getNum2());
                break;
            case R.id.ButtonMultiply: mCalculatorModel.setResult(mCalculatorModel.getNum1() * mCalculatorModel.getNum2());
                break;
            case R.id.ButtonDivide: mCalculatorModel.setResult(mCalculatorModel.getNum1() / mCalculatorModel.getNum2());
                break;
            case R.id.ButtonMOD: mCalculatorModel.setResult(mCalculatorModel.getNum1() % mCalculatorModel.getNum2());
                break;
        }

        return mCalculatorModel.getResult();
    }


}
