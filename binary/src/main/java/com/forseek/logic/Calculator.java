package com.forseek.logic;

public class Calculator {

    History history=new HistoryImpl();

    public String convertToBinary (String decimal){
        history.add(decimal);
        try{
            return Long.toBinaryString(Integer.parseInt(decimal));
        }catch (Exception e){
            return "Invalid input";
       }
    }

    public String convertrToDecimal(String binary){
        history.add(binary);
        try {
            return String.valueOf(Integer.parseInt(binary, 2));
        }catch (Exception e){
            return "Invalid input";
        }
    }
}
