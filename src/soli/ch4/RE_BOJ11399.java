package soli.ch4;

import _problems.ch4.ch4_arrays.P18_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_BOJ11399 implements P18_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(arr);

        for(int i = 1 ; i < N ; i ++) {

            int num = arr[i];
            int j = i - 1;

            // num 이 arr[j]보다 작으면 arr[j+1] = arr[j]
            while(j >= 0 && num < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            // 나올 때는 앞의 원소가 num 보다 작을 때
            arr[j+1] = num;
        }


        int sum = 0;
        int result = 0;

        for(int i : arr) {
            sum += i;
            result += sum;
        }

        System.out.println(result);
    }
}
