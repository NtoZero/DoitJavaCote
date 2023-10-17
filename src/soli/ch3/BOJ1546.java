package soli.ch3;

import _problems.ch3_data_structure.ch3_1_sumNumbers.P2_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 평균 구하기
 * 최대값 M
 * 기존점수 / M * 100 => 평균
 * 시험 본 과목의 개수 N <=1000
 * 0 <=현재성적 <= 100
 */
public class BOJ1546 implements P2_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // 공백 문자열 분리

        // 배열에 과목, 점수 넣기
        double[] arr = new double[N];
        for(int i = 0; i < N ; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        // 제일 높은 점수 M 검색
        Arrays.sort(arr);
        double M = arr[N-1];

        // 평균 구하기 (arr[0]+arr[1]+arr[2]+...+arr[N-1])/M*100/N
        double sum = 0;
        for(int i = 0 ; i < N ; i++) {
            sum += arr[i];
        }

        double avg = sum / M * 100 / N;

        System.out.println(avg);
    }
}