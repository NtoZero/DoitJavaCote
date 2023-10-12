package seungtae.ch3;

import java.util.*;
import java.io.*;

public class BOJ2018_RE {

    /*
        N : 10^7
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 총 개수, 시작 인덱스, 끝 인덱스, 합
        int cnt = 1;
        int start_index = 1;
        int end_index =  1;
        int sum = 1;

        // 투 포인터가 순회하며 cnt 집계
        while(end_index != N) {
            if(sum == N) {
                cnt++;
                end_index++;
                sum += end_index;
            }
            else if(sum > N) {
                sum -= start_index;
                start_index++;
            }
            else {
                end_index++;
                sum += end_index;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
