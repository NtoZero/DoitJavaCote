package seungtae.ch4;

import _problems.ch4.ch4_arrays.P17_1427;

import java.io.*;

public class S17_BOJ1427_RE implements P17_1427 {
    /*
            - 선택정렬(selection sort)은 대상 데이터에서 최대나 최소 데이터를 데이터가 나열된 순으로 찾아가며 선택
              최솟값 또는 최댓값을 찾고, 남은 정렬 부분의 가장 앞에 있는 데이터와 swap
         */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int[] arr = new int[N.length()];
        for(int i=0; i<N.length(); i++) {
            arr[i] = N.charAt(i)-'0';
        }

        int max = 0; // 첫번째 숫자 부터 시작
        int max_idx = 0; // max의 인덱스 (=j, 없어도 되지만 가독성)

        // 선택정렬 내림차순
        for(int i=0; i<arr.length-1; i++) {
            max = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                if(max<arr[j]) {
                    max = arr[j];
                    max_idx = j;

                    int tmp = arr[i];
                    arr[i] = max;
                    arr[max_idx] = tmp;
                }
            }
        }

        for(int i=0; i<arr.length; i++) {
            bw.write(arr[i]+"");
        }
        bw.close();
    }
}
