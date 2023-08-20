package soli.ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ11004 {
    public static void main(String[] args) throws IOException {

        // 수  N개 입력 후 오름차순 정렬, 앞에서 K번째 수 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int K = Integer.parseInt(num[1]);

        int[] arr = new int[N];

        String[] num2 = br.readLine().split(" ");

        for(int i = 0 ; i < N ; i ++) {
            arr[i] = Integer.parseInt(num2[i]);
        }

        Arrays.sort(arr);

        System.out.println(arr[K-1]);
    }
}
