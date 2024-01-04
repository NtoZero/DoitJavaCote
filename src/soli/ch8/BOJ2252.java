package soli.ch8;

import _problems.ch8_graph.P53_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 implements P53_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 명의 학생들
        int N = Integer.parseInt(st.nextToken());
        // 키를 비교한 횟수
        int M = Integer.parseInt(st.nextToken());

        // 학생, 관계 그래프
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 진입 차수 배열
        int[] indegree = new int[N+1];

        for(int i = 0 ; i <= N ; i++ ) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            indegree[B]++;  // B진입차수 증가

        }

        Queue<Integer> Q = new LinkedList<>();
        // 1부터 학생수만큼 돌면서 확인
        for(int i = 1 ; i <= N ; i++) {
            // 만약에 0 이면 큐에 저장
            if(indegree[i] == 0) {
                Q.add(i);   // 인덱스 번호 = 학생 번호
            }
        }

        while(Q.isEmpty()) {
            int current = Q.poll();
            System.out.println(current + " ");
            // 현재 연결된 진입 차수 감소
            for(int next : graph.get(current)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    Q.add(next);
                }
            }
        }

    }
}
