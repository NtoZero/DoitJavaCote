package seungtae.ch8.graph.ch8_1;

import _problems.ch8_graph.P46_18352;

import java.io.*;
import java.util.*;

public class S46_18352 implements P46_18352 {
    /*
        문제 분석 : 노드, 엣지, 최단거리, 출발점이 주어질 때 출발점으로부터 거리가 최단거리인 모든 노드 출력하기.
            - 최단거리인 노드를 출력해야하므로 bfs 선택
        문제 풀이 :
            - 노드<=300,000 / 엣지 <=1,000,000 => 엣지가 노드^2에 한참 못미치므로 인접 그래프를 사용하는 것이 유리
                - 인접 그래프 장점 : 1) 한 정점의 모든 그래프 탐색하기 용이 2) 메모리 절약

            1. 노드, 엣지, 최단거리, 출발점을 각각 입력 받는다.
            2. ArrayList<Integer>[]의 배열 크기를 [노드]개로 선언한다.
                - 주의: 각각의 ArrayList에 새 객체를 생성해주어야 한다.
            3. 엣지의 개수만큼 연결리스트를 등록해준다.

            4. 연결리스트를 탐색하면서 최단거리가 K인 노드를 버퍼에 담아준다.
                1) 방문 배열 int[노드 개수]를 선언한다. 값으로는 이동 거리가 담긴다.
                2) 방문한적 없는 노드만 방문하면서 이전 거리+1을 방문 배열에 넣어준다.
                3) 최종적으로 최단거리가 K인 노드만 출력한다.

     */

    static int N, E, K, X;
    static ArrayList<Integer>[] A;
    static int[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    static Queue<Integer> Q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 최단 거리
        X = Integer.parseInt(st.nextToken()); // 출발점

        A = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        for(int i=1; i<=N; i++) {
            visited[i] = -1;
        } // -1로 초기화하지 않으면 최초 시작점을 다시 방문할수도 있음 (하단 반례 참조)

        for(int i=0; i<E; i++) { // 단방향 연결 리스트 초기화
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            A[node].add(adj); // 단방향 그래프이므로 한 번만 연결
        }

        bfs(K, X);

    }

    static void bfs(int K, int X) throws IOException {
        Q.add(X);
        visited[X]++;

        while(!Q.isEmpty()) {
            int poll = Q.poll();
            for(int adj : A[poll]) { // 인접 노드 FIFO로 탐색
                if(visited[adj]==-1) { // 방문한 적 없다면
                    visited[adj] = visited[poll]+1; // 이전 거리에서 +1 증가
                    Q.add(adj);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(visited[i]==K) {
                answer.add(i); // 정답배열에 포함
            }
        }

        if(answer.isEmpty()) {
            sb.append(-1);
        } else {
            Collections.sort(answer);

            for(int i : answer) {
                sb.append(i+"\n");
            }
        }

        System.out.println(sb);
    }
}

/*
방문 배열 -1로 초기화하지 않았을 경우

2 2 2 1
1 2
2 1

정답 : -1
오답 : 1

 */