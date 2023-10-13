package soli.ch3;

import problems.ch3_data_structure.ch3_1_sumNumbers.P1_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N개의 숫자 공백없이 입력 -> 모두 합해서 출력
 */
public class BOJ11720 implements P1_11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 먼저 입력받는 정수의 개수 N

        String str = br.readLine(); // 공백없이 입력되는 N개의 숫자
        char[] charArr = str.toCharArray(); // String 문자열 char 배열로 변경 (한 글자씩 쪼갬)

        int sum = 0;    // N개의 합
        for(int i = 0 ; i < N ; i++) {
            sum += charArr[i] - '0';
        }
        System.out.println(sum);
        br.close();
    }
}

//public class BOJ11720 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());    // 먼저 입력받는 정수의 개수 N
//
//        String str = br.readLine(); // 공백없이 입력되는 N개의 숫자
//        int sum = 0;    // N개의 합
//        for(int i = 0 ; i < N ; i++) {
//            sum += str.charAt(i) - '0';
//        }
//        System.out.println(sum);
//        br.close();
//    }
//}
