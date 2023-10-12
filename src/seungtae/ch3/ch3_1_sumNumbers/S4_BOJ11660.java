// 구간 합 구하기 5 : https://www.acmicpc.net/problem/11660

package seungtae.ch3.ch3_1_sumNumbers;

import problems.ch3_data_structure.ch3_1_sumNumbers.P4_11660;

import java.util.Scanner;

public class S4_BOJ11660 implements P4_11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for(int i=1; i<=N; i++) { //행
            for(int j=1; j<=N; j++) { //열
                sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j]-sumArr[i-1][j-1] + arr[i][j];
            }
        }

        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                System.out.print(sumArr[i][j]+ " ");
            }
            System.out.println();
        }

        // 계산 횟수 M만큼
        for(int i=0; i<M; i++) {
            int a = sc.nextInt(); //x1
            int b = sc.nextInt(); //y1
            int c = sc.nextInt(); //x2
            int d = sc.nextInt(); //y2

            System.out.println(sumArr[c][d]-sumArr[a-1][d]-sumArr[c][b-1]+sumArr[a-1][b-1]);
        }


    }
}
