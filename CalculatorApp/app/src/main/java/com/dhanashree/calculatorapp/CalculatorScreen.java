package com.dhanashree.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class CalculatorScreen extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText mInput;
    TextView mResult;
    Button mClear, mSeven, mEight, mNine,mMul, mFour, mFive, mSix, mSub, mOne, mTwo, mThree, mAdd, mDot, mZero, mEqual, mDivide;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }
    //initialize components
    private void initComponent() {
        decimalFormat = new DecimalFormat("#.##########");

        mInput = findViewById(R.id.edtInput);
        mResult = findViewById(R.id.txtResult);
        mClear = findViewById(R.id.btnClear);
        mSeven = findViewById(R.id.btnSeven);
        mEight = findViewById(R.id.btnEight);
        mNine = findViewById(R.id.btnNine);
        mMul = findViewById(R.id.btnMul);
        mFour = findViewById(R.id.btnFour);
        mFive = findViewById(R.id.btnFive);
        mSix = findViewById(R.id.btnSix);
        mSub = findViewById(R.id.btnMinus);
        mOne = findViewById(R.id.btnOne);
        mTwo = findViewById(R.id.btnTwo);
        mThree = findViewById(R.id.btnThree);
        mAdd = findViewById(R.id.btnAdd);
        mDot = findViewById(R.id.btnDot);
        mZero = findViewById(R.id.btnZero);
        mEqual = findViewById(R.id.btnEqual);
        mDivide = findViewById(R.id.btnDivide);

        mDot.setOnClickListener(this);
        mZero.setOnClickListener(this);
        mOne.setOnClickListener(this);
        mTwo.setOnClickListener(this);
        mThree.setOnClickListener(this);
        mFour.setOnClickListener(this);
        mFive.setOnClickListener(this);
        mSix.setOnClickListener(this);
        mSeven.setOnClickListener(this);
        mEight.setOnClickListener(this);
        mNine.setOnClickListener(this);

        mAdd.setOnClickListener(this);
        mSub.setOnClickListener(this);
        mMul.setOnClickListener(this);
        mDivide.setOnClickListener(this);

        mClear.setOnClickListener(this);
        mEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnDot:
                mInput.setText(mInput.getText() + ".");
                break;

            case R.id.btnZero:
                mInput.setText(mInput.getText() + "0");
                break;
            case R.id.btnOne:
                mInput.setText(mInput.getText() + "1");
                break;
            case R.id.btnTwo:
                mInput.setText(mInput.getText() + "2");
                break;
            case R.id.btnThree:
                mInput.setText(mInput.getText() + "3");
                break;
            case R.id.btnFour:
                mInput.setText(mInput.getText() + "4");
                break;
            case R.id.btnFive:
                mInput.setText(mInput.getText() + "5");
                break;
            case R.id.btnSix:
                mInput.setText(mInput.getText() + "6");
                break;
            case R.id.btnSeven:
                mInput.setText(mInput.getText() + "7");
                break;
            case R.id.btnEight:
                mInput.setText(mInput.getText() + "8");
                break;
            case R.id.btnNine:
                mInput.setText(mInput.getText() + "9");
                break;

            case R.id.btnAdd:
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                mResult.setText(decimalFormat.format(valueOne) + "+");
                mInput.setText(null);
                break;
            case R.id.btnMinus:
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                mResult.setText(decimalFormat.format(valueOne) + "-");
                mInput.setText(null);
                break;
            case R.id.btnMul:
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                mResult.setText(decimalFormat.format(valueOne) + "*");
                mInput.setText(null);
                break;
            case R.id.btnDivide:
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                mResult.setText(decimalFormat.format(valueOne) + "/");
                mInput.setText(null);
                break;

            case R.id.btnClear:
                clearData();
                break;
            case R.id.btnEqual:
                calculateEqual();
                break;
        }
    }
    //clear data
    private void clearData() {
        if(mInput.getText().length() > 0) {
            CharSequence currentText = mInput.getText();
            mInput.setText(currentText.subSequence(0, currentText.length()-1));
        }
        else {
            valueOne = Double.NaN;
            valueTwo = Double.NaN;
            mInput.setText("");
            mResult.setText("");
        }
    }
    //equal
    @SuppressLint("SetTextI18n")
    private void calculateEqual() {
        computeCalculation();
        mResult.setText(mResult.getText().toString() +
                decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
        valueOne = Double.NaN;
        CURRENT_ACTION = '0';
    }
    //calculate result
    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(mInput.getText().toString());
            mInput.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(mInput.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
