package soli.ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1167 {
    static int V;
    static ArrayList<LinkedList<Node>> tree;    // 그래프를 인접리스트로
    static boolean[] visited;
    static int max; // 지름 길이
    static int farthestNode;    // 지름 끝

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        tree = new ArrayList<>(V + 1);  // 1부터 V까지 정점
        visited = new boolean[V+1];

        // 인접리스트로 초기화
        for(int i = 0 ; i<= V ; i++) {
            tree.add(new LinkedList<>());
        }

        for(int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(true) {
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) {    // -1이면 종료
                    break;
                }

                int distance = Integer.parseInt(st.nextToken());
                tree.get(start).add(new Node(next, distance));
                tree.get(next).add(new Node(next, distance));
            }
        }

        // 1에서 제일 먼 노드 찾기
        dfs(1,0);

        // 제일 먼 노드 기준으로 가장 먼 노드 찾기
        visited = new boolean[V+1];
        dfs(farthestNode, 0);

        // 트리 지름 출력
        System.out.println(max);
    }

    static void dfs(int node, int distance) {
        // 방문했으니까 true로 바꾸기
        visited[node] = true;

        // 제일 먼 거리 찾기
        if(distance > max) {
            max = distance;
            farthestNode = node;
        }

        // 현재 노드에서 연결된 노드 계속 탐색
        for(Node nextNode : tree.get(node)) {
            // 만약에 방문 안 했으면 방문하면서 거리 계속 더하기
            if(!visited[nextNode.vertex]) {
                dfs(nextNode.vertex, distance + nextNode.distance);
            }
        }
    }

    // Node 입력값
    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
