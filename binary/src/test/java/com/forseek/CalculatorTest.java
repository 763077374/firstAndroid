package com.forseek;

import com.forseek.logic.Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void initializeCalculator(){
        calculator = new Calculator();
    }
    @Test
    public void convertToBinarySuccess() throws Exception{
        assertThat(calculator.convertToBinary("12wwll"),is("100000000"));
    }
    @Test
    public void convertToBinaryFail() throws Exception{
        assertThat(calculator.convertToBinary("12wwll"),is("Invalid input"));
    }
    @Test
    public void  convertrToDecimalSuccess() throws  Exception {
        assertThat(calculator.convertrToDecimal("1111"),is("15"));
    }
    @Test
    public void  convertrToDecimalFail() throws  Exception {
        assertThat(calculator.convertrToDecimal("1111"),is("Invalid input"));
    }


}
