package soli.ch7;

import _problems.ch7_integer.ch7_2_euler_p.P41_11689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11689 implements P41_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // 오일러 파이
        // -> n 과 서로소인 수의 개수
        // 소인수 분해 해서 소인수 찾기
        long result = n;
        for(long i = 2; i*i <= n ; i++) {
            if(n % i == 0 ){    // 소인수인지 확인
                result = result - result / i ;
                while (n % i == 0) {    // n을 나눌 수 있을 때 까지 나눠 줌
                    n /= i;
                }
            }
        }
        if(n > 1) { // 1보다 크면
            result = result - result / n ;  // 남은 수에 대해서도 반복
        }
        System.out.println(result);
    }
}

// java 식은 외워야 할 듯..?ㅋㅎ


// 오일러 파이 영상 참고
// https://ko.khanacademy.org/computing/computer-science/cryptography/modern-crypt/v/euler-s-totient-function-phi-function
// 영상을 글로 동일
// https://developer-next-to-you.tistory.com/242
