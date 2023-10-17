package juyeon.review;

import _problems.ch3_data_structure.ch3_3_two_pointer.P8_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253_RE implements P8_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N-1;
            long k = arr[i];

            while (start < end) {
                if (arr[start] + arr[end] < k) {
                    start++;
                } else if(arr[start] + arr[end] > k) {
                    end--;
                } else if(arr[start] + arr[end] == k) {
                    // 찾는 수와 포인터의 인덱스가 다른지 확인!
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }
            }

        }

        System.out.println(count);
    }
}


// 5
// -2 0 1 2 3