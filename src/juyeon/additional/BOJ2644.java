package juyeon.additional;

import _problems.ch5_searching.ch5_1_dfs.PP3_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 또 BFS네용
public class BOJ2644 implements PP3_2644 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] distance;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];

        System.out.println(BFS(a));
    }

    private static int BFS(int a) {
        Queue<Integer> q = new LinkedList<>();

        visited[a] = true;
        distance[a] = 0;

        q.add(a);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i : arr[v]) {
                if (!visited[i]) {
                    distance[i] = distance[v] + 1;

                    if (i == b) return distance[i];

                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}

// 9
// 7 3
// 7
// 1 2
// 1 3
// 2 7
// 2 8
// 2 9
// 4 5
// 4 6

// 3