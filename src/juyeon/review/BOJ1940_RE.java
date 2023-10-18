package juyeon.review;

import _problems.ch3_data_structure.ch3_3_two_pointer.P7_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940_RE implements P7_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = N;
        int count = 0;

        while (start < end) {
            if(arr[start] + arr[end] < M) {
                start++;
            } else if(arr[start] + arr[end] == M) {
                count++;
                start++;
                end--;
            } else if(arr[start] + arr[end] > M) {
                end--;
            }
        }

        System.out.println(count);
    }
}
