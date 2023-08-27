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

        // 출력 해야 함
        // 병함 정렬 메서드 호출
        // -> 배열이라서 right는 N-1
        mergeSort(arr, 0, N-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(count));
        bw.newLine(); // 줄바꿈 추가
        bw.close();

    }

    private static void mergeSort(long[] arr, int left, int right) throws IOException {
        // 시작점이 끝점보다 작을 때 까지 (끝까지 갈 때 까지)
        if(left < right) {

            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);

        }
    }

    /**
     *
     * @param a = 배열 int[] a
     * @param left = 제일 왼쪽
     * @param mid = 중간
     * @param right = 배열 끝 점
     */
    private static void merge(long[] arr, int left, int mid, int right) {
//        int[] sorted = new int[arr.length]; // 🚨 얘가 문제 -> 따로 넣어주면 재귀 불러질 때 마다 배열을 넣어주기 때문에

//        sorted = new long[arr.length];

        int l = left;
        int start = mid + 1;
        int idx = left;

        /**
         * 제일 왼쪽이 중간 배열이랑 같거나 작고 시작점이 제일끝점보다 작거나 같을 때 까지
         *
         */
        while (l <= mid && start <= right) {
            // 만약에 왼쪽 배열이 오른쪽 배열보다 작거나 같을 떼
            // 제일 왼쪽 배열 = arr[l] 그대로 -> 반복
            // 왼쪽꺼 자리 다음으로 옮겨서 비교
            if(arr[l] <= arr[start]){

                sorted[idx++] = arr[l++];

            }

            // 아니면(왼쪽 배열이 오른쪽 배열보다 클 때)
            // 자리 바꿔주고 오른쪽꺼 자리 다음으로 옮겨서 비교
            else if (arr[l] > arr[start]) {

                sorted[idx++] = arr[start++];
                // 남은 원소 개수 더해줌
                // 왼쪽은 이미 정렬된 상태이기 때문에 왼쪽 남은 원소는 오른쪽 원소보다 큼
                count += mid - l + 1;
            }
        }

        // 만약에 왼쪽 배열이 다 sorting 됐을 때 (오른족은 아직)
        // 오른쪽 부분만 배열에 차례로 채워줌
        while (l <= mid) {
            sorted[idx++] = arr[l++];
        }

        // 만약에 오른쪽 배열이 다 sorting 됐을 때(왼쪽은 아직)
        // 왼쪽만 배열에 차례로 채워줌
        while (start <= right) {
            sorted[idx++] = arr[start++];
        }
        // 정렬된 배열을 기존의 배열에 복사해서 옮겨줌
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}