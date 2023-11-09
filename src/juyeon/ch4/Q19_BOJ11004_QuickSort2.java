package juyeon.ch4;

import _problems.ch4.ch4_arrays.P19_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19_BOJ11004_QuickSort2 implements P19_11004 {
    public static void main(String[] args) throws IOException {
//    (4) QuickSort + "K" ( 지피티 개천재)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findKth(arr, 0, N - 1, K - 1);

        System.out.println(arr[K-1]);
    }

    public static void findKth(int[] arr, int start, int end, int K) {
        if (start < end) {
            int part = partition(arr, start, end);

            if (part == K) {
                return;
            } else if (part > K) {
                findKth(arr, start, part - 1, K);
            } else {
                findKth(arr, part + 1, end, K);
            }
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}


// 5 2
// 4 1 2 3 5

// 2