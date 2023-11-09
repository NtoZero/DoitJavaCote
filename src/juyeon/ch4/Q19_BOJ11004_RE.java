package juyeon.ch4;

import _problems.ch4.ch4_arrays.P19_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19_BOJ11004_RE implements P19_11004 {
    public static void main(String[] args) throws IOException {
//        (1) Arrays.sort 로 대충 풀기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(arr);
//
//        System.out.println(arr[K-1]);
//    }

//        -------------------------------------------------------------------------------

//        (2) 리스트로 풀기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        List<Integer> list = new ArrayList<>();
//
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            list.add(Integer.parseInt(st.nextToken()));
//        }
//
//        Collections.sort(list);
//
//        System.out.println(list.get(K-1));
//    }

//        -------------------------------------------------------------------------------


//        (3) 퀵 정렬로 풀기...!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int part = partition(arr, start, end);

            // 왼쪽
            quickSort(arr, start, part - 1);

            // 오른쪽
            quickSort(arr, part, end);
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