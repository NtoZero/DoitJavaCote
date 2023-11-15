package soli.bonus;

import _problems.ch5_searching.ch5_1_dfs.PP2_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1697_2 implements PP2_1697 {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;

        dfs(N, K, 0);
        System.out.println(result);
    }

    private static void dfs(int N, int K, int count) {
        // 만약에 수빈이 위치가 동생위치보다 크거나 같을 때 count에서 두 수의 차만큼 더해서 반환
        if(N >= K) {
            count += N-K;
            if(result > count) {
                result = count;
            }
            return;
        }

        dfs(N, N, count + K - N);

        // 만약에 수빈이 위치가 0이면 1로 이동
        // 0 * 2 = 0, 0-1 = 음수라서 이동불가
        if(N==0) {
            N = 1;
            count++;
        }

        if(K%2==1){
            dfs(N, K+1, count+1);
            dfs(N, K-1, count+1);
        }
        else {
            dfs(N, K/2, count+1);
        }
    }
}
