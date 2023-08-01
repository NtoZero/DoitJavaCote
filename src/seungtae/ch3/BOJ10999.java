package seungtae.ch3;
// 구간 합 구하기 2 : https://www.acmicpc.net/problem/10999


import java.util.Scanner;

public class BOJ10999 {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 수의 개수N, 수의 변경횟수 M, 구간의 합 횟수 K
    int N, M, K = 0;
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();

    // 구간합 배열 만들기 : N+1번만큼 숫자 배열 받고 sumArr[0] = 0;
    int[] sumArr = new int[N+1];
    for(int i=1; i<=N; i++) {
        sumArr[0] = 0;
        sumArr[i] = sumArr[i-1]+ sc.nextInt();
    }

    for(int i=0; i<M; i++) {
        int check = sc.nextInt();
        if(check==1) {
            for(int k=0; k<3; k++) {

            }
        }
    }

    }
}
