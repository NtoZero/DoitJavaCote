package juyeon.ch4;

import _problems.ch4.ch4_arrays.P20_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20_BOJ2751 implements P20_2751 {
//    public static void main(String[] args) throws IOException {
//        (1) Arrays.sort
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i]);
//        }
//    }

//        ================================================

//        (2) Collections.sort
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            list.add(Integer.parseInt(br.readLine()));
//        }
//
//        Collections.sort(list);
//
//        for (int i = 0; i < N; i++) {
//            System.out.println(list.get(i));
//        }
//    }

//        ================================================

//        (3) 우선순위 큐
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        PriorityQueue q = new PriorityQueue();
//
//        for (int i = 0; i < N; i++) {
//            q.add(Integer.parseInt(br.readLine()));
//        }
//
//        for (int i = 0; i < N; i++) {
//            System.out.println(q.poll());
//        }
//    }

//       ================================================

//        (4) 병합 정렬로 멋지게 풀어보기 ..... => 시간 초과 ㅇㅈㄹ

    public static int[] arr, temp;

    public static void main(String[] args) throws IOException {
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
            if (temp[pnt1] <= temp[pnt2]) {
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

// 5
// 5
// 4
// 3
// 2
// 1