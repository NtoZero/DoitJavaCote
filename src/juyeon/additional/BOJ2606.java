package juyeon.additional;

import _problems.ch5_searching.ch5_1_dfs.PP1_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2606 implements PP1_2606 {

    static ArrayList<Integer>[] arr;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 컴퓨터 수
        int N = Integer.parseInt(st.nextToken());

        // 몇 쌍
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        count = 0;
        visited = new boolean[N + 1];

        DFS(1);

        System.out.println(count);

    }

    private static void DFS(int n) {
        visited[n] = true;

        for (int i : arr[n]) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
    }
}
