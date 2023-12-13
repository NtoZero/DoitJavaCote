package soli.ch8;

import _problems.ch8_graph.P46_18352;

import java.io.*;
import java.util.*;

public class BOJ18352 implements P46_18352{

    // 도시, 도로 인접 리스트
    static ArrayList<Integer>[] A;

    // 방문 거리 저장하는 배열
    static int[] visited;

    // 결과값 저장하는 ArrayList
    static ArrayList<Integer> result;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도시 개수
        int M = Integer.parseInt(st.nextToken());   // 도로 개수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시 번호

        // 인접 리스트 크기 = N (0부터 시작하니까 +1)
        A = new ArrayList[N+1];

        // X는 1이상, 도시개수만큼 리스트 저장
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        // 도로개수만큼 엣지 연결
        for(int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 각 리스트에 도착 도시 저장
            A[start].add(end);
        }

        result = new ArrayList<>();
        visited = new int[N+1];
        for(int i = 1; i <= N ;i++) {
            // 방문 하기 전 모든 배열 -1
            // 거리정보 초기화 => 0으로 하면 방문 한 도시, 안 한 도시 확인 못 함
            visited[i] = -1;
        }

        // bfs 반복
        bfs(X);

        for(int i = 1 ; i <= N ; i++) {
            if(visited[i] == K) {
                result.add(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        // 다 순회하고 K랑 똑같은 거 없으면
        // = result 배열에 아무것도 안 들어가 있으면
        if(result.isEmpty()) {
            bw.write("-1");
        } else {
            // 오름차순 정렬
            Collections.sort(result);
            for(int r : result) {
                bw.write(Integer.toString(r) + "\n");
            }
        }
        bw.close();
    }


    private static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        // 방문하면 visited 배열 더하기
        visited[x]++;

        while(!Q.isEmpty()) {
            int current = Q.poll();

            // current 와 인접한 도시 모두 방문하기
            for(int i : A[current]) {
                // 만약에 방문 안 한 도시 방문하면
                if(visited[i] == -1) {
                    // 지금까지 거리 +1 해서 갱신
                    visited[i] = visited[current] + 1;
                    Q.add(i);
                }
            }
        }
    }
}
