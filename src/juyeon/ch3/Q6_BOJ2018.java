package juyeon.ch3;

import java.util.Scanner;

public class Q6_BOJ2018 {  // 투 포인터
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while( end < N ) {
            if( sum < N ) {
                end++;
                sum += end;
            } else if( sum > N ) {
                sum -= start;
                start++;
            } else if( sum == N ) {
                count++;
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}
