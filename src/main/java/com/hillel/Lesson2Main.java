package com.hillel;

import java.util.Scanner;

import com.hillel.lesson2.DivideOperation;
import com.hillel.lesson2.MultiplierOperation;
import com.hillel.lesson2.Operation;
import com.hillel.lesson2.SumOperation;

public class Lesson2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operationName = scanner.next();
        Operation operation = null;
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        switch (operationName) {
            case "+":
                operation = new SumOperation();
                break;
            case "*":
                operation = new MultiplierOperation();
                break;
            case "/":
                operation = new DivideOperation();
                break;
        }

        operation.setA(a);
        operation.setB(b);

        System.out.println(operation.execute());
    }
}