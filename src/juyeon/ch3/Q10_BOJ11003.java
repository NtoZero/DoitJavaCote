package juyeon.ch3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11003
public class Q10_BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        for( int i = 1; i <= N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for( int i = 1; i <= N; i++ ) {
            Q.add(arr[i]);
            if( Q.size() < L ) {
                bw.write(Q.peek() + " ");
            } else {
                bw.write(Q.poll() + " ");
                Q.add(arr[i]);
            }
        }

        bw.flush();
        bw.close();


    }
}


//12 3
//1 5 2 3 6 2 3 7 3 5 2 6