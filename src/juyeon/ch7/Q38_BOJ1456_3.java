package juyeon.ch7;

import java.util.Arrays;
import java.util.Scanner;

public class Q38_BOJ1456_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        boolean[] isPrime = new boolean[(int)Math.sqrt(B) + 1];

        Arrays.fill(isPrime, true);

        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < Math.sqrt(B); j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (isPrime[i]) {
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
}
