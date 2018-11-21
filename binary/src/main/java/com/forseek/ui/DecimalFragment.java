package com.forseek.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.forseek.R;
import com.forseek.logic.Calculator;


public class DecimalFragment extends Fragment implements CalculaterFragment{

    private EditText decimalNumber;
    private TextView binaryResult;
    private Calculator calculator;

    public DecimalFragment() {}

    public static DecimalFragment newInstance() {
        DecimalFragment fragment = new DecimalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_decimal, container, false);
        decimalNumber= (EditText) v.findViewById(R.id.decimalNumberEditText);
        binaryResult = (TextView) v.findViewById(R.id.binaryResultText);
        calculator=new Calculator();

        return v;
    }

    @Override
    public void performCalculation() {
        binaryResult.setText(calculator.convertToBinary(decimalNumber.getText().toString()));
    }
}


