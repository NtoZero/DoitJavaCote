package juyeon.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P38_1456;

import java.util.Scanner;

// 시간 초과 ❌❌❌
public class Q38_BOJ1456 implements P38_1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        int count = 0;

        for (long i = 2; i <= Math.sqrt(B); i++) {
            if (isPrime(i)) {
                long k = i;
                while (k <= B) {
                    k *= i;
                    if (k >= A && k <= B) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isPrime(long num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
