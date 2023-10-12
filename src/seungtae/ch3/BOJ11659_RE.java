package seungtae.ch3;

import java.util.*;
import java.io.*;

public class BOJ11659_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N, M 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 수열 arr, 구간 합의 배열 sumArr
        int[] arr = new int[N+1];
        int[] sumArr = new int[N+1];

        // 실제 숫자
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(sumArr[end]-sumArr[start-1])+"\n");
        }
        bw.close();
    }
}
