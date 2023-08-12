package juyeon.ch3;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class BOJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); // 출력할 결과물 저장
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        // 자연수..
        int num = 1;
        boolean result = false;

        for (int i = 1; i <= n; i++) {
            while (arr[i] >= num) {
                if (arr[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                } else {
                    result = true;
                }
                if (stack.peek() == num) {
                    stack.pop();
                    sb.append("-\n");
                }
            }

            if (result) {
                System.out.println("NO");
            } else {
                System.out.println(sb);
            }
        }
    }
}
