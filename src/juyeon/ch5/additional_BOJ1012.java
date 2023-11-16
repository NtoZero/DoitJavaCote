package juyeon.ch5;

import _problems.ch5_searching.ch5_2_bfs.PP1_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class additional_BOJ1012 implements PP1_1012 {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int count = 0;

            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    if (map[a][b] == 1 && !visited[a][b]) {
                        BFS(a, b);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;
        }
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.add(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int e[] = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = e[0] + dx[k];
                int y = e[1] + dy[k];

                if (x >= 0 && x < M && y >= 0 && y < N) {
                    if (map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;

                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
