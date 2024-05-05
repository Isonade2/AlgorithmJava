package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long S = Long.parseLong(st.nextToken());

        long sum = 0;
        long count = 0;
        for(long i = 1; i<= S; i++){
            sum += i;
            count++;
            if (sum > S){
                count--;
                break;
            }
            else if(sum == S){
                break;
            }

        }
        System.out.println(count);
    }
}
