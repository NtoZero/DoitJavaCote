package soli.ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램
 *
 * DFS (시간 복잡도 = V+E)
 * V : 노드 수, E : 엣지 수
 * 첫 번 째 줄에 연결 요소의 출력 개수 출력
 */
public class BOJ11724 {
    public static void main(String[] args) throws IOException {

        // 6 8
        // 1 -> 2
        // 2 -> 5
        // 5 -> 1
        // 3 -> 4
        // 4 -> 6
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 연결된게 적을 수록 ArrayList가 좋고, 많을 수록 배열이 좋음
        //   1 2 3 4 5 6
        // 1
        // 2
        // 3
        // 4
        // 5
        // 6
        // 이렇게 구성된 배열 구성해서 입력받으면 연결된 거니까 1넣어주기
        int[][] arr = new int[N+1][N+1];
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        int count = 0;
        // DFS 수행 -> 노드 방문해서 T, F 탐색
        boolean[] node = new boolean[N+1];
        for(int i = 1 ; i < N+1 ; i++) {
            // 노드 아직 방문 안 했으면 다 방문 할 때 까지
            if(node[i] == false) {
                dfs(arr, node, i);
                count++;
            }
        }

        System.out.println(count);
    }
    private static void dfs(int[][] arr, boolean[] node, int current) {

        // 노드 방문하면 true로 재정의
        node[current] = true;
        for(int i = 1 ; i < arr.length ; i++) {
            // 현재 방문했고 서로 연결 되어 있으면
            if(arr[current][i] == 1 && node[i] == false) {
                dfs(arr, node, i);
            }
        }
    }
}
