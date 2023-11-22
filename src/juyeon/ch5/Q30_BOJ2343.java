package juyeon.ch5;

import _problems.ch5_searching.ch5_3_binary_search.P30_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30_BOJ2343 implements P30_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if (start < arr[i]) start = arr[i];
            end += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        System.out.println(start);
    }
}


// 9 3
// 1 2 3 4 5 6 7 8 9