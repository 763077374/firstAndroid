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

public class BinaryFragment extends Fragment implements CalculaterFragment{

    private EditText binaryNumber;
    private TextView decimalResult;
    private Calculator calculator;

    public BinaryFragment() {}

    public static BinaryFragment newInstance() {
        BinaryFragment fragment = new BinaryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_binary, container, false);
        binaryNumber= (EditText) v.findViewById(R.id.binaryNumberEditText);
        decimalResult = (TextView) v.findViewById(R.id.decimalResultText);
        calculator=new Calculator();

        return v;
    }

    @Override
    public void performCalculation() {
        decimalResult.setText(calculator.convertrToDecimal(binaryNumber.getText().toString()));
    }

}
