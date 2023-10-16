package juyeon.review;

import problems.ch3_data_structure.ch3_1_sumNumbers.P5_10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986_RE implements P5_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 구간합의 나머지 배열
        long[] S = new long[N+1];

        // M으로 나누어떨어지는 (i,j) 개수
        long count = 0;

       // 나머지값 같은 거 개수 세는 배열
        long[] idx = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            S[i] = ( S[i-1] + Integer.parseInt(st.nextToken()) ) % M;

            // 0인 애들은 따로 세어주고
            if (S[i] == 0) count++;

            // 나머지값 같은 거 카운트
            idx[(int) S[i]]++;
        }

        // 조합 nCr ( n개 중에 r개 뽑기 ) = ( n * n-1 ) / r
        for (int i = 0; i < M; i++) {
            if (idx[i] > 1) {
                count += ( idx[i] * ( idx[i] - 1 ) ) / 2;
            }
        }

        System.out.println(count);
    }
}