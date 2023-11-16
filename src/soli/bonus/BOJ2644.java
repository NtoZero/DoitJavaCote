package soli.bonus;

import _problems.ch5_searching.ch5_1_dfs.PP3_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2644 implements PP3_2644 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 구해야 하는 촌수 a, b
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for(int i = 0 ; i < N + 1 ; i++) {
            A[i] = new ArrayList<>();
        }
        // 반복 되는 횟수
        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i <M ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            A[x].add(y);
            A[y].add(x);
        }

        visited = new boolean[N+1];
        count = 0;
        int result = dfs(a, b);

        System.out.println(result);
    }

    private static int dfs(int a, int b) {
        visited[a] = true;

        for(int i : A[a]){
            if(i == b) {
                // b로 바로 연결되면 1리턴
                return 1;
            }
            if(visited[i] == false){
                count = dfs(i, b);
                if(count != -1) {
                    // 방문 안했으면 위에 위에 타고 가서 찾기
                    return count + 1;
                }
            }
        }
        return -1;
    }
}
