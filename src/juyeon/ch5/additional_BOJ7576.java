package juyeon.ch5;

import _problems.ch5_searching.ch5_2_bfs.PP3_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class additional_BOJ7576 implements PP3_7576 {

    static class Tomato {
        int x, y, day;
        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int M, N;
    static int[][] map;
    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nd = 0;

        while (!q.isEmpty()) {
            Tomato e = q.poll();

            nd = e.day;

            for (int k = 0; k < 4; k++) {
                int x = e.x + dx[k];
                int y = e.y + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (map[x][y] == 0) {
                        map[x][y] = 1;
                        q.add(new Tomato(x, y, nd + 1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return -1;
            }
        }

        return nd;
    }
}


// 6 4
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 1

// 8