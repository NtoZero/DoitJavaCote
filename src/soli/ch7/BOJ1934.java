package soli.ch7;

import _problems.ch7_integer.ch7_3_euclidean.P42_1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유클리드 호제
// 최소공배수

public class BOJ1934 implements P42_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = A * B / gcd(A, B);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return gcd(a, b % a);   // b== 0 이 될 때 까지
        }
    }
}
