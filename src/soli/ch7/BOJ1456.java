package soli.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P38_1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1456 implements P38_1456 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 어떤 수가 소수의 N제곱일 때 거의 소수

        long start = A;
        long end = B;
        countAlmostPrime(start, end);
    }

    private static void countAlmostPrime(long start, long end) {
        int count = 0;
        for(int i = 2; i <=Math.sqrt(end) ; i++) {
            if(isPrime(i)) {
                long almostPrime = i;
                while(almostPrime <= end) {
                    almostPrime *= i;
                    if(almostPrime >= start && almostPrime <= end) {
                        count++;
                    }
                }

            }
        }
        System.out.println(count);
    }



    private static boolean isPrime(int start) {
        if(start == 1) {
            return false;
        }
        if(start == 2 || start == 3) {
            return true;
        }
        if(start % 2 == 0) {
            return false;
        }
        for(int i  = 3 ; i <= Math.sqrt(start) ; i++) {
            if(start % i == 0) {
                return false;
            }
        }
        return true;
    }
}
