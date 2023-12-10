package seungtae.ch7.integer.ch7_3.euclidean;

import _problems.ch7_integer.ch7_3_euclidean.P42_1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S42_1934 implements P42_1934 {
    /*
        1. 큰 수를 작은 수로 나누는 MOD 연산 수행
        2. 직전 단계 작은 수와 MOD 연산 결과(나머지)로 MOD 연산 수행
        3. 나머지 0이 되는 순간 작은 수를 최대 공약수로 선택

        GCD(270, 192)
            270 % 192 = 78
                  192 % 78 = 36
                        78 % 36 = 6
                             36 % 6 = 0
                             GCD(270, 192) = 6
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i< T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int answer = A * B / GCD(A, B);
            System.out.println(answer);
        }
    }

    public static int GCD(int num1, int num2) {
        if (num2 == 0)
            return num1;
        else
            return GCD(num2, num1%num2);
    }
}
