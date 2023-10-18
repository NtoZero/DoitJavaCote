package soli.ch3;

import _problems.ch3_data_structure.ch3_3_two_pointer.P6_2018;

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

        int sum = 1; // 시작 값(자연수)
        int end = 1;
        int count = 1; // 자기 자신
        int start = 1;

        while(end < N) {
            // 만약에 sum 이 N보다 작으면
            if (sum < N) {
                // end 증가 시키고
                end++;
                // sum + end
                sum = sum + end;
            }
            // 만약에 sum이랑 N이랑 같으면
            if (sum == N) {
                // count 개수 하나 올리고
                count++;
                // end ++
                end++;
                // sum + end ->  sum > N 되기 때문에
                sum = sum + end;
            }
            // sum > N 이면
            if (sum > N) {
                // sum =  sum - start (제일 앞에 더해 준 값 지우고)
                sum = sum - start;
                // start++;
                start++;
            }
        }
        System.out.println(count);
    }
}
