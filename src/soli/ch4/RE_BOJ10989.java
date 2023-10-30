package soli.ch4;

import _problems.ch4.ch4_arrays.P22_10989;

import java.io.*;

public class RE_BOJ10989 implements P22_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = 0 ;
        for(int i = 0 ; i < N ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            // 제일 큰 수 찾기
            max = Math.max(max, arr[i]);
        }

        // 제일 큰 수의 자리 수 구하기
        int maxDigit = 0;
        while (max > 0) {
            max = max / 10 ;
            maxDigit++;
        }

        // 기수 정렬 반복
        radixSort(arr, maxDigit);

        for(int i = 0 ; i < N ; i ++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr, int maxDigit) {
        // 10에 (maxDigit - 1)제곱까지 반복
        // 자리수는 10에 0제곱부터 시작하기 때문에 -1
        for(int digit = 1; digit <= Math.pow(10, maxDigit -1); digit *= 10) {
            radix(arr, digit);
        }
    }

    private static void radix(int[] arr, int digit) {
        int N = arr.length;
        // 0 부터 9까지 저장할 배열
        int[] count = new int[10];
        // 결과값 저장할 베얄
        int[] result = new int[N];


        for(int i = 0 ; i < N ; i ++) {
            // 해당하는 번호의 개수 저장
            count[ (arr[i] / digit) % 10 ]++;
        }

        // 누적 합 구하기
        // 정렬된 배열에서 시작하는 부분 알 수 있음
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 정렬 -> 뒤에서 부터 순회
        // result 에 정렬된 결과 저장
        for (int i = N - 1; i >= 0; i--) {
            result[count[(arr[i] / digit) % 10] - 1] = arr[i];
            count[(arr[i] / digit) % 10]--;
        }

        // 원래 배열에 결과 복사
        for(int i = 0 ; i < N ; i ++) {
            arr[i] = result[i];
        }
    }
}
