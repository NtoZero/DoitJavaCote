package soli.ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수 N개가 주어졌을 때 i번째 부터 j까지 합
 * 수의 개수 N , 합을 구해야 하는 횟수 M
 * 1 <= N <= 1000 개의 수
 * 합을 구해야 하는 구간 i , j
 */
public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        // 합배열 공식
        // S[i] = S[i-1] + A[i] = A[0] + A[1] + A[2]+...+ A[i]

        // 구간 합 공식
        // S[i] - S[i-1]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // 첫 번째 라인에 N M 구분

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] S = new int[N+1];
        for(int k = 1; k <= N ; k ++) { // 1부터인 이유는 k-1 이 0이상이어야 하기 때문
            // 배열은 아무것도 안 들어가 있으면 원래 0
            S[k] = S[k-1] + Integer.parseInt(st.nextToken());
        }

        for(int k = 0 ; k < M ; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i-1]);
        }

//        잘못한 것 -> A도 배열에 넣어서 하려고 했는데 실패
//        int[] A = new int[N];
//        for(int k = 0; k <N ; k ++) {
//            A[k] = Integer.parseInt(st.nextToken());
//        }
//
//        S[0] = A[0];
//        for(int k = 1; k < N ; k ++) {
//            S[k] = S[k-1] + A[k];
//        }
//
//        for(int k = 0 ; k < M ; k++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int i = Integer.parseInt(st.nextToken()) - 1; // 배열 인덱스는 0부터 시작하므로 1을 뺍니다.
//            int j = Integer.parseInt(st.nextToken()) - 1; // 마찬가지로 1을 뺍니다.
//
//            // i가 0일 경우 S[i-1] 대신 0을 사용하고, 그렇지 않으면 S[i-1]을 사용합니다.
//            System.out.println(S[j] - (i == 0 ? 0 : S[i-1]));
//        }
    }
}
