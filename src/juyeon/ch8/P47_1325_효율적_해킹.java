package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P47_1325_효율적_해킹 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

//        for (int i = 1; i <= N; i++) {
//            if (max < count[i]) max = count[i];
//        }
//
//        for (int i = 1; i <= N; i++) {
//            if (max == count[i]) System.out.print(i + " ");
//        }

    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        visited[node] = true;

        while (!q.isEmpty()) {
            int e = q.poll();

            for (int i : arr[e]) {
                if (!visited[i]) {
                    count[i]++;
                    visited[i] = true;
                    q.add(i);
                }
            }

        }

    }
}

//5 4
//3 1
//3 2
//4 3
//5 3