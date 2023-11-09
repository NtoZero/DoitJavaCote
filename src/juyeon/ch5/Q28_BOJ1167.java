package juyeon.ch5;

import _problems.ch5_searching.ch5_2_bfs.P28_1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q28_BOJ1167 implements P28_1167 {

    static class Node{
        int to;
        int dist;
        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());

                if (to == -1) break;

                int dist = Integer.parseInt(st.nextToken());

                arr[idx].add(new Node(to, dist));
            }

        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];

        BFS(1);

        int max = 0;

        for (int i = 1; i <= V; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];

        // 임의의 노드에서 가장 먼 노드를 찾고, 그 노드에서 다시 한번 가장 먼 노드를 찾게 되면 총 2번의 탐색으로 트리의 지름을 구할 수 있다. 는데 이유는 아직 잘..
        BFS(max);

        Arrays.sort(distance);

        System.out.println(distance[V]);
    }

    private static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int e = q.poll();

            for (Node i : arr[e]) {
                int a = i.to;
                int b = i.dist;

                if (!visited[a]) {
                    visited[a] = true;
                    q.add(a);
                    distance[a] = distance[e] + b;
                }
            }
        }
    }
}


// 5
// 1 3 2 -1
// 2 4 4 -1
// 3 1 2 4 3 -1
// 4 2 4 3 3 5 6 -1
// 5 4 6 -1

// 11