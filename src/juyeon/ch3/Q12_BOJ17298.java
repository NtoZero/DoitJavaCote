package juyeon.ch3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q12_BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for( int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] nge = new int[N];
        for( int i = 1; i < N; i++ ) {

            while ( !stack.isEmpty() && arr[stack.peek()] < arr[i] ) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while( !stack.isEmpty() ) {
            nge[stack.peek()] = -1;
            stack.pop();
        }

        for( int i = 0; i < N; i++ ) {
            bw.write(nge[i] + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}
