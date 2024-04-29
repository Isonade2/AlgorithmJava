package org.example.DataStructure;

import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int n = scanner.nextInt();
        String numbers = scanner.next();
        char[] charArray = numbers.toCharArray();

        for (char c : charArray) {
            sum += c-'0';

        }
        System.out.println(sum);

    }
}
