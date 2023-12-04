package juyeon.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P39_1747;

import java.util.Scanner;

public class Q39_BOJ1747 implements P39_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 1) {

            System.out.println(2);

        } else {

            for (int i = N; ; i++) {
                if (isTomato(i) && isPrime(i)) {
                    System.out.println(i);

                    System.exit(0);
                }
            }
        }

    }

    private static boolean isTomato(int k) {
        String str = String.valueOf(k);

        for (int i = 0; i <= str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;

    }

    private static boolean isPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) return false;
        }
        return true;
    }

}
