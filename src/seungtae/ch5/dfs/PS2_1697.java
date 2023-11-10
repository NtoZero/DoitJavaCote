package seungtae.ch5.dfs;

import _problems.ch5_searching.ch5_1_dfs.PP2_1697;

import java.util.*;
import java.io.*;

public class PS2_1697 implements PP2_1697 {
    /*
        * 문제 분석 : N 노드가 K 노드에 도달하는 최단거리 파악하기
        - 노드를 연결하는 방식 x+1, x-1, 2x (X에 N 대입)
        - N <= 10^5, K<=10^5 (단, K가 N보다 크다는 말은 없음에 주의)

        * 문제 풀이 가설
        - 2N했을 때의 목표 거리와 N+1 또는 N-1 했을 때의 목표 거리를 비교하여 짧은 순?
            => 5-10-9-18-17이 설명되지 않음.
        방법1) 분기 처리 (점화식 세우기)
            (1) 2N +- 1의 좌표가 목표 좌표에 더 가깝다.
            (2) 2(N +- 1)의 좌표가 목표 좌표에 더 가깝다.
            => plus(), minus(), jump()로 동작을 분할하여 (1) 또는 (2)의 로직에 따라 메서드를 실행한다.
        방법2) bfs (최단 거리를 탐색 하여야 하므로)
            (1) 2N, N-1, N+1을 각각 큐(노드의 인접 좌표)에 추가한다.
            (2) 이동할 때마다 해당 분기점에서 이동할 수 있는 좌표를 추가한다.
            (3) 가장 짧게 이동한 횟수를 결과로 출력한다.
        방법3) dfs (목표 K에 도달하는 가장 짧은 depth를 출력하면 되므로)
            (1) 목표 K에 도달할 때까지 2N, N+1, N-1을 재귀로 돌린다. (stack)
                - 현재 위치가 목표 K보다 길 때는 무조건 N-1만을 사용한다.
            (2) depth를 기록하여 가장 짧은 depth를 결과로 출력한다.

        * 문제 풀이 채택
            => dfs로 접근했을 경우 SOF가 발생할 수 있다. 재귀적으로 호출하기 때문에 운이 좋으면 바로 찾아낼 수 있지만
               잘못된 과정으로 접근하면 100,000이 넘어서는 지점까지 계속 호출한다.
            => bfs로 접근한다. (최단 거리)
     */
    static int count; // 몇 번 이동 했는지
    static Queue<Integer> queue = new ArrayDeque<>();
    static int[] visited = new int[100000+1]; // int로 방문 배열을 두게 되면 depth(초)를 기록할 수 있다.
    static int N;
    static int K; // 목표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(count);
    }

    private static void bfs(int n) {
        queue.add(n);

        int idx = n;
        int x = 0;
        visited[idx] = 1; //int배열의 디폴트 값이 0이므로 시작점을 1로 구분

        while(!queue.isEmpty()) {
            x = queue.poll();

            if(x == K) {
                count = visited[x]-1;
            }
            // x-1
            if(x-1>=0 && visited[x-1] == 0) {
                visited[x-1] = visited[x]+1;
                queue.add(x-1);
            }
            // x+1
            if(x+1 <= 100000 && visited[x+1] == 0) {
                visited[x+1] = visited[x]+1;
                queue.add(x+1);
            }
            // 2x
            if(2*x <= 100000 && visited[2*x] == 0) {
                visited[2*x] = visited[x]+1;
                queue.add(2*x);
            }
        }
    }


}
