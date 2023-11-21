package seungtae.greedy;

import _problems.ch6_greedy.P32_11047;

import java.util.*;
import java.io.*;

public class S32_11047 implements P32_11047 {

    public static void main(String[] args) throws IOException {
        // 입력.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }

        int count = 0; //필요한 동전의 개수
        // 가치가 큰 순으로 동전을 세어야 최소 개수를 구할 수 있다.
        for(int i= N-1; i>=0 ;i--) {
            count += K/A[i];

            K %= A[i];
        }

        System.out.println(count);
    }
}
