package seungtae.ch7.integer.ch7_1_prime_number;

import _problems.ch7_integer.ch7_1_prime_number.P40_1016;

import java.io.*;
import java.util.*;

public class S40_1016 implements P40_1016 {
    /*

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] notPow = new boolean[(int) (max-min+1)];

        for(long i = 2; i*i <=max; i++) {
            long pow = i*i; // 제곱수
            long sIdx = min / pow;
            if(min % pow != 0)
                sIdx++;
            for(long j = sIdx; pow *j <= max; j++) {
                notPow[(int) ((j*pow)-min)] = true;
            }
        }
        int count = 0;
        for(int i=0; i<=max-min; i++) {
            if(!notPow[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
