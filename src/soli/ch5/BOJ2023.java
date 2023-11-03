package soli.ch5;

import _problems.ch5_searching.ch5_1_dfs.P23_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ2023  {
    public static void main(String[] args) throws IOException {
        // 신기한 소수 찾기
        // 7331 -> 7, 73, 733 모두 소수
        // 소수 찾기 -> 더 이상 나눠지지 않는 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 자리수에서 구해야 함
        // N 자리의 수 시작 점
        int start = (int) Math.pow(10, N- 1);
        // N 자리의 수 마지막 끝
        int end = (int) Math.pow(10, N) - 1;

        for(int num = start ; num <= end ; num ++) {
            // 소수 이면
            if(isPrime(num) == true) {
                System.out.println(num);
            }
        }
    }

    private static boolean isPrime(int num) {
        if(prime(num) == false) {
            return false;
        }
        // 자리수마다 잘라서 검사해야 함
        int i = 1;
        for(int j = 0 ; j < String.valueOf(num).length() ; j++) {
            // prime(1, 10, 100...)으로 나눈 몫을 소수인지 판별하는 거
            if(prime(num / i) == false) {
                return false;
            }
            i *= 10;
        }
        return true;
    }

    // 소수 구하기
    private static boolean prime(int num) {

        // 0, 1은 소수 X
        if(num < 2) {
            return false;
        }

        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {
            // 2로 나눠져서 나머지 없으면 소수 X
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}