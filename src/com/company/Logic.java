package com.company;

public class Logic {
    public String calculate(String primer) throws Exception {
        String[] arrayOfElements = primer.split(" ");
        int a = 0;
        int b = 0;
        int count = 0;
        if (arrayOfElements.length == 1){
            throw new Exception("строка не является математической операцией");
        }else if (arrayOfElements.length > 3){
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
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
        if(result < 0){
            throw new Exception("в римской системе нет отрицательных чисел");
        }

        if (count==2){
            return NumberConverter.intToRoman(result);

        }else if(count == 0){
        return String.valueOf(result);
        }

        throw new Exception("используются одновременно разные системы счисления");
    }
    private int signs(String znak, int a, int b) throws Exception {
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
            default: throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        return result;
    }
}
