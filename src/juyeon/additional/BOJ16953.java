package juyeon.additional;

import _problems.ch5_searching.ch5_2_bfs.PP2_16953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16953 implements PP2_16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(BFS(A, B));
    }

    private static int BFS(long A, long B) {
        Queue<Long> q = new LinkedList<>();
        q.add(A);

        int count = 0;

        while (!q.isEmpty()) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                long v = q.poll();

                if (v == B) {
                    return count + 1;
                }

                if (v * 2 <= B) q.add(v * 2);
                if (v * 10 + 1 <= B) q.add(v * 10 + 1);
            }
            count++;
        }
        return -1;
    }

}

// 2 162
// 5

// 4 42
// -1