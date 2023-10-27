package seungtae.ch4;

import _problems.ch4.ch4_arrays.P21_1517;

import java.io.*;
import java.util.StringTokenizer;

public class S21_BOJ1517_RE implements P21_1517 {
    /*
        시간 제한 : 1초, 메모리 제한 : 512MB
        N : 5*10^5, A[i]: 10^9

        - 권장 시간 복잡도 : NlogN 이하

        - 문제 풀이:
            실제로 버블 정렬을 하게 된다면 N^2으로 권장 시간 복잡도를 초과 한다.
            중앙 피봇 퀵정렬 또는 머지 소트를 이용한다.

            스왑 여부는 정렬된 배열과 원본 배열 값의 인덱스 차이를 따진다.
     */
    static int[] arr, tmp;
    // 자리의 이동을 카운트
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        arr = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

        bw.write(String.valueOf(count) );
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        // 탈출 조건
        if(end-start <1) return;

        // 중앙 값 병합 정렬
        int mid = start+(end-start)/2;

        // 분할(Divide)
        mergeSort(start, mid);
        mergeSort(mid+1, end);

        // arr -> tmp 배열 복사
        for(int i=start; i<=end; i++) {
            tmp[i] = arr[i];
        }

        // idx는 arr부터 새롭게 정렬되어야 한다.
        int idx = start;
        int low = start;
        int high = mid+1;

        // 정복(Conquer)
        while(low<=mid && high <= end) {
            if(tmp[low]<=tmp[high]) {
                arr[idx++] = tmp[low++];
            } else { // tmp[low]<tmp[high]
                 arr[idx] = tmp[high++];
                 // 오름차순이므로, high 쪽의 데이터 값이 적은 경우에 그 인덱스 차이를 count
                 count += high-idx;
            }
        }

        // 두 집단 중 남은 한 집단 정복
        while(low<=mid) {
            arr[idx++] = tmp[low++];
        }

        while(high<=end) {
            arr[idx++] = tmp[high++];
        }

    }
}
