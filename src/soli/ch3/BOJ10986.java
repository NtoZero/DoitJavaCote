package soli.ch3;

import problems.ch3_data_structure.ch3_1_sumNumbers.P5_10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수 N개 A1, A2, ..., AN이 주어진다.
 * 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성
 * Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수
 */
public class BOJ10986 implements P5_10986 {
    public static void main(String[] args) throws IOException {
        // 연속된 부분의 합이 M으로 나누어 떨어짐 -> 연속된 부분의 합 : 부분합
        // 연속된 부분의 합이 M의 배수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N+1];   // 오버플로우 발생함 -> long으로 변경해줘야 한다.
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i ++ ) {
            // 부분합 배열
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
            count[(int)(S[i] % M)]++;  // 나머지 값을 인덱스로 써서 count 증가
        }

        // 결과값의 기본값 = 0의 개수
        long result = count[0];
        for(int i = 0 ; i < M ; i ++) {
            // 0의 개수 + 배열마다 같은 거 개수 2개 씩 -> 경우의 수 구하기
            result += count[i] * (count[i]-1) / 2 ;
        }
        System.out.println(result);

    }
}

