package seungtae.ch3.ch3_1_sumNumbers;

import _problems.ch3_data_structure.ch3_1_sumNumbers.P4_11660;

import java.util.*;
import java.io.*;

public class S4_BOJ11660_RE implements P4_11660 {
    /*
        시간 제한 1초, 메모리 제한 256MB
        표의 크기 N(10^3, 1024) / 합을 구해야 하는 횟수 M(10^5) / 수의 크기 10^3 이하 자연수
        - 시간 복잡도 : 처음 N*N으로 배열을 받을 때 합배열을 구해서 해결할 수 있다.
          만일 for문을 사용한다면 풀이가 불가능하다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 표의 크기 N, 합을 구하는 횟수 M 받기
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        // 2. N x N 2차원 원소 및 합배열 만들기 (단, +1 공간을 더 만들어 0으로 채운다.)
        int[][] arr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];

        // 3. 2차원 원소 배열, 합 배열에 수 채워 넣기
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
            }
        }

        // 4. M번 입력 값 받아 계산하기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // x1
            int b = Integer.parseInt(st.nextToken()); // y1
            int c = Integer.parseInt(st.nextToken()); // x2
            int d = Integer.parseInt(st.nextToken()); // y2

            int sum = 0;
                // 합[x2][y2] - 합[x1-1][y2] - 합[x2][y1-1] + 합[x1-1][y1-1]
            sum = sumArr[c][d] - sumArr[a-1][d] - sumArr[c][b-1] + sumArr[a-1][b-1];

            bw.write(sum+"\n");
        }
        bw.close();
    }
}
