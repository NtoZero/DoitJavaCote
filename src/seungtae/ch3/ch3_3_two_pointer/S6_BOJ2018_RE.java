//https://www.acmicpc.net/problem/2018

package seungtae.ch3.ch3_3_two_pointer;

import problems.ch3_data_structure.ch3_3_two_pointer.P6_2018;

import java.io.*;

public class S6_BOJ2018_RE implements P6_2018 {

    /*
        N : 10^7
        연속된 자연수의 합을 나타내기 위해서 O(N) 이하의 방법을 사용해야 한다.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 총 개수, 시작 인덱스, 끝 인덱스, 합
        int cnt = 1;
        int start_index = 0;
        int end_index =  0;
        int sum = 0;

        while(end_index != N) { // 투 포인터가 순회하며 cnt 집계
            if(sum == N) {
                cnt++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else { // sum < N
                end_index++;
                sum += end_index;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
