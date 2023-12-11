package juyeon.ch7;

import java.util.Scanner;

// 시간 초과
public class P41_11689_오일러_피_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        int count = 0;

        for (long i = 1; i <= n; i++) {
            if (isGcd(n, i) == 1) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static long isGcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return isGcd(b, a % b);
    }

}
