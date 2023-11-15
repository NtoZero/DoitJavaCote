package soli.bonus;

import _problems.ch5_searching.ch5_2_bfs.PP3_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 implements PP3_7576 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] A;
    static int M;
    static int N;
    static Queue<int[]> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토를 큐에 삽입
                if(A[i][j] == 1) {
                    Q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        while (!Q.isEmpty()) {
            int[] tomato = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tomato[0] + dx[i];
                int ny = tomato[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && A[nx][ny] == 0) {
                    Q.add(new int[]{nx, ny});
                    // 토마토 x, y 위치 추가, 일수 갱신
                    A[nx][ny] = A[tomato[0]][tomato[1]] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] == 0) {
                    // 안 익었으면 -1
                    return  -1;
                }
                max = Math.max(max, A[i][j]);
            }
        }
        // 토마토 다 익으면 0 아니면 -1
        return max - 1;
    }
}
