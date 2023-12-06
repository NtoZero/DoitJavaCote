package juyeon.ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유클리드 호제법 https://imkh.dev/algorithm-gcd-lcm

public class Q42_BOJ1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 최소공배수( A * B / 최대공약수)
            System.out.println(A * B / gcd(A, B));
        }
    }

    // 최대공약수
    private static int gcd(int A, int B) {
        while (A != 0) {
            int r = B % A;
            B = A;
            A = r;
        }
        return B;
    }

}
