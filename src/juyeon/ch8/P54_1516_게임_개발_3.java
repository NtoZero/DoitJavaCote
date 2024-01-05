package juyeon.ch8;

// https://polydactyl-impala-301.notion.site/Heap-Priority-Queue-45b41cd7f5ce4e40b0d8b0c6e6bd71cc

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐 활용해서 풀어보기 ~~,,,
class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    // cost 큰 게 우선순위도 높게
    @Override
    public int compareTo(Node o) {
        return (this.cost > o.cost ? -1 : 1);
    }
}

public class P54_1516_게임_개발_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] T = new int[N + 1];

        int[] in = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());

            T[i] = t;

            int x = 0;

            while (x != -1) {
                x = Integer.parseInt(st.nextToken());

                if (x == -1) break;

                arr[x].add(i);
                in[i]++;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {

            if (in[i] == 0) {
                pq.add(new Node(i, T[i]));
                result[i] = T[i];
            }
        }

        while (!pq.isEmpty()) {
            Node v = pq.poll();

            for (int e : arr[v.idx]) {
                result[e] = Math.max(result[e], result[v.idx] + T[e]);

                if (--in[e] == 0) {
                    pq.add(new Node(e, result[e]));
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}

// 5
// 10 -1
// 10 1 -1
// 4 1 -1
// 4 3 1 -1
// 3 3 -1

// 10
// 20
// 14
// 18
// 17