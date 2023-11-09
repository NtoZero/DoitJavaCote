package juyeon.ch5;

import _problems.ch5_searching.ch5_1_dfs.P23_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q23_BOJ11724 implements P23_11724 {

    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;

    // 인접 행렬로 풀기
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        boolean[][] A = new boolean[N + 1][N + 1];
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//
//            A[u][v] = A[v][u] = true;
//        }
//
//        visited = new boolean[N + 1];
//        int count = 0;
//
//        for (int i = 1; i <= N; i++) {
//            if (!visited[i]) {
//                DFS(i, N, A, visited);
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
//
//    static void DFS(int n, int N, boolean[][] A, boolean[] visited) {
//        visited[n] = true;
//
//        for (int i = 1; i <= N; i++) {
//            if (!visited[i] && A[n][i]) {
//                DFS(i, N, A, visited);
//            }
//        }
//    }

    // 인접 리스트로 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        // 노드 방문 여부 체크 배열
        visited = new boolean[N + 1];

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);

    }

    private static void DFS(int v) {
        visited[v] = true;

        for (int i : arr.get(v)) {
            if (!visited[i]) {
                DFS(i);
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