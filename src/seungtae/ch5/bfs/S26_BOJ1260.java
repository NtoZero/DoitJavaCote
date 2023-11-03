package seungtae.ch5.bfs;

import _problems.ch5_searching.ch5_2_bfs.P26_1260;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class S26_BOJ1260 implements P26_1260 {
    /*
        알고리즘 : BFS (너비 우선 탐색)
            - 요구
                1. 방문 배열
                2. 그래프 (인접 리스트 배열) OR 2차원 배열
                3. 큐 (FIFO)
            - 절차
                1. BFS를 시작할 노드를 정한 후 사용할 자료구조 초기화하기
                2. 큐에서 노드를 꺼낸 후 꺼낸 노드의 인접 노드를 다시 큐에 삽입
                3. 큐에 노드가 존재하지 않을때까지 반복
     */
    /*
        정점의 개수 N (10^3)
        간선의 개수 M (10^4)
        탐색을 시작할 정점의 번호 V

     */
    static ArrayList<Integer>[] A; // 인접 리스트 배열
    static boolean[] visited; // 방문 배열
    static Queue<Integer> queue; // bfs용 큐
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1]; // 1부터 시작
        visited = new boolean[N + 1]; // 1부터 시작
        queue = new ArrayDeque<>(N);

        // 인접 그래프 배열 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 양방향 인접 그래프 그리기
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int near = Integer.parseInt(st.nextToken());

            A[node].add(near);
            A[near].add(node);
        }
        //dfs
        for (int i = 1; i <= N; i++) {
            // 인접 노드가 여러 개라면 숫자가 적은 것부터 방문 (해당 행 내림차순 정렬 - 스택, LIFO)
            A[i].stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); // NlogN

            if (!visited[i]) {
                dfs(i, 1);
            }
        }

        sb.append("\n"); // bfs 이전 개행
        //방문 배열 초기화
        for(int i=1; i<=N; i++) {
            visited[i] = false;
        }

        //bfs
        for (int i = 1; i <= N; i++) {
            // 인접 노드가 여러 개라면 숫자가 적은 것부터 방문 (FIFO, 오름차순 정렬)
            A[i].stream().sorted().collect(Collectors.toList());

            // 방문한 적 없다면
            if(!visited[i]) {
                bfs(i);
            }
        }

        System.out.println(sb);
    }
        static void dfs ( int vertex, int depth ){
            //방문 했으면 종료
            if(visited[vertex]) return;

            // 방문 전적이 없다면 true로 전환
            visited[vertex] = true;

            for(int adjacency : A[vertex]) { // 해당 노드의 인접 리스트 순회
                sb.append(adjacency + " ");
                // 방문 x 인접 노드만 순회
                if(!visited[adjacency])
                    dfs(adjacency, depth+1);
            }
        }

        static void bfs (int vertex) {
            if(visited[vertex]) return;

            visited[vertex] = true;

            // 큐에 원소 포함하기
            for(int adj : A[vertex]) {
                queue.add(adj);
            }
            // FIFO하며 방문하기
            int poll = queue.poll();
            sb.append(poll+ " ");
            bfs(poll);
        }
}
