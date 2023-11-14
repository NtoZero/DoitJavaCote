package seungtae.ch5.bfs;

import _problems.ch5_searching.ch5_2_bfs.PP1_1012;
import java.util.*;
import java.io.*;

public class PS1_1012 implements PP1_1012 {
    /*
        문제 분석 : 상하좌우 이동을 통해 연결요소의 개수를 탐색하는 문제
            - 지렁이 마리 수 = 연결 요소 개수
            - '상하좌우'의 이동 -> 너비 우선탐색(bfs)
     */
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;
    static int[][] A;
    static boolean[][] visited;
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 각 테스트 케이스 행
            int N = Integer.parseInt(st.nextToken()); // 각 테스트 케이스 열
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 수의 개수

            A = new int[M][N];
            visited = new boolean[M][N];

            // 배추 초기화
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                A[x][y] = 1;
            }
        }



    }
}
