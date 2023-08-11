package juyeon.ch3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 1; i <= N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);       // 오름차순 정렬 ( 투 포인터 활용하기 좋게)

        int start = 1;
        int end = N;
        int count = 0;

        while( start < end ) {
            if( arr[start] + arr[end] < M ) {
                start++;
            } else if( arr[start] + arr[end] == M ) {
                count++;
                start++;
                end--;
            } else {
                end--;
            }
        }

        System.out.println(count);

    }
}
