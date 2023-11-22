package seungtae.ch6.greedy;

import _problems.ch6_greedy.P33_1715;

import java.util.*;
import java.io.*;

public class S33_1715 implements P33_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 카드 개수가 가장 작은 2묶음을 먼저 조합
        Queue<Integer> q = new PriorityQueue<>(); // 우선순위 큐로 정렬 (우선순위 큐의 기본 정렬은 오름차순)
        for (int i=0; i<N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int num1=0, num2 = 0, sum = 0;
        while(q.size() != 1) {
            num1 = q.remove();
            num2 = q.remove();
            q.add(num1+num2);
            sum += num1 + num2;
        }
        System.out.println(sum);
    }
}
