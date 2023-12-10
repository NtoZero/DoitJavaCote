package seungtae.ch7.integer.ch7_2_euler_p;

import _problems.ch7_integer.ch7_2_euler_p.P41_11689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S41_11689 implements P41_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = N;
        for (long p = 2; p <= Math.sqrt(N); p++) { // 제곱근까지만 진행
            if (N % p == 0) { // p가 소인수인지 확인
                result = result - result / p; // 결과 값 업데이트
                while (N % p == 0) { // 소인수 지우기 -> 2^7*11이라면 2^7을 없애고 11만 남김
                    N /= p;
                }
            }
        }
        if (N > 1) // 아직 소인수 구성이 남아있는 경우
            //(반복문에서 제곱근까지만 탐색했기 때문에 1개의 소인수가 누락되는 케이스)
            result = result - result / N;
        System.out.println(result);
    }
}
