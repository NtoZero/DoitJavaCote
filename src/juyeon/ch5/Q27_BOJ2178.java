package juyeon.ch5;

import _problems.ch5_searching.ch5_2_bfs.P27_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q27_BOJ2178 implements P27_2178 {

    static int[][] A;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        // 2차원 배열 데이터 ( 미로) 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (int j = 0; j < M; j++) {
                // str.substring(j, j + 1) => 단일 문자 / 숫자 추출
                A[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        BFS(0, 0);

        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        // 상하좌우 혹은 8방향 => dx, dy가 킥
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.add(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int e[] = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = e[0] + dx[k];
                int y = e[1] + dy[k];

                // 아래 validation을 메서드로 빼는 게 나을지 ?
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;

                        A[x][y] = A[e[0]][e[1]] + 1;

                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}

// 4 6
// 101111
// 101010
// 101011
// 111011