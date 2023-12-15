package seungtae.ch8.graph.ch8_1;

import _problems.ch8_graph.P47_1325;

import java.io.*;
import java.util.*;

public class S47_1325 implements P47_1325 {
    /*
        문제 분석: 단방향 그래프 관계에서 가장 신뢰 받는 노드를 오름차순으로 출력
            - 가장 신뢰받는 노드란?
                루트 노드부터 시작하여 거리가 가장 먼 노드 목록
            - 시간 복잡도:
                N<=10^4, E<=10^5. => 10^9
                E가 N^2에 한참 못미치므로 인접행렬보다 인접리스트를 통해 순회하는 것이 시공간 효율이 좋다.
                    => 시간 복잡도 O(N*deg(V))
        문제 풀이 :
            1)
     */

    static int N,E;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] trust; // 신뢰도 배열
    static Queue<Integer> Q;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }
        answer = new int[N+1];

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            A[node].add(adj); // 단방향 추가
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        int maxDistance = 0;
        for(int i= 1; i<=N; i++) {
            maxDistance = Math.max(maxDistance, answer[i]);
        }

        for(int i = 1; i<=N; i++) {
            if(answer[i] == maxDistance) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int i) {
        // 매 bfs마다 방문배열과 큐 초기화
        Q = new ArrayDeque<>();

        Q.add(i);
        visited[i] = true;

        while(!Q.isEmpty()) {
            int poll = Q.poll();
            for(int adj : A[poll]) {
                if(!visited[adj]) {
                    Q.add(adj);
                    visited[adj] = true;
                    answer[adj]++;
                }
            }
        }

    }
}


/*
TC 2 : 순환 그래프일 때

3 6
1 2
1 3
2 1
2 3
3 1
3 2

 */