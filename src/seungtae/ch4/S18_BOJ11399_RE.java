package seungtae.ch4;

import _problems.ch4.ch4_arrays.P18_11399;

import java.util.*;
import java.io.*;

public class S18_BOJ11399_RE implements P18_11399 {
    /*
        N : 10^3 이하,
        알고리즘 N^2 이하 권장

        - 문제 풀이 : 시간이 가장 적게 걸리는 사람이 먼저 업무를 볼 수 있도록 해야 한다. (정렬)
                    그 배열의 합 배열을 구하면 된다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for(int i=1; i<N; i++) {
            int cursor = i;
            int cursorNum = arr[i];

            // j는 i-1부터 시작하여 점차 감소
            for(int j = i-1; j >= 0; j--) {
                // 삽입할 요소가 더 크면
                if(arr[j]<arr[i]) {
                    cursor = j+1;
                    break;
                }
                // 삽입할 요소가 더 작으면서 j가 0이면
                if(j==0) {
                    cursor = 0; // 삽입 위치도 0
                }
            }

            // j가 i로 시작하여 j가 삽입 인덱스보다 클 동안에는
            for(int j = i; j > cursor; j--) {
                // (삽입 인덱스 위치 비워주기 위해) 삽입 인덱스 기준으로 한 칸씩 우측으로 당기기
                arr[j] = arr[j-1];
            }
            // 올바른 삽입 위치에 삽입
            arr[cursor] = cursorNum;
        }

        // 합 배열
        int[] sumArr = new int[N];
        sumArr[0] = arr[0]; // 첫 원소는 같다.
        int sum = sumArr[0]; // 합배열의 합 (첫 원소부터 마지막 원소까지 더함)
        for(int i=1; i<N; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
            sum += sumArr[i];
        }

        bw.write(String.valueOf(sum));
        bw.close();
    }
}
