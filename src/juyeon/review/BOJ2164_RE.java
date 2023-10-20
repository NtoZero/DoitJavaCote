package juyeon.review;

import _problems.ch3_data_structure.ch3_5_stack_queue.P13_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164_RE implements P13_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.peek());
    }
}
