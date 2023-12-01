package soli.ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1456_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        countAlmostPrime(A, B);
    }

    private static void countAlmostPrime(long start, long end) {
        boolean[] isPrime = new boolean[(int)Math.sqrt(end) + 1];
        for(int i = 2; i <= Math.sqrt(end); i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체
        for(int i = 2; i * i <= Math.sqrt(end); i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= Math.sqrt(end); j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // 거의 소수 찾기
        for(int i = 2; i <= Math.sqrt(end); i++) {
            if(isPrime[i]) {
                long almostPrime = (long)i * i;
                while(almostPrime <= end && almostPrime > 0) { // 오버플로 방지
                    if(almostPrime >= start) {
                        count++;
                    }
                    if(Long.MAX_VALUE / i < almostPrime) break; // 오버플로 방지
                    almostPrime *= i;
                }
            }
        }
        System.out.println(count);
    }
}
