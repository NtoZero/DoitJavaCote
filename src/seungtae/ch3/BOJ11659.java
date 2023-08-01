package seungtae.ch3;

import java.util.Scanner;

public class BOJ11659 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int N = scan.nextInt(); // 수의 개수 N
//        int M = scan.nextInt(); // 합 구하는 횟수 M
////        scan.nextLine();
//
//        // int배열로 인풋 값 받자마다 구간 합 배열 만들기
//        int[] numArr = new int[N+1];
//        numArr[0] = 0;
//        for(int i=1; i<=N; i++) {
//            numArr[i] = numArr[i-1] + scan.nextInt();
//        }
//        scan.nextLine();
//
//        // 구간 합 배열 만들기
////        int[] sumArr = new int[numArr.length];
////        sumArr[0] = numArr[0];
////        for(int i=1; i<sumArr.length; i++) {
////            sumArr[i] = numArr[i]+sumArr[i-1];
////        }
//
//        // M번 만큼 구간 합 조건 i와 j 받고 계산하기
//        for(int k=0; k<M; k++) {
//            // 구간 합 조건 i와 j 받기
//
//            int i = scan.nextInt();
//            int j = scan.nextInt();
//            scan.nextLine();
//
//            // 구간 합 계산하기
//            System.out.println(numArr[j]-numArr[i-1]);
//        }

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        int[] numArr = new int[N+1];
        for(int i=1; i<=N; i++) {
            numArr[0] = 0;
            numArr[i] = numArr[i-1] + scan.nextInt();
        }

        for(int k=0; k<M; k++) {
            int i = scan.nextInt();
            int j = scan.nextInt();

            System.out.println(numArr[j]-numArr[i-1]);
        }
    }
}
