package soli.ch5;

import _problems.ch5_searching.ch5_2_bfs.P26_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 implements P26_1260 {

//    static ArrayList<Integer> A;    -> 하나의 정수만 저장할 수 있음
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 노드 수
        int M = Integer.parseInt(st.nextToken());   // 엣지 수
        int V = Integer.parseInt(st.nextToken());   // 시작점

        A = new ArrayList[N+1];
        for(int i = 1 ; i < N+1 ; i ++) {
            A[i] = new ArrayList<>();   // 각 노드마다 배열리스트 하나씩 만들어주기
        }

        for(int i = 0 ; i < M ; i ++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for(int i = 1 ; i < N+1 ; i++) {
            Collections.sort(A[i]); // 순서대로 방문
        }
        // 방문 배열 초기화
        visited = new boolean[N+1];
        dfs(V); // 시작점

//        System.out.println();
        sb.append("\n");
        // 방문 배열 초기화 -> 안 하면 첫 번째 방문 하는 거만 나옴
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int node) {
//        System.out.print(node + " ");
        sb.append(node).append(" ");
        visited[node] = true;

        // 각 리스트(node)에 주어진 인접 숫자들 i
        // A[1] = [1,2,3] -> node = 1, i = 1,2,3
        // 해당 인접 정점을 순회하면서 dfs 탐색
        for(int i : A[node]) {
            if(visited[i] == false) {
                dfs(i); // 만약에 노드 방문 안 했으면
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> Q = new LinkedList<>();
        // 큐에 node 추가
        Q.add(node);
        // 방문했으니까 true로 변경
        visited[node] = true;

        // 큐에서 빼기
        while (!Q.isEmpty()) {
            int bfs_node = Q.poll();
            sb.append(bfs_node).append(" ");
//            System.out.print(bfs_node + " ");
            // bfs_node 다 돌면서 false 면 true로 바꾸고 출력
            for(int i : A[bfs_node]) {
                if(visited[i] == false) {
                    visited[i] = true;
                    Q.add(i);
                }
            }
        }
    }
}
