package soli.ch8;

import _problems.ch8_graph.P47_1325;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 효율적으로 해킹하기 ㅋㅋㅋ
public class BOJ1325 implements P47_1325 {

    // 신뢰관계 저장할 배열리스트
    static ArrayList<Integer>[] arr;

    // 방문배열 저장
    static boolean[] visited;

    // 신뢰관계 count 하는 배열
    static int[] count;

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

//        visited = new boolean[N+1];

        int max = 0;

        for(int i = 1 ; i <= N ; i++) {
            // 각 노드마다 visited 초기화
            visited = new boolean[N+1];
            dfs(i);
        }

        for(int i = 1 ; i <= N ; i++) {
            max = Math.max(max, count[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i<= N ; i++) {
            if(max == count[i]) {
                bw.write(i + " ");

            }
        }
        bw.close();
    }


    private static void dfs(int start) {
        // 방문하면 start
        visited[start] = true;

        // arr[start]에 해당하는 배열 다 방문
        for(int i : arr[start]) {
            if (!visited[i]) {
                count[i]++;
                dfs(i);
            }
        }
    }
}
