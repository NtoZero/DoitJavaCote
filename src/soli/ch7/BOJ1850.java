package soli.ch7;

import _problems.ch7_integer.ch7_3_euclidean.P43_1850;

import java.io.*;
import java.util.StringTokenizer;

// 최대공약수 구하기
public class BOJ1850 implements P43_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = gcd(A, B);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (result > 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if(b==0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
}
