package juyeon.ch3;

import java.util.Scanner;

public class Q3_BOJ11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

//        int[] A = new int[N+1];     // 문제 풀려면 index 0 은 비워두고 해야
//        for( int i = 1; i <= N; i++ ) {
////            A[0] = 0;
//            A[i] = sc.nextInt();
//        }
//
//        int[] S = new int[N+1];
////        S[0] = A[0];
//        for( int i = 1; i <= N; i++ ) {
//            S[i] = S[i-1] + A[i];
//        }

        int[] S = new int[N+1];
        for( int i = 1; i <= N; i++ ) {
            S[0] = 0;
            S[i] = S[i-1] + sc.nextInt();
        }


        for( int i = 0; i < M; i++ ){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(S[b] - S[a-1]);
        }
    }
}
