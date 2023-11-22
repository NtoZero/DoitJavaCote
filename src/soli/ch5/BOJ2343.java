package soli.ch5;

import _problems.ch5_searching.ch5_3_binary_search.P30_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ2343 implements P30_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        // 저장할 강의 수
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for(int i = 0 ; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            end += A[i];
            if (A[i] > start) {
                start = A[i];
            }
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            // 강의 개수
            int count = 1;
            // 저장할 강의 길이
            int sum = 0;

            for(int i = 0 ; i <N ; i++){
                if(sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                // 강의 하나씩 더하기
                sum += A[i];
            }
            // 구해야하는 수보다 count가 더 크면
            if(count > M) {
                start = mid + 1;
            } else {
                // count가 더 작거나 같으면
                // 더 작은 크기도 되는지 확인 해야 함
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
