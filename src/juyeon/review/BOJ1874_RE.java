package juyeon.review;

import problems.ch3_data_structure.ch3_5_stack_queue.P11_1874;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874_RE implements P11_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 출력할 문자열 저장
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            while (arr[i] >= num) {
                stack.push(num);
                num++;
                sb.append("+\n");
            }
            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
            }
        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}