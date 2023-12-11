package soli.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P39_1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747_2 implements P39_1747 {

    // 소수 판별 베열
    static boolean[] arr = new boolean[2000000];

    public static void main(String[] args) throws IOException {

        for(int i = 2 ; i < arr.length ; i++) {
            arr[i] = true;
        }

        isPrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = N ; i < arr.length ; i++) {
            if (arr[i] && isPalindrome(i)) {
                System.out.println(i);
                break; // 첫 번째 꺼 찾으면 중단
            }
        }
    }

    private static void isPrime() {
        for(int i = 2; i < Math.sqrt(arr.length) ; i++) {
            if(arr[i]){
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    private static boolean isPalindrome(int N) {
        String numberStr = String.valueOf(N);
        int len = numberStr.length();

        for(int i = 0 ; i <= len / 2 ; i++) {
            if(numberStr.charAt(i) != numberStr.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
