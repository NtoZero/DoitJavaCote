package juyeon.ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8_BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N+1];
        for( int i = 1; i <= N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        long find = 0;

        for( int i = 1; i <= N; i++ ){
            int start = 1;
            int end = N;
            find = arr[i];
            while ( start < end ) {
                if( arr[start] + arr[end] > find ) {
                    end--;
                } else if( arr[start] + arr[end] == find ) {
                    count ++;
                    break;
                } else {
                    start++;
                }
            }
        }

        System.out.println(count);

    }
}
