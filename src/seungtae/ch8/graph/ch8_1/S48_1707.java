package seungtae.ch8.graph.ch8_1;

import _problems.ch8_graph.P48_1707;

import java.io.*;
import java.util.*;

public class S48_1707 implements P48_1707 {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean isEven; //이분 탐색 그래프인지?
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int K = Integer.parseInt(br.readLine()); //TC
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 각종
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < E; j++) { // 인접 리스트
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int near = Integer.parseInt(st.nextToken());
                A[node].add(near);
                A[near].add(node);
            }
            for (int k = 1; k <= V; k++) { // ❗ 주어진 그래프가 하나로 연결되어 있다는 보장이 없으므로 모든 정점에서 수행
                if (isEven)
                    dfs(k);
                else
                    break;
            }
            check[1] = 0;
            if (isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static void dfs(int node) { // DFS구현
        visited[node] = true;
        for (int i : A[node]){
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2; // 인접한 노드는 이전 노드와 다른 집합
                dfs(i);
            }
            else if (check[node] == check[i]){ // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프X
                isEven = false;
            }
        }
    }
}
