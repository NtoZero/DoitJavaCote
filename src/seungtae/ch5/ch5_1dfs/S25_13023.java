package seungtae.ch5.ch5_1dfs;

import _problems.ch5_searching.ch5_1_dfs.P25_13023;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S25_13023 implements P25_13023 {
    /*
        - 문제 요약 : 깊이가 5인 노드가 존재하면 1, 아니면 0을 출력.
        - 시간 제한 : 2초
            - N (N<=2*10^3), E(<=2*10^3) => dfs 활용 O(N)
                => N 2000, E 2000일 때 모든 노드를 진행했을 때 시간복잡도는 8,000,000 (2,000+2,000)*2,000

        1. 인접 리스트 배열 구현 (2차원 배열)
        2. boolean 배열 구현 - 방문 여부
        3. 스택 구현
     */

    static ArrayList<Integer>[] A; //인접리스트 배열 구현
    static boolean[] visited; //방문했는지 여부 배열
    static boolean arrived; // arrived at depth 5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드의 수
        int E = Integer.parseInt(st.nextToken()); // 관계(엣지)의 수

        A = new ArrayList[N]; // 노드는 0부터 N-1까지 존재. 인덱스가 노드, 즉 사람이 된다.
        visited = new boolean[N]; // 해당 노드(인덱스)를 방문했는지 여부.

        // 1. 인접 그래프 배열 초기화
        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }

        // 2. 간선 수 만큼 인접그래프 배열에 노드 관계 대입
        for(int i=0; i<E; i++) { // i는 엣지(관계)만큼 반복된다.
            st = new StringTokenizer(br.readLine());
            // 친구 노드
            int node = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());

            // 친구 관계는 양방향 그래프이므로 양 노드에 추가
            A[node].add(friend);
            A[friend].add(node);
        }

        // 3. 노드 수 만큼 dfs 반복
        for(int i=0; i<N; i++) {
            if(!visited[i])
                dfs(i, 1); // depth는 1부터 시작
        }

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                break;
            }
        }
        bw.write(String.valueOf(arrived ? 1 : 0));
        bw.close();
    }

    public static void dfs(int vertex, int depth) {
        if(depth ==5 || arrived==true) {
            arrived = true;
            return;
        }

        //해당 정점을 방문한 적 있으면 종료
        if(visited[vertex]) return;

        //방문 전적이 없다면 true로 전환
        visited[vertex] = true;

        for(int adjacency : A[vertex]) { //vertex의 인접 노드를 순회하며
            // 방문한 적 없는 인접 노드만 순회
            if(!visited[adjacency])
                //재귀
                dfs(adjacency, depth+1); // 다음 호출 스택에 depth+1을 넘겨준다.
        }
        // 한 번 방문한 곳이라도 depth를 확인하기 위해서 재방문해야 한다.
        visited[vertex] = false;
    }
}

/*
    예제2   0 -> 1 -> 2 -> 3 (4)
0	1,3
1	0,2,4
2	1,3
3	2,0
4	1

    예제4
0	4
1	7
2	7
3	7,4,5
4	7,3,6,0
5	3
6	4
7	1,3,4,2
 */