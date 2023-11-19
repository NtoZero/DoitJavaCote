package juyeon.ch5;

import _problems.ch5_searching.ch5_3_binary_search.P29_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29_BOJ1920 implements P29_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arrN = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        // 자바 기본 정렬은 O(nlogn) 이라고 하네용 ( p182)
        Arrays.sort(arrN);

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        int[] arrM = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = arrM[i];

            int start = 0;
            int end = N - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int v = arrN[mid];

                if (v < target) {
                    start = mid + 1;
                } else if (v > target) {
                    end = mid - 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }
}
