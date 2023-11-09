package juyeon.ch3;

import java.util.Scanner;

public class Q2_BOJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] score = new int[N];
        for( int i = 0; i < N; i++ ) {
            score[i] = sc.nextInt();
        }

        sc.close();

        int M = 0;
        double sum = 0;
        for( int i = 0; i < N; i++ ) {
            if( M <= score[i] ) {
                M = score[i];
            }
            sum += score[i];
        }

        System.out.println(sum / M * 100 / N);
    }
}
