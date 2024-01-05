package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 50160KB, 900ms
public class P53_2252_줄_세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        // 진입 노드 개수 저장
        int[] in = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
            in[B]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");

            for (int i = 0; i < arr[v].size(); i++) {
                int e = arr[v].get(i);

                if (--in[e] == 0) q.add(e);
            }
        }

    }
}
