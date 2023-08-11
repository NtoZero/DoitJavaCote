package juyeon.ch3;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//
//        int[][] A = new int[N+1][N+1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                A[i][j] = sc.nextInt();
//            }
//        }
//
//        int[][] S = new int[N+1][N+1];
//        for( int i = 1; i <= N; i++ ){
//            for( int j = 1; j <= N; j++ ){
//                S[0][0] = 0;
//                S[i][j] = S[i-1][j] + S[i][j-1] + A[i][j] - S[i-1][j-1];
//            }
//        }
//
//        for(int i=0; i<=N; i++) {
//            for(int j=0; j<=N; j++) {
//                System.out.print(S[i][j]+ " ");
//            }
//            System.out.println();
//        }
//
//        for (int k = 1; k <= M; k++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c = sc.nextInt();
//            int d = sc.nextInt();
//
//            int sum = 0;
//            sum = S[c][d] - S[a-1][d] - S[c][b-1] + S[a-1][b-1];
//
//            System.out.println(sum);
//        }
//    }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1];
        for( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 1; j <= N; j++ ) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] S = new int[N+1][N+1];
        for( int i = 1; i <= N; i++ ) {
            for( int j = 1; j <= N; j++ ) {
                S[i][j] = S[i-1][j] + S[i][j-1] + A[i][j] - S[i-1][j-1];
            }
        }

//        for(int i=0; i<=N; i++) {
//            for(int j=0; j<=N; j++) {
//                System.out.print(S[i][j]+ " ");
//            }
//            System.out.println();
//        }

        for( int k = 1; k <= M; k++ ) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int sum = 0;
            sum = S[c][d] - S[a-1][d] - S[c][b-1] + S[a-1][b-1];

            bw.write(sum+"\n");   //버퍼에 있는 값 전부 출력
        }

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}
