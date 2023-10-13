package soli.ch3;

import problems.ch3_data_structure.ch3_3_two_pointer.P6_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N(1 ≤ N ≤ 10,000,000)
 * 5, 7+8, 4+5+6, 1+2+3+4+5 -> 4가지
 * 제한시간 2초
 */
public class BOJ2018 implements P6_2018 {
    public static void main(String[] args) throws IOException {
        // 투포인터 : 시작인덱스 + 종료인덱스 지정해서 더하기
        // 투포인터 시간복잡도 O(N)
        // sum > N : sum = sum - start; start++;
        // sum < N : end++; sum = sum + end;
        // sum == N : end++; sum = sum + end; count++;
        // -> end를 더해서 다시 sum이 N보다 커지면 start를 키우니까

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

    }
}
