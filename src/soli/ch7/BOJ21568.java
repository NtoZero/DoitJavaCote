package soli.ch7;

import _problems.ch7_integer.ch7_4_extended_euclidean.P45_21568;

import java.io.*;
import java.util.StringTokenizer;

// ax + by = c
// c % gcd(a,b) = 0
public class BOJ21568 implements P45_21568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long gcd = gcd(A, B);

        // 식이 성립하면  c % gcd(a,b) = 0 어야 하기 때문에 먼저 검증
        if(C % gcd != 0) {
            System.out.println("-1");
        }



    }


    // 최대공약수 gcd(a, b) 구하기
    private static long gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        else {
            return gcd(a, b%a);
        }
    }

}
