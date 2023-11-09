package juyeon.ch4;

import _problems.ch4.ch4_arrays.P18_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18_BOJ11399_RE implements P18_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + arr[i];
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
