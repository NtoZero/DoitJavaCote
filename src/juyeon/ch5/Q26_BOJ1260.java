package juyeon.ch5;

import _problems.ch5_searching.ch5_2_bfs.P26_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q26_BOJ1260 implements P26_1260 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        // 그래프 데이터 저장
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        // 문제 조건 : 노드 번호가 작은 것을 먼저 방문 => 정렬하라고
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[N + 1];

        DFS(V);

        System.out.println();

        visited = new boolean[N + 1];

        BFS(V);
    }

    private static void DFS(int node) {
        System.out.print(node + " ");

        visited[node] = true;

        for (int i : arr[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int e = q.poll();
            System.out.print(e + " ");

            for (int i : arr[e]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

}

// 5 5 3
// 5 4
// 5 2
// 1 2
// 3 4
// 3 1

// 3 1 2 5 4
// 3 1 4 2 5