package soli.ch8;

import _problems.ch8_graph.P47_1325;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325_bfs implements P47_1325 {

    // 배열 리스트
    static ArrayList<Integer>[] arr;

    // 신뢰관계 방문 저장하는 배열
    static int[] count;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 컴퓨터 대수(노드수)
        int N = Integer.parseInt(st.nextToken());
        // 신뢰하는 관계(엣지수 -> 반복횟수)
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
        }

        count = new int[N+1];

        // visited = new boolean[N+1]
        // 일반적으로는 이렇게 되는데 초기화를 for문 안에서 시켜줘서 미방문 상태가 되고
        // 노드마다 다시 방문하게 됨
        for(int i = 1; i <= N ; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        int max= 0;

        for(int i = 1 ; i <= N ; i++) {
            // bfs 탐색하고 나서 max값 찾기
            max = Math.max(max, count[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i<= N ; i++) {
            if(max == count[i]) {
                bw.write(i + " ");
                bw.close();
            }
        }
    }

    private static void bfs(int start) {
        visited[start] = true;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);

        while(!Q.isEmpty()) {
            int current = Q.poll();

            for(int i : arr[current]) {
                if(!visited[i]) {
                    // 방문 배열 count++
                    count[i]++;
                    visited[i] = true;
                    // 큐 업데이트
                    Q.add(i);
                }
            }
        }
    }
}

