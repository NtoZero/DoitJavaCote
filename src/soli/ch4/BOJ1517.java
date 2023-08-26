package soli.ch4;

import java.io.*;
import java.util.StringTokenizer;


/**
 * swap 이 몇 번인지 알아내라...
 * 시간 제한 1초
 * N(1<=N <= 500,000)
 * A(0<=A[i]<=1,000,000,000
 */
public class BOJ1517 {
    static long[] sorted;
    static long count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        sorted = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, N-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(count));
        bw.newLine(); // 줄바꿈 추가
        bw.close();

    }

    private static void mergeSort(long[] arr, int left, int right) throws IOException {

        if(left < right) {

            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);

        }
    }

    private static void merge(long[] arr, int left, int mid, int right) {

//        sorted = new long[arr.length];

        int l = left;
        int start = mid + 1;
        int idx = left;

        while (l <= mid && start <= right) {
            if(arr[l] <= arr[start]){

                sorted[idx++] = arr[l++];

            } else if (arr[l] > arr[start]) {

                sorted[idx++] = arr[start++];
                // 남은 원소 개수 더해줌
                // 왼쪽은 이미 정렬된 상태이기 때문에 왼쪽 남은 원소는 오른쪽 원소보다 큼
                count += mid - l + 1;
            }
        }

        while (l <= mid) {
            sorted[idx++] = arr[l++];
        }

        while (start <= right) {
            sorted[idx++] = arr[start++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}