package soli.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P39_1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747 implements P39_1747 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MAX =  2000000;

        boolean[] isPrime = sieve(MAX);

        for(int i = N ; i < isPrime.length ; i++) {
            if(isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }


    }

    // 펠리드럼수인지 황닌
    private static boolean isPalindrome(int N) {
        String numberStr = String.valueOf(N);
        int len = numberStr.length();

        for(int i = 0 ; i <= len / 2 ; i++) {
            if (numberStr.charAt(i) != numberStr.charAt(len - i - 1)) {   // 글자수가 하나 더 많음
                return false;
            }
        }
        return true;
    }

    private static boolean[] sieve(int MAX) {
        boolean[] isPrime = new boolean[MAX + 1];

        for(int i = 2; i <= Math.sqrt(MAX) ; i++) {
            isPrime[i] = true;
        }

        for(int i = 2 ; i * i <= MAX ; i++) {
            if(isPrime[i] == true) {
                // j 배수들 다 false
                for(int j = i * i ; j <= MAX ; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }


}
