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

        PriorityQueue<Integer> posQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negQ = new PriorityQueue<>();

        // 1은 곱하는 것보다 더할 때 수가 커짐
        int one = 0;

        // 음수 * 0
        int zero = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int e = Integer.parseInt(br.readLine());

            if (e > 1) {
                posQ.add(e);
            } else if (e < 0) {
                negQ.add(e);
            } else if (e == 0) {
                zero++;
            } else if (e == 1) {
                one++;
            }
        }

        int sum = 0;

        while (posQ.size() > 1) {
            int a = posQ.poll();
            int b = posQ.poll();

            sum += a * b;
        }

        if (!posQ.isEmpty()) {
            sum += posQ.poll();
        }

        while (negQ.size() > 1) {
            int a = negQ.poll();
            int b = negQ.poll();

            sum += a * b;
        }

        if (!negQ.isEmpty()) {
            if (zero == 0) {
                sum += negQ.poll();
            }
        }

        sum += one;
        System.out.println(sum);

    }
}
