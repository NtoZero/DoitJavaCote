package seungtae.ch7.integer.ch7_1_prime_number;

import _problems.ch7_integer.ch7_1_prime_number.P37_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S37_1929 implements P37_1929 {
    /*
        문제 분석 : M이상 N 이하의 소수를 모두 출력하는 프로그램 작성
            - 시간 복잡도 : O(NlogN) 이하 권장 (10^6)
     */
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mAndn = br.readLine().split(" ");
        eratosthenes(Integer.parseInt(mAndn[0]), Integer.parseInt(mAndn[1]));

        System.out.println(sb);
    }

    // 에라토스테네스의 체
    static void eratosthenes(int m, int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true); // 전부 소수인 것으로 초기화
        //단, 1은 소수가 아니다.
        isPrime[1] = false;

        for (int i = 2; i*i <=n; i++) { // 가장 작은 소수인 2부터 시작하여 제곱근 이전까지만 판별
            if (isPrime[i]) {
                // i가 소수인 경우 i의 배수 모두 지우기
                if(isPrime[i]) {
                    for(int j = i * i; j<=n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        for(int i=m; i<=n; i++) { // m부터 n까지 중 소수만 출력
            if(isPrime[i]) sb.append(i+"\n");
        }
    }
}
