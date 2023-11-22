package juyeon.ch6;

import _problems.ch6_greedy.P33_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q33_BOJ1715 implements P33_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int a;
        int b;
        int sum = 0;

        while (q.size() != 1) {
            a = q.remove();
            b = q.remove();

            q.add(a + b);
            sum += a + b;
        }

        System.out.println(sum);
    }
}
