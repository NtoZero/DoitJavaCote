package soli.ch4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {

        // 사람 수 N , 걸리는 시간 P
        // 정렬해서 작은 수부터 정렬 -> 다 더하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");    // 공백으로 구분된 문자열을 배열로 분리

        // 배열에 넣기
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        Arrays.sort(arr);

        int plusTime = 0;
        int result = 0;

        for(int i = 0 ; i < N ; i++) {
            plusTime += arr[i];
            result += plusTime;
        }

        System.out.println(result);
    }
}
