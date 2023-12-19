package juyeon.ch8;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P47_1325_효율적_해킹_2 {
    static int N, M;
    static boolean visited[];
    static int answer[];
    static ArrayList<Integer> A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answer[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (answer[i] == max)
                System.out.print(i + " ");
        }
    }

    private static void BFS(int index) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(index);

        visited[index] = true;

        while (!q.isEmpty()) {
            int e = q.poll();

            for (int i : A[e]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
    }
}
