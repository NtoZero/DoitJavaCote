package soli.ch4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arrayList);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < N ; i++) {
            bw.write(arrayList.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}

// =================================================시간 초과
///**
// * N(1<=N<=1,000,000)
// * 2초
// * 병합 정렬로 풀기
// */
//public class BOJ2751 {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//
//        for(int i = 0 ; i < N ; i ++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
////        long startTime = System.nanoTime();
//
//        // 출력 해야 함
//        // 병함 정렬 메서드 호출
//        // -> 배열이라서 right는 N-1
//        mergeSort(arr, 0, N - 1);
//
////        long endTime = System.nanoTime();
////        double elapsedTimeMillis = (double) (endTime - startTime) / 1000000;
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        for(int i = 0 ; i < N ; i++) {
//            bw.write(arr[i] + "\n");
//        }
////        bw.write("Elapsed time : " + elapsedTimeMillis + "milliseconds");
//        bw.flush();
//        bw.close();
//    }
//
//    private static void mergeSort(int[] arr, int left, int right) {
//        if (left >= right) {
//            return;  // 재귀 종료
//        }
//
//        int mid = (left + right) / 2;
//        mergeSort(arr, left, mid);  // 왼쪽 반 정렬
//        mergeSort(arr, mid + 1, right); // 오른쪽 반 정렬
//        merge(arr, left, mid, right);
//
//    }
//
//    /**
//     *
//     * @param a = 배열 int[] a
//     * @param left = 제일 왼쪽
//     * @param mid = 중간
//     * @param right = 배열 끝 점
//     */
//    private static void merge( int[] arr, int left, int mid, int right) {
//        int[] sorted = new int[arr.length];
//
//        int l = left;
//        int start = mid + 1; // 두번째 배열의 시작점
//        int idx = left; // 채워 넣을 배열의 인덱스
//
//        /**
//         * 제일 왼쪽이 중간 배열이랑 같거나 작고 시작점이 제일끝점보다 작거나 같을 때 까지
//         *
//         */
//        while (l <= mid && start <= right) {
//
//            // 만약에 왼쪽 배열이 오른쪽 배열보다 작거나 같을 떼
//            // 제일 왼쪽 배열 = arr[l] 그대로 -> 반복
//            // 왼쪽꺼 자리 다음으로 옮겨서 비교
//            if(arr[l] <= arr[start]) {
//                sorted[idx] = arr[l];
//                idx++;
//                l++;
//            }
//
//            // 아니면(왼쪽 배열이 오른쪽 배열보다 클 때)
//            // 자리 바꿔주고 오른쪽꺼 자리 다음으로 옮겨서 비교
//            else {
//                sorted[idx] = arr[start];
//                idx++;
//                start++;
//            }
//        }
//
//        // 만약에 왼쪽 배열이 다 sorting 됐을 때 (오른족은 아직)
//        // 오른쪽 부분만 배열에 차례로 채워줌
//        if(l > mid) {
//            while (start <= right) {
//                sorted[idx] = arr[start];
//                idx++;
//                start++;
//            }
//        }
//
//        // 만약에 오른쪽 배열이 다 sorting 됐을 때(왼쪽은 아직)
//        // 왼쪽만 배열에 차례로 채워줌
//        else if(start > right) {
//            while (l <=mid) {
//                sorted[idx] = arr[l];
//                idx++;
//                l++;
//            }
//        }
//
////        정렬된 배열을 기존의 배열에 복사해서 옮겨줌
//        for(int i = left; i <= right ; i++) {
//            arr[i] = sorted[i];
//        }
//    }
//}
// ==================================================================
//
//public class BOJ2751 {
//
//    public static void main(String[] args) throws IOException {
////        런타임 에러
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[N];
//
//        for(int i = 0; i <N ; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        for(int i = 0 ; i < N ; i++) {
//            bw.write(arr[i] + "\n");    // 한 줄씩 출력
//        }
//        bw.flush();
//        bw.close();
//    }
//}
