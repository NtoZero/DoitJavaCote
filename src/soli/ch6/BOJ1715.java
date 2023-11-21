package soli.ch6;

import _problems.ch6_greedy.P33_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 implements P33_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 삽입, 삭제, 정렬 자주 일어날 때는 우선순위 큐
        // 우선순위 큐 기본 정렬 오름차순
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++) {
            Q.add(Integer.parseInt(br.readLine()));
        }

        int a = 0;
        int b = 0;
        int sum = 0;
        while(Q.size() > 1) {
            a = Q.poll();
            b = Q.poll();
            // 누적
            sum += a + b;
            // 누적
            Q.add(a + b);
        }
        System.out.println(sum);
    }
}
