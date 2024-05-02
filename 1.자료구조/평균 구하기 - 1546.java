package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        double max = Arrays.stream(arr).max().getAsDouble();
        double sum = Arrays.stream(arr).sum();
        sum = sum/max* 100;

        System.out.println(sum/n);
    }
}