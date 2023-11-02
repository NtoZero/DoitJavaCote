package juyeon.ch5;

import _problems.ch5_searching.ch5_1_dfs.P24_2023;

import java.util.Scanner;

public class Q24_BOJ2023 implements P24_2023 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }

    // n 이 자리수
    private static void DFS(int A, int n) {
        if (n == N) {
            if (isPrime(A)) {
                System.out.println(A);
            }
            return;
        }

        // 다음 자리수 반복
        for (int i = 1; i < 10; i++) {
            // 짝수는 할 필요 없음
            if (i % 2 == 0) continue;

            if (isPrime(A*10 + i)) {
                DFS(A*10 + i, n+1);
            }
        }
    }

    // 소수 판별
    private static boolean isPrime(int num) {
//        위에서 걸러짐
//        if (num <= 1) return false;

        // 제곱근 까지만 확인하면 됨
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
