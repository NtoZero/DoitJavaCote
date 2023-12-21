package soli.ch8;

import _problems.ch8_graph.P50_1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 implements P50_1717 {

    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n+1 개의 집합
        int N = Integer.parseInt(st.nextToken());
        // 연산의 개수
        int M = Integer.parseInt(st.nextToken());

        index = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            index[i] = i;
        }

        // 0 a b는 Union
        // 1 a b는 find
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());   // 0 이나 1
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(K == 0) {
                union(A, B);
            } else {
                check(A,B);
            }

        }

    }

    // 합집합 대표노드로 연결
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            // a = b로 바꾸기
            index[b] = a;
        }
    }

    private static int find(int a) {
        if(a == index[a]) {
            return a;
        } else {
            // 1 3 (1 1) -> 3 7 (3 3 -> 1 1)
            return index[a] = find(index[a]);
        }
    }

    private static void check(int a, int b) {

        a = find(a);
        b = find(b);

        System.out.println(a == b ? "YES" : "NO");

    }
}
