package seungtae.ch5;

import _problems.ch5_searching.ch5_1_dfs.P23_11724;

import java.io.*;
import java.util.*;

public class S23_11724 implements P23_11724 {
    /*
        - DFS(깊이 우선 탐색)
            - 정의 : 시작 노드에서출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후
                    다음 분기로 이동하여 다시 탐색을 수행
            - 요구
                1. 배열 (노드 방문 여부를 체크)
                2. 그래프 (인접 리스트)
                3. 스택 (DFS - 후입 선출의 특성)
            - 절차
                1. DFS를 시작할 노드를 정한 후 사용할 자료구조 초기화
                    1) 인접 리스트로 그래프 표현
                    2) 방문 배열 초기화
                    3) 시작 노드 스택에 삽입 (스택 자료구조에 시작점을 더하기)
                2. 스택에서 노드를 꺼낸 후 꺼낸 노드의 인접 노드를 다시 스택에 삽입
                    1) 스택에서 노드를 꺼내면서 탐색 순서에 꺼낸 노드를 기록
                    2) 인접 리스트, 대상 노드의 인접 노드를 스택에 삽입
                    3) 노드를 삽입하며 방문 배열 체크
                3. 스택 자료구조에 값이 없을 때까지 반복
                    1) 인접 노드가 없을 때까지 방문하며, 인접 노드가 존재하더라도 방문했으면 다시 방문하지 않는다.
                        - 방문할 필요가 없다면, 방문할 예정 스택에 삽입하지 않는다.
            - 시간복잡도
                - O(N+E) : Node 수, Edge 수
     */

    static ArrayList<Integer>[] A; // 인접 그래프 (ArrayList의 배열)
    static boolean[] visited; // 방문 여부
    public static void main(String[] args) throws IOException {
        /*
            연결 요소 : 간선으로 연결된 노드의 집합
                - 한 번의 DFS가 끝날 때까지 탐색한 모든 노드의 집합
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수

        A = new ArrayList[N+1]; // 인접 그래프
        visited = new boolean[N+1];    // 방문 여부
        Stack<Integer> plan_stack = new Stack<>(); // 방문할 예정 스택
        int result = 0; // 결과값

        // 1. 인접 리스트 그래프 초기화
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        /*
            Node에 대한 연결리스트 초기화 (1~N)
            1
            2
            3
            4
            5
            6
         */

        // 2. 간선 수 만큼 인접 리스트 대입
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int near = Integer.parseInt(st.nextToken());

            // 무방향 그래프이므로 양 노드 추가
            A[node].add(near);
            A[near].add(node);
        }
        /*
            인접 리스트
                1   2,5
                2   1,5
                3   4
                4   3,6
                5   2,1
                6   4
            - 방문 배열
                1   2   3   4   5   6
                F   F   F   F   F   F
              1에서 시작한 경우
                T   T   F   F   T   F
         */

        for (int i=1; i<=N; i++) {
            if(!visited[i]) {   // 방문X 노드 없을 때까지 반복
                result++;
                DFS(i);
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static void DFS(int v) {
        // 방문한 적 있으면 종료
        if(visited[v]) {
            return;
        }

        // 방문 전적 없다면 true
        visited[v] = true;
            //인접 리스트의 배열 순회
        for (int i : A[v]) {
            // 연결 노드 중 방문하지 않았던 노드만 탐색
            if(visited[i] == false) {
                //재귀
                DFS(i);
            }
        }
    }
}
