package seungtae.ch5.dfs;

import _problems.ch5_searching.ch5_1_dfs.PP3_2644;

import java.io.*;
import java.util.*;

public class PS3_2644 implements PP3_2644 {
    /*
        문제 분석
            - 촌수: 두 노드간 depth 거리 차이를 계산
            - 사용 알고리즘 : dfs
            - 주의 사항 : 두 사람의 관계가 이어지지 않을 때 -1을 출력

        문제 풀이
            - 양방향 그래프이므로 루트 노드를 목적 노드 중 하나로 두고,
                다른 목적 노드를 만날 때까지 순회하여 result를 계산한다.

        dfs
           ArrayList[] : 인접 그래프 표현
           boolean[] : 방문 여부 표현
           스택 : LIFO 구조로 재귀를 통해 갈음
     */
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    static int o1;
    static int o2;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 두 노드 사이의 depth 차이 구하기
        o1 = Integer.parseInt(st.nextToken());
        o2 = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(br.readLine());

        // 배열 공간 선언
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 인접그래프 배열 ArrayList 객체 초기화
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        // 부모-자식 관계 인접그래프화
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            // 촌수는 양방향 관계
            A[parent].add(child);
            A[child].add(parent);
        }

        // dfs(루트 노드 = 목적 노드 중 하나, depth)
        dfs(o1, 0);

        // result가 0이 아니면 (촌수가 있으면) 양 노드간 촌수를 출력하고, 아니면 -1을 출력한다.
        System.out.println(result != 0? result : -1);
    }

    static void dfs(int node, int depth) {
        if(node == o2) { //루트 노드 o1으로 시작해 o2를 만나면
            result = depth; // 도달한 depth 계산
            return;
        }

        if(visited[node]) return;
        visited[node] = true;

        for(int adj : A[node]) {
            if(!visited[adj]) {
                dfs(adj, depth+1);
            }
        }

    }
}
