package soli.bonus;

import _problems.ch5_searching.ch5_2_bfs.PP1_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 implements PP1_1012 {

    static int[][] A;
    static boolean[][] visited;
    static int[] a = {-1, 1, 0, 0};
    static int[] b = {0, 0, -1, 1};
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 가로
            M = Integer.parseInt(st.nextToken());
            // 세로
            N = Integer.parseInt(st.nextToken());
            // 배추 개수
            K = Integer.parseInt(st.nextToken());

            A = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0 ; j < K ; j++) {
                st = new StringTokenizer(br.readLine());
                // 배추 위치
                int X = Integer.parseInt(st.nextToken());   // X(0 ≤ X ≤ M-1)
                int Y = Integer.parseInt(st.nextToken());   // Y(0 ≤ Y ≤ N-1)
                A[Y][X] = 1;    // 있으면 1표시
            }
            int count = 0;
            for(int i = 0; i < N ; i++) {
                for(int j = 0 ; j < M ; j++) {
                    if(A[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }


    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ax = y + a[i];
            int by = x + b[i];

            if(ax >= 0 && by >=0 && ax < N && by < M ) {
                if(A[ax][by] == 1 && !visited[ax][by]) {
                    dfs(ax, by);
                }
            }

        }
    }
}
