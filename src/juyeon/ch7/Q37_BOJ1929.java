package juyeon.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P37_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q37_BOJ1929 implements P37_1929 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//
//        int M = sc.nextInt();
//        int N = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
