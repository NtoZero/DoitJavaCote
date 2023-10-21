package juyeon.review;

import _problems.ch3_data_structure.ch3_5_stack_queue.P14_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286_RE implements P14_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);

                if (a == b) {
                    return o1 < o2 ? -1 : 1;
                } else {
                    return a < b ? -1 : 1;
                }
            }
        });

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                q.add(x);
            } else {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
