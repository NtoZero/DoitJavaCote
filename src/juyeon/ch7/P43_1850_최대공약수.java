package juyeon.ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P43_1850_최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        for (int i = 1; i <= gcd(A, B); i++) {
            sb.append(1);
        }

        System.out.println(sb.toString());


    }

    private static long gcd(long A, long B) {
        while (A != 0) {
            long r = B % A;
            B = A;
            A = r;
        }
        return B;
    }
}
