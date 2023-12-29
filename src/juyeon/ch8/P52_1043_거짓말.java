package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * static Map<Integer, Integer> map;
 * ^ 이렇게 맵 써서 해보려고 했으나....! 노노 포기
 *
 */

public class P52_1043_거짓말 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        boolean[] truth = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= k; i++) {
            int e = Integer.parseInt(st.nextToken());
            truth[e] = true;
        }

        ArrayList<Integer>[] party = new ArrayList[M + 1];

        for (int i = 1; i <= M; i++) {

            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());

            int x = 0;
            int y = 0;

            if (p > 0) {
                x = Integer.parseInt(st.nextToken());
                party[i].add(x);
            }

            for (int j = 1; j < p; j++) {
                y = Integer.parseInt(st.nextToken());
                party[i].add(y);

                union(x, y);

                x = y;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (truth[i]) truth[find(i)] = true;
        }

        int count = 0;

        for (int i = 1; i <= M; i++) {
                int v = find(party[i].get(0));
                if (!truth[v]) count++;
        }

        System.out.println(count);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int n) {
        if (n == parent[n]) {
            return n;
        } else {
            return parent[n] = find(parent[n]);
        }
    }
}


// 10 9
// 4 1 2 3 4
// 2 1 5
// 2 2 6
// 1 7
// 1 8
// 2 7 8
// 1 9
// 1 10
// 2 3 10
// 1 4

// 4