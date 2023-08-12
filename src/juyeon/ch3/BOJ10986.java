package juyeon.ch3;

import java.util.Scanner;

public class BOJ10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        long[] A = new long[N];
        for( int i = 0; i < N; i++ ) {
            A[i] = sc.nextInt();
        }

        long[] S = new long[N];
        for( int i = 1; i <= N; i++ ) {
            S[0] = A[0];
            S[i] = S[i-1] + A[i];
        }

        long[] SM = new long[N];
        for( int i = 0; i < N; i++ ) {
            SM[i] = S[i] % M;
            if( SM[i] == 0 ) count++;
        }


    }
}
