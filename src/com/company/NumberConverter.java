package com.company;

import java.util.HashMap;

public class NumberConverter {
    public static String intToRoman(int num) {
        String[] keys = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int vals[] = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        while (count < keys.length) {
            for (int i = 0; i < vals.length; i++) {
                if (num >= vals[i]) {
                    int d = num / vals[i];
                    num = num % vals[i];
                    for(int j=0; j<d; j++) {
                        stringBuilder.append(keys[i]);
                    }
                }
            }
            count++;
        }
        return stringBuilder.toString();
    }
    public static int romanToInt(String s) {

        if (s == null || s.length() == 0)
            return -1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }


        return result;
    }
}
