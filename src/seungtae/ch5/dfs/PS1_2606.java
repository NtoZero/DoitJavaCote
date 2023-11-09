package seungtae.ch5.dfs;

import _problems.ch5_searching.ch5_1_dfs.PP1_2606;

import java.io.*;
import java.util.*;

public class PS1_2606 implements PP1_2606 {
    /*
        - 문제 유형 : 연결된 요소 찾기 문제
        - 문제 분석 : 1번 노드와 연결된 모든 노드의 개수를 출력

        - 사용 알고리즘 : DFS (깊이 우선 탐색), 1번 노드와 연결된 노드를 모두 탐색한 후 그 count를 리턴
            - 수의 크기 : N (100이하 양의 정수)
     */

    static ArrayList<Integer>[] A; // 인접 그래프
    static boolean[] visited; // 방문 여부
    static int count; // 결과 값

    /*
        인접 행렬을 이용하는 방법
        static boolean[][] graph;
        static boolean[] visited;
        static int N, M;
        static int answer;
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 인접 리스트 배열 요소 초기화
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접 리스트 값 할당
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            A[node].add(adj);
            A[adj].add(node);
        }

        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int i) {
        if(visited[i]) return;
        visited[i] = true;

        for(int adj : A[i]) {
            if(!visited[adj]) {
                count++;
                dfs(adj);
                visited[adj] = true;
            }
        }
    }
}
