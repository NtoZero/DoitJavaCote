package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P46_18352_특정_거리의_도시_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
        }

        distance[X] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while (!q.isEmpty()) {
            int e = q.poll();

            for (int i = 0; i < arr[e].size(); i++) {
                int next = arr[e].get(i);

                if (distance[next] == -1) {
                    distance[next] = distance[e] + 1;
                    q.add(next);
                }
            }
        }

        boolean result = false;

        for (int i = 0; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                result = true;
            }
        }

        if (!result) System.out.println(-1);

    }
}
