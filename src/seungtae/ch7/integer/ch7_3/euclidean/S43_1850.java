package seungtae.ch7.integer.ch7_3.euclidean;

import _problems.ch7_integer.ch7_3_euclidean.P43_1850;

import java.util.*;
import java.io.*;

public class S43_1850 implements P43_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long count = GCD(A, B);
        for(int i=0; i< (int) count; i++) {
            bw.write("1");
        }
//        while(count >0) {
//            bw.write("1");
//            count--;
//        }
        bw.close();
    }

    public static long GCD(long num1, long num2) {
        if (num2 == 0)
            return num1;
        else
            return GCD(num2, num1%num2);
    }
}
