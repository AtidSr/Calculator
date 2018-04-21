package com.frfphlapp.calculator;

public class CalculatorController {

    private Calculator mCalculator;

    public CalculatorController() {
        mCalculator = new Calculator();
    }

    public void addNum1(double num){
        mCalculator.setNum1(num);
    }

    public void addNum2(double num){
        mCalculator.setNum2(num);
    }

    public void reset(){
        mCalculator = new Calculator();
    }

    public double getResult() {
        return mCalculator.getResult();
    }

    public double calculate(int button){
        switch (button){
            case R.id.ButtonAdd : mCalculator.setResult(mCalculator.getNum1() + mCalculator.getNum2());
                break;
            case R.id.ButtonSubtract: mCalculator.setResult(mCalculator.getNum1() - mCalculator.getNum2());
                break;
            case R.id.ButtonMultiply: mCalculator.setResult(mCalculator.getNum1() * mCalculator.getNum2());
                break;
            case R.id.ButtonDivide: mCalculator.setResult(mCalculator.getNum1() / mCalculator.getNum2());
                break;
            case R.id.ButtonMOD: mCalculator.setResult(mCalculator.getNum1() % mCalculator.getNum2());
                break;
        }

        return mCalculator.getResult();
    }


}
