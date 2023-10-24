package seungtae.ch4;

import _problems.ch4.ch4_arrays.P17_1427;
import _problems.ch4.ch4_arrays.P19_11004;

import java.util.*;
import java.io.*;

public class S19_BOJ11004_RE implements P19_11004 {
    /*
        - 시간 제한 : 2초, N <= 5*10^6
        - 권장 시간 복잡도 : NlogN 이하

        - 퀵 정렬 : 기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬
            1. 분할(Divide): 배열을 피벗(pivot)을 기준으로 두 개의 하위 배열로 나눕니다. 피벗은 배열에서 선택한 원소로, 일반적으로 배열 중간에 위치한 원소를 선택합니다.
            2. 정복(Conquer): 두 개의 하위 배열에 대해 재귀적으로 퀵 정렬을 수행합니다.
            -. 결합(Combine): 아무것도 하지 않습니다. 퀵 정렬은 주어진 배열을 이미 분할하고 정렬된 하위 배열을 결합할 필요가 없기 때문입니다.

        - 퀵 정렬의 시간 복잡도 :
            - 평균 : O(NlogN)
            - 최악 : O(N^2)
                - 피벗을 처음 또는 마지막 원소로 선택할 때 이미 정렬된 배열이나 역순으로 정렬된 배열일 경우 O(N^2)
                - 중복된 원소가 많은 배열 (특히, 모든 원소가 동일한 경우)

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 단, 인덱스로 따지면 [K-1] 인덱스이어야 함.

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;
                                    //인덱스로 따지면 K-1이다.
        quick_sort(arr, start, end, K-1);

        bw.write(String.valueOf(arr[K-1]));
        bw.close();
    }

    private static void quick_sort(int[] arr, int start, int end, int K) {
        if(start < end) {
            int pivot = partition(arr, start, end);

            if(pivot==K) return; // K번째 수가 pivot이면 끝
            else if (K < pivot)
                quick_sort(arr, start, pivot-1, K);
            else // K > pivot
                quick_sort(arr, pivot+1, end, K);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // 시작 인덱스 +1이 end일 경우
        if(start +1 == end) {
            // 그리고 시작 인덱스의 값이 끝 인덱스 값보다 크면 스왑한다.
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }

        // 최악의 연산을 피하기 위해 중앙 인덱스(원래는 피봇)으로 분할한다.
        int middle = (start+end) / 2;
        swap(arr, start, middle); // 피봇(중앙 인덱스)을 첫 번째 요소로 이동하기 (i와 j의 움직임을 편하게 하기 위함)
        // 피봇을 다시 재정립 (스왑된 첫 요소값이 원래의 피봇 인덱스의 값이다.)
        int pivot = arr[start];
        int i = start+1;
        int j = end;

        // 피벗보다 작은 수가 나올 때까지 j--
        while(j >= start+1 && pivot < arr[j]) {
            j--;
        }

        // 피벗보다 큰 수가 나올 때까지 i++
        while(i <= end && pivot > arr[i]) {
            i++;
        }

        // j가 i 이상일 때 i 요소값과 j요소값을 바꿔주고 i++, j--
        if(i<=j) {
            swap(arr, i++, j--);
        }

        // 피벗 데이터를 나눠진 두 그룹의 경계 index에 저장
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
