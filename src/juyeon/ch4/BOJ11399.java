package juyeon.ch4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        for( int i = 1; i <= N; i++ ) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] brr = new int[N+1];
        for( int i = 0; i < N; i++ ) {
            brr[1] = arr[1];
            brr[i+1] = brr[i] + arr[i+1];
        }


        int sum = 0;
        for( int i = 1; i <= N; i++ ) {
            sum += brr[i];
        }

        System.out.println(sum);
    }
}
