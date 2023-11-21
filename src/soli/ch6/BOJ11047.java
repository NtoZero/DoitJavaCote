package soli.ch6;

import _problems.ch6_greedy.P32_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 implements P32_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동전 종류 수
        int N = Integer.parseInt(st.nextToken());
        // 구해야 하는 수
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for(int i = 0; i<N ;i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int coin = 0;
        for(int i = N-1 ; i >= 0 ; i--) {
            if(A[i] <= K) {
                // 동전 개수 A[i] 나누기 K 한 동전 개수
                coin += K / A[i];
                // K = 나눈 나머지값에서 계속 반복해서 똑같아 질 때 까지
                K %= A[i];
            }
        }
        System.out.println(coin);
    }
}
