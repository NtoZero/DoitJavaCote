package seungtae.ch4;

import _problems.ch4.ch4_arrays.P20_2751;

import java.io.*;

public class S20_BOJ2751_RE implements P20_2751 {
    /*
        병합 정렬(Merge Sort)
        - 시간 복잡도 : O(NlogN)
        - 특징
            - 병합 정렬(Merge Sort)은 재귀적으로 배열을 분할하고 병합하여 정렬하는 분할 정복(Divide and Conquer) 알고리즘.
            - 이 알고리즘은 일반적으로 재귀 함수를 사용하여 구현
        - 구현
            1. 배열을 반으로 나누고 재귀적으로 정렬
            2. merge 메소드를 사용해서 정렬된 부분 배열을 병합
            3. 반복
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr);

        for(int a : arr) {
            bw.write(String.valueOf(a)+"\n");
        }
        bw.close();
    }

    static void mergeSort(int[] arr) {
        // arr의 길이가 1 이하이면 종료 (정렬된 것)
        if(arr.length<=1) return;

        // 중앙 값 찾아서 분할(Divide)
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];
            // 좌 배열 , 우 배열로 분할
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // 재귀 (좌, 우를 계속해서 길이가 1이 될 때까지 분할)
        mergeSort(left);
        mergeSort(right);

        // 정렬된 좌, 우 배열 병합
        merge(arr, left, right);
    }

    // 두 배열의 원소를 비교하며 정렬 및 병합된 배열 생성
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0; //좌 배열의 인덱스
        int j = 0; //우 배열의 인덱스
        int k = 0; //원본 배열의 인덱스

        // 두 포인터를 인덱스로 하여 좌, 우 배열에서 서로 비교. 원본 배열(arr)에 새롭게 덮어쓰기(병합)
        while(i < left.length && j < right.length) {
            // 작은 값들을 순서대로 넣기 (오름차순)
            if(left[i]< right[j]) {
                arr[k++] = left[i++];
            } else { // left[i] >= right[j]
                arr[k++] = right[j++];
            }
        }

        // 남아 있는 원소들은 지금까지 원본배열에 복사했던 원소들보다 크다.
            //또한, left 또는 right 둘 중 하나만 남아 있을 것이다. 모두 넣어 준다.
        while(i < left.length) {
            arr[k++] = left[i++];
        }

        while(j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
