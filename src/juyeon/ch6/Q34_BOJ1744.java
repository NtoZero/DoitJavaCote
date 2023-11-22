package juyeon.ch6;

import _problems.ch6_greedy.P34_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q34_BOJ1744 implements P34_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        // 1은 곱하는 것보다 더할 때 수가 커짐
        int one = 0;

        // 음수 * 0
        int zero = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int e = Integer.parseInt(br.readLine());

            if (e > 1) {
                positive.add(e);
            } else if (e < 0) {
                negative.add(e);
            } else if (e == 0) {
                zero++;
            } else if (e == 1) {
                one++;
            }
        }

        int sum = 0;

        while (positive.size() > 1) {
            int a = positive.poll();
            int b = positive.poll();

            sum += a * b;
        }

        if (!positive.isEmpty()) {
            sum += positive.poll();
        }

        while (negative.size() > 1) {
            int a = negative.poll();
            int b = negative.poll();

            sum += a * b;
        }

        if (!negative.isEmpty()) {
            if (zero == 0) {
                sum += negative.poll();
            }
        }

        sum += one;
        System.out.println(sum);

    }
}