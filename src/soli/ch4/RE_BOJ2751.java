package soli.ch4;

import _problems.ch4.ch4_arrays.P20_2751;

import java.io.*;

public class RE_BOJ2751 implements P20_2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(arr, 0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

        // 0,1 비교 , 1,2 비교 , 2,3 비교 , 3,4 비교 ...
        // 어떻게 분할 하지... => 재귀

        public static void divide(int[] arr, int left, int right) {
            if(left < right) {
                int mid = (left + right) / 2;

                divide(arr, left, mid);
                divide(arr, mid + 1 , right);

                merge(arr, left, mid, right);
            }
        }


        public static void merge(int[] arr, int left, int mid, int right){

            int i = left;   // 왼쪽 시작점
            int j = mid + 1;    // 오른쪽 시작 점
            int k = 0;

            // N은 못 씀
            // 재귀하면 바뀜
            // 인덱스라서 오-왼+1
            int[] result = new int[right - left + 1];

            // 반반 다 정렬 되고 나서
            // i가 mid 전이고 j가 right전일 때
            while (i <= mid && j <= right) {
                // 만약 arr[i] <= arr[j]
                if (arr[i] <= arr[j]) {
                    // 결과값에 작은 거 넣기
                    result[k++] = arr[i];
                    i++;
                } else {
                    result[k++] = arr[j];
                    j++;
                }
            }

            // 홀수 배열에서 사용되는 부분
            // 만약에 비대칭으로 배열 끝날 때 (나눠질 때)
            // 2,2,1 + 2,2,2 이런 식
            while (i <= mid) {
                result[k++] = arr[i++];
            }

            // 반대의 경우
            while (j <= right) {
                result[k++] = arr[j++];
            }
            for (int l = 0; l < result.length ; l++) {
                // left 에서 하나씩 증가 되어야 함
                arr[left + l] = result[l];
            }
        }
    }

