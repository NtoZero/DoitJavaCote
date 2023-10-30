package juyeon.ch4;

import _problems.ch4.ch4_arrays.P22_10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q22_BOJ10989 implements P22_10989 {

    public static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        // 기수 정렬 이해 못해서 걍 병합 정렬로 풀었습니다 . . . .
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int pnt1 = start;
        int pnt2 = mid + 1;
        int idx = start;

        while (pnt1 <= mid && pnt2 <= end) {
            if (temp[pnt1] < temp[pnt2]) {
                arr[idx] = temp[pnt1];
                pnt1++;
            } else {
                arr[idx] = temp[pnt2];
                pnt2++;
            }
            idx++;
        }

        while (pnt1 <= mid) {
            arr[idx] = temp[pnt1];
            pnt1++;
            idx++;
        }

        while (pnt2 <= end) {
            arr[idx] = temp[pnt2];
            pnt2++;
            idx++;
        }
    }
}
