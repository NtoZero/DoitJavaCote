package soli.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P40_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1016 implements P40_1016 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        Map<Long, Boolean> map = new HashMap<>();
        for(long i = min ; i <= max ; i++) {
            map.put(i, true);
        }


        for(long j = 2 ; j * j <= max ; j++) {
            // 제곱수
            long square = j*j;
            long start = (min + square - 1) / square * square;
            for(long k = start ; k <= max ; k+= square) {
                map.put( k, false);
            }


        }

        int count = 0;
        for(boolean value : map.values()) {
            if(value) {
                count++;
            }
        }
        System.out.println(count);
    }
}
