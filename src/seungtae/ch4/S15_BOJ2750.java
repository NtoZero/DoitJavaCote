package seungtae.ch4;

// 수 정렬하기 : https://www.acmicpc.net/problem/2750

import java.util.Scanner;

public class S15_BOJ2750 {
    /*
        시간복잡도 N^2으로 풀어도 풀이가 가능하다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
//                swap(arr, arr[i],arr[j]);
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

//    public static void swap(int[] arr, int a, int b) {
//        int tmp = arr[a];
//        if(arr[a]>arr[b]) {
//            arr[a] = arr[b];
//            arr[b] = tmp;
//        }
//    }
}
