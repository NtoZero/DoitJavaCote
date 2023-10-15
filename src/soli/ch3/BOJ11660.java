package soli.ch3;

import problems.ch3_data_structure.ch3_1_sumNumbers.P4_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분합 2
 * 표크기 N, 합 구하는 횟수 M
 * 구간합 (X1,Y1)(X2,Y2)
 */
public class BOJ11660 implements P4_11660 {
    public static void main(String[] args) throws IOException {

        // 합배열 공식
        // S[i] = S[i-1] + A[i] = A[0] + A[1] + A[2]+...+ A[i]
        // 구간 합 공식
        // S[i] - S[i-1]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 표 크기
        int M = Integer.parseInt(st.nextToken());   // 합 구하는 횟수

        int[][] A = new int[N+1][N+1];

        for(int x = 1; x <= N ; x++) {  // 0부터 해도 되지만 0부터 하면 뒤에가 헷갈려져서 그냥 1부터 함
            st = new StringTokenizer(br.readLine()); // 위치 중요
            for(int y = 1; y <= N ; y++) {
                A[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] S = new int[N+1][N+1];

        for(int x = 1 ; x <= N ; x ++ ) {
            for(int y = 1 ; y <= N ; y ++ ) {
                S[x][y] = S[x][y-1] + S[x-1][y] - S[x-1][y-1] + A[x][y];    // 다차원 배열에서는 더해주려면 기본 배열 필요
            }
        }

        for(int k = 0 ; k < M ; k ++) {
            // 구간합
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
        }
    }
}
