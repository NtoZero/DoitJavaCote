package soli.ch4;

import _problems.ch4.ch4_arrays.P21_1517;

import java.io.*;
import java.util.StringTokenizer;

public class RE_BOJ1517 implements P21_1517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);  // 왼쪽 자르기
            mergeSort(arr, mid+1, right);   // 오른쪽 자르기
            merge(arr, left, right, mid);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid) {

        int l = left;
        int r = mid +1;
        int k = left;

        int count = 0;

        int[] result = new int[right - left + 1];

        while(l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                result[k++] = arr[l];
                l++;
            }
            else if(arr[r] <= arr[l]) {
                result[k++] = arr[r];
                r++;

                count += mid - l + 1;
                /**
                 * mid - l + 1은 현재 병합 중에 발생한 인버전의 개수를 계산합니다.
                 * mid는 현재 서브 배열의 중간 지점을 가리키며, l은 왼쪽 서브 배열의 현재 위치를 가리킵니다.
                 * 따라서 mid - l + 1은 현재 l 위치에서 mid 위치까지의 원소 개수를 나타냅니다.
                 * 이 범위 내에서 arr[r]보다 작은 값들이 있을 수 있으며, 이들이 인버전으로 처리됩니다.
                 *
                 * 예를 들어, 다음과 같은 배열에서 인버전을 계산하는 경우를 생각해보겠습니다:
                 *
                 * [3, 5, 7, 2, 4, 6]
                 * 여기서 mid는 2, l은 0이라고 가정합니다.
                 * mid - l + 1은 3이 됩니다. arr[l]에서 arr[mid]까지의 원소는 [3, 5, 7]이고,
                 * arr[r]보다 작은 값 2가 있으므로 count에 3이 추가됩니다. 따라서 인버전의 개수는 3개가 됩니다.
                 */
            }
        }

        // 왼쪽이 중간값보다 커지면 -> 왼쪽은 정렬 다 끝남 -> 결과값 그대로 저장
        // 오른쪽은 안 끝난 상태여야 함0
        if(l > mid) {
            while(r <= right) {
                result[k++] = arr[r];
                r++;
            }
        } else {
            while(l <= mid) {
                result[k++] = arr[l];
                l++;
            }
        }

        for(int i = 0 ; i < result.length ; i++) {
            arr[i] = result[i];
        }
    }
}
