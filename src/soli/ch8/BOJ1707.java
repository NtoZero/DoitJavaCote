package soli.ch8;

import _problems.ch8_graph.P48_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이분 그래프 판별하기
public class BOJ1707 implements P48_1707 {

    static ArrayList<Integer>[] arr;

    // 방문 체크하는 배열
    static boolean[] visited;

    // 인접
    static int[] check;

    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼
        for(int i = 0 ; i < K ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 노드 수
            int V = Integer.parseInt(st.nextToken());
            // 엣지 수
            int E = Integer.parseInt(st.nextToken());
            // 엣지 수 만큼 입력 받기

            // 노드 수만큼의 배열리스트 초기화 (테스트케이스마다)
            arr = new ArrayList[V+1];

            for(int j = 1; j <= V ; j++) {
                arr[j] = new ArrayList<>();
            }

            visited = new boolean[V+1];
            check = new int[V+1];

            for(int j = 0 ; j < E ; j++) {
                st = new StringTokenizer(br.readLine());
                // 인접한 u, v 정점 번호
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                arr[u].add(v);
                // 양방향 그래프
                arr[v].add(u);
            }

            isBipartite = true;

            for(int j = 1 ; j <= V ; j++) {
                if(!visited[j]) {
                    // check 배열(색칠) 에 1넣기
                    if(!dfs(j, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    private static boolean dfs(int start, int c) {
        visited[start] = true;
        check[start] = c;

        // 배열리스트 arr[start] 순회하기
        // 재귀
        for(int i : arr[start]) {
            // i 방문 안 했으면 방문해서 반복
            if(!visited[i]) {
                // c에는 1아니면 2
                // 재귀조건 만족 못할 때 -> false 나오면 false
                // c색으로 색칠되어 있으면 3-c
                if(!dfs(i, 3 - c)) return false;
            } else if (check[i] == check[start]) {  // check[i] 랑 check[start]에 같은 수 들어있으면 false
                return false;
            }
        }
        return true;
    }
}