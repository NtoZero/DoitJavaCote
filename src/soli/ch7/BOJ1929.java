package soli.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P37_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 implements P37_1929 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 소수 출력
        // 소수 = 1과 자기자신으로만 나누어지는 수
        // 3, 5, 7, 11, 13
        // 홀수 중에만 찾기
        // 35 / = 5.**

        int start = N;
        int end = M;

        isPrimeNumber(start, end);
    }

    private static void isPrimeNumber(int start, int end) {
        for(int i = start; i <= end ; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int start){


        if (start == 1) {
            return false;
        }
        if (start == 2 || start == 3) {
            return true;
        }
        if(start % 2 == 0) {
            return false;
        }

        for(int i = 3 ; i <= Math.sqrt(start) ; i+=2) {
            if(start % i == 0) {
                return false;
            }
        }
        return true;
    }
}
