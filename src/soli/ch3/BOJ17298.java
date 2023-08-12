package soli.ch3;


import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] nge = new int[n];

        Stack<Integer> stack = new Stack<>();

        String[] str = br.readLine().split(" ");

        for(int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        // 배열 i번째 부터 (arr.length = n)까지 오른쪽에 있는 거 비교
        for(int i = 0 ; i < n ; i ++) {
            // 오른쪽에 더 이상 아무것도 없는 게 아니고 arr[stack.peek] < arr[i] 이 때 까지
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        // 만약에 스택이 비어있지 않으면
        while (!stack.empty()) {
            // -1 넣어
            nge[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < n ; i ++) {
            bw.write(nge[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
