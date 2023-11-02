package juyeon.ch5;

import _problems.ch5_searching.ch5_1_dfs.P23_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q23_BOJ11724 implements P23_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] A = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u][v] = A[v][u] = true;
        }

        boolean[] visited = new boolean[N + 1];
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i, N, A, visited);
                count++;
            }
        }

        System.out.println(count);
    }

    static void DFS(int n, int N, boolean[][] A, boolean[] visited) {
        visited[n] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && A[n][i]) {
                DFS(i, N, A, visited);
            }
        }
    }
}


// 6 5
// 1 2
// 2 5
// 5 1
// 3 4
// 4 6

// 2