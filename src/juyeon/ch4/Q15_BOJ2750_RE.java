package juyeon.ch4;

import _problems.ch4.ch4_arrays.P15_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15_BOJ2750_RE implements P15_2750 {
    public static void main(String[] args) throws IOException {

        // (1) Arrays.sort 로 짱 쉽게 풀기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i]);
//        }

        // (2) 우선순위 큐로 풀기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//
//        for (int i = 0; i < N; i++) {
//            q.add(Integer.parseInt(br.readLine()));
//        }
//
//        for (int i = 0; i < N; i++) {
//            System.out.println(q.poll());
//        }

        // (3) 버블 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int k = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = k;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}


// 5
// 5
// 2
// 3
// 4
// 1