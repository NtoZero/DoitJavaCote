package seungtae.ch7.integer.ch7_1_prime_number;

import _problems.ch7_integer.ch7_1_prime_number.P38_1456;

import java.io.*;
import java.util.*;

public class S38_1456 implements P38_1456 {
    /*
        문제 분석: 거의 소수(소수의 N제곱) 찾기
            - 정수 A<=B
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[] arr = new long[10000000+1]; // 10^14의 제곱근 10^7

        for(int i=2; i< arr.length; i++) { // 1은 소수가 아니므로 제외
            arr[i] = i;
        }

        for(int i=2; i<=Math.sqrt(arr.length); i++) { // 배열 크기의 제곱근까지 수행
            if(arr[i]==0) { // 소수X면 건너뛰기
                continue;
            }
            for(int j= i+i; j<arr.length; j = j+i) { // 소수의 배수면 소수가 아니다.
                arr[j] = 0;
            }
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=0) {
                long tmp = arr[i]; // 소수일 때
                // 오버플로우 방지
                while((double) arr[i] <= (double) B / (double) tmp) {
                    if((double) arr[i] >= (double) A / tmp) { // 최댓값보다 작으면서 최소값보다 크면
                        cnt++;
                    }
                    tmp = tmp * arr[i]; // 소수의 N제곱
                }
            }
        }
        System.out.println(cnt);
    }
}
