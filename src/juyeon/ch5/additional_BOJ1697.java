package juyeon.ch5;


import _problems.ch5_searching.ch5_1_dfs.PP2_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 충격 실화 BFS 문제임 !
public class additional_BOJ1697 implements PP2_1697 {

    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        BFS(N, K);
    }

    private static void BFS(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        visited = new int[100001];
        visited[n] = 0;

        while (!q.isEmpty()) {
            int e = q.poll();

            if (e == k) {
                System.out.println(visited[e]);
                return;
            }

            int[] nextNodes = {e - 1, e + 1, e * 2};

            for (int next : nextNodes) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[e] + 1;
                }
            }
        }
    }
}
