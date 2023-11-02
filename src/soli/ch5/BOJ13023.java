package soli.ch5;

import _problems.ch5_searching.ch5_1_dfs.P25_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13023 implements P25_13023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for(int i = 0; i < M ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        boolean[] node = new boolean[N];
        for(int i = 0 ; i < N ; i ++) {
            // 깊이가 5보다 깊을 때 까지 해야 함
            // depth는 1부터 시작
            if (dfs(arr, node, i, 1)) {
                // 맞으면 1
                System.out.println(1);
                return;
            }
        }
        // 틀리면 0
        System.out.println(0);
    }

    private static boolean dfs(int[][] arr, boolean[] node, int current, int depth) {

        node[current] = true;

        if(depth == 5) return true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[current][i] == 1 && node[i] == false) {
                // 재귀 호출 해서 참이면 참
                if(dfs(arr, node, i, depth+1)) {
                    return true;
                }
            }
        }
        node[current] = false;
        return false;
    }
}
