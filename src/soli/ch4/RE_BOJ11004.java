package soli.ch4;

import _problems.ch4.ch4_arrays.P19_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_BOJ11004 implements P19_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개의 수
        int N = Integer.parseInt(st.nextToken());
        // K번째 있는 수
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[K-1]);

//      퀵정렬 이용해서 풀기 -> 시간 초과 남....8ㅅ8....ㅠ
//        int result = quickSort(arr, 0, N-1, K-1);
//
//        System.out.println(result);
//    }
//
//    // k 번째 작은 값 찾기
//    private static int quickSort(int[] arr, int left, int right, int k) {
//        // 왼쪽 오른 쪽 똑같으면 끝
//        if(left == right) {
//            return arr[left];
//        }
//        // pivot_index 는 정렬된 pivot의 idx
//        int pivot_idx = partition(arr, left, right);
//        // 찾는 값이랑 pivot_idx랑 똑같으면 arr[k]그대로 리턴
//        if(k == pivot_idx) {
//            return arr[k];
//        } else if(k < pivot_idx) {
//            // 만약에 k가 더 작으면 현제 pivot_idx보다 작은 거 찾아야 함
//            return quickSort(arr, left, pivot_idx -1, k);
//        } else {
//            // 만약에 k가 더 크면 현제 pivot_idx보다 큰 거 찾아야 함
//            return quickSort(arr, pivot_idx +1, right, k);
//        }
//    }
//
//    private static int partition(int[] arr, int left, int right) {
//        // 피봇은 제일 오른 쪽 값
//        int pivot = arr[right];
//        // i는 pivot보다 작은 값 저장
//        int i = left-1;
//
//        // 피봇보다 작으면 작은 거 저장하기
//        for(int start_idx = left ; start_idx < right ; start_idx++) {
//            if(arr[start_idx] < pivot) {
//                // 피봇보다 작으면 작은 값 i에 저장
//                i++;
//                swap(arr, i, start_idx);
//            }
//        }
//        // 아니면 i기준값보다 오른쪽에 저장
//        swap(arr, i+1, right);
//
//        return i + 1;
//    }
//
//    private static void swap(int[] arr, int i, int j) {
//        int swap = arr[i];
//        arr[i] = arr[j];
//        arr[j] = swap;
    }
}