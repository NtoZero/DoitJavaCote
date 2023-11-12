package soli.bonus;

import _problems.bonus.DFS_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2606 implements DFS_2606 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];

// 배열 초기화
        for(int i = 0 ; i < N+1 ; i++ ){
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }



        for(int i = 1; i < N+1 ; i ++) {
            Collections.sort(A[i]);
        }

        // 배열 초기화
        visited = new boolean[N+1];
        count = 0;

        dfs(1);
        // 1번  컴퓨터는 빼야하기 때문에 -1
        System.out.println(count -1);
    }

    private static void dfs(int node) {
        visited[node] = true;
        count++;

        for(int i : A[node]){
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }

}
