package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] sum = new int[N];
        for (int i = 0; i< N; i++){
            arr[i] = sc.nextInt();
            if(i == 0){
                sum[i] = arr[i];
                continue;
            }
            sum[i] += sum[i-1] + arr[i];
        }

        for (int i =0; i<M; i++){
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            if(start == 0){
                System.out.println(sum[end]);
            }
            else{
                System.out.println(sum[end]-sum[start-1]);
            }
        }
    }
}