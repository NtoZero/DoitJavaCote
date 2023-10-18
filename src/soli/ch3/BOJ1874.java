package soli.ch3;

import problems.ch3_data_structure.ch3_5_stack_queue.P11_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ1874 implements P11_1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        for(int i = 0 ; i < n ; i++ ) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> results = new ArrayList<>();
        int num = 1;

        for(int i = 0 ; i < n ; i ++) {
            while(num <= A[i]) {
                stack.push(num);
                results.add("+");
                num++;
            }

            if(stack.peek() == A[i]) {
                stack.pop();
                results.add("-");
            } else {
                System.out.println("NO");
                return;
            }
        }
        for (String result : results) {
            System.out.println(result);
        }
    }
}
