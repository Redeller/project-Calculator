package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String calculation = sc.nextLine();
        Logic l = new Logic();
        System.out.println(l.calculate(calculation));
    }
}
