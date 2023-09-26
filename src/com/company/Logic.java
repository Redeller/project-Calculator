package com.company;

public class Logic {
    public String calculate(String primer) {
        String[] arrayOfElements = primer.split(" ");
        int a = 0;
        int b = 0;
        int count = 0;
        try {
            a = Integer.parseInt(arrayOfElements[0]);
        }catch (NumberFormatException e){
            a = NumberConverter.romanToInt(arrayOfElements[0]);
            count++;
        }
        try {
            b = Integer.parseInt(arrayOfElements[2]);
        }catch (NumberFormatException e){
            b = NumberConverter.romanToInt(arrayOfElements[2]);
            count++;
        }
        int result = signs(arrayOfElements[1],a,b);
        if (count==2){
            return NumberConverter.intToRoman(result);
        }else {
        return String.valueOf(result);
        }
    }
    private int signs(String znak, int a, int b) {
        int result = 0;
        switch (znak) {
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
        }
        return result;
    }
}
