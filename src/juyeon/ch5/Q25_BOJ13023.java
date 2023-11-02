package juyeon.ch5;

import _problems.ch5_searching.ch5_1_dfs.P25_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25_BOJ13023 implements P25_13023 {

    static int N, M;
    static boolean[][] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a][b] = A[b][a] = true;
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (DFS(i, 0)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private static boolean DFS(int v, int depth) {
        if (depth == 4) return true;

        visited[v] = true;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && A[v][i]) {
                if (DFS(i, depth + 1)) return true;
            }
        }

        // 백트래킹
        visited[v] = false;

        // depth 가 4인 관계를 찾지 못했다면 false
        return false;
    }
}


// 5 4
// 0 1
// 1 2
// 2 3
// 3 4

// 1