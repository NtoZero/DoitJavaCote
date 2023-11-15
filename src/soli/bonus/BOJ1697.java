package soli.bonus;

import _problems.ch5_searching.ch5_1_dfs.PP2_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1697 implements PP2_1697 {

    // 거리가 인덱스, 저장 값은 초
    static int[] distance = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = bfs(N, K);

        System.out.println(time);
    }

    private static int bfs(int N, int K){
        int[] move = {-1,1,2};

        visited[N] = true;

        int[] Q = new int[100001];  // 큐 배열
        int start = 0;
        int end = 0;

        Q[end++] = N;

        while(start < end) {
            int now = Q[start++]; // 큐에서 값을 꺼낼 때 start값 증가

            if(now == K) {
                return distance[now];   // K랑 현재 값 동일하면 distance 배열에 저장된 초 return
            }

            // move 배열의 연산 적용해서 다음 값 구하기
            for(int i = 0 ; i < 3 ; i++) {
                int next;
                if(i==2) {
                    next = now * move[i];
                }
                else {
                    next = now + move[i];
                }
                // next값 visted[next]의 위치에 저장하기
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    Q[end++] = next;
                    distance[next] = distance[now] + 1; // 다음 초 시간 지금 초 시간 +1
                }
            }
        }


        return 0;
    }
}
//import java.io.*;
//        import java.util.*;
//
//public class Main{
//    static int answer;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());		//수빈이 위치
//        int k = Integer.parseInt(st.nextToken());		//동생 위치
//        answer = Integer.MAX_VALUE;
//
//        dfs(n, k, 0);
//        System.out.println(answer);
//    }
//
//    public static void dfs(int n, int k, int count) {		//수빈이위치, 동생위치, 카운트
//        if( n >= k ) {
//            count += n - k;
//            if( answer > count ) {
//                answer = count;
//            }
//            return;
//        }
//
//        dfs(n, n, count + k - n);
//        if( n == 0 ) {
//            n = 1;
//            count++;
//        }
//
//        if( k % 2 == 1 ) {
//            dfs(n, k + 1, count + 1);
//            dfs(n, k - 1, count + 1);
//        }
//        else {
//            dfs(n, k / 2, count + 1);
//        }
//    }
//}