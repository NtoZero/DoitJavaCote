package juyeon.ch4;

import java.util.*;

// https://www.acmicpc.net/problem/2750
public class Q15_BOJ2750 {
    public static void main(String[] args) {

//        1. Arrays.sort() 로 짱 쉽게 풀기
//
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//
//        int[] arr = new int[N];
//        for( int i = 0; i < N; i++ ) {
//            arr[i] = sc.nextInt();
//        }
//
//        Arrays.sort(arr);
//
//        for( int i = 0; i < N; i++ ) {
//            System.out.println(arr[i]);
//        }


//        2. 우선순위 큐로 풀기
//
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//
//        PriorityQueue<Integer> Q = new PriorityQueue<>();
//
//        for(int i = 0; i < N; i++ ) {
//            Q.add(sc.nextInt());
//        }
//
//        for( int i = 0; i < N; i++ ) {
//            System.out.println(Q.poll());
//        }


        // 3. 버블 정렬로 풀기
        // 버블 정렬은 O(n^2) 인데, 해당 문제 최대 범위가 1,000 이라서 가능

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for( int i = 0; i < N; i++ ) {
            arr[i] = sc.nextInt();
        }

        for( int i = 0; i < N - 1; i++ ) {
            for( int j = 0; j < N - 1 - i; j++ ) {
                if( arr[j] > arr[j+1] ) {
                    int k = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = k;
                }
            }
        }

        for( int i = 0; i < N; i++ ) {
            System.out.println(arr[i]);
        }
    }
}
