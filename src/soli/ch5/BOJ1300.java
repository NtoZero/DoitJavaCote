package soli.ch5;

import _problems.ch5_searching.ch5_3_binary_search.P31_1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ1300 implements P31_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long low = 1;
        long high = N * (long) N;
        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                // 중간값보다 작은 수 찾아서 count
                // mid = 4
                // 3 + 2 + 1 = 6
                count += Math.min(mid / i, N);
            }

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low);
    }
}

