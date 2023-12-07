package juyeon.ch7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ❌❌❌ 런타임 에러 ( long 타입으로 받아야 되는데, long으로 받아도 배열 크기가 long 범위를 벗어나서 안 댐)
public class P41_11689_오일러_피 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        Queue<Integer> q = new LinkedList<>();

        // n 약수
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int e = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[i] % e == 0) {
                    arr[i] = 0;
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }

        System.out.println(count);

    }
}
