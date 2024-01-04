package soli.ch8;

import _problems.ch8_graph.P54_1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1516 implements P54_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 건물 종류 수
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N+1];
        // 걸리는 시간
        int[] time = new int[N+1];

        for(int i = 0 ; i <= N ;i++) {
            graph.add(new ArrayList<>());
        }

        // 걸리는 시간, 먼저 지어져야 하는 건물의 번호
        for(int i = 0 ; i < N ; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while(true) {
                int building = Integer.parseInt(st.nextToken());
                if(building == -1) {
                    break;
                }
                // building이 add 보다 앞에 지어져야 함
                // building의 차수가 더 낮아야 함
                graph.get(building).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= N ; i++) {
            if(indegree[i] == 0) {
                Q.add(i);
            }
        }

        // 시간 결과 저장하는 배열
        int[] result = new int[N+1];

        while (!Q.isEmpty()) {
            int current = Q.poll();

            for(int next : graph.get(current)) {
                indegree[next]--;
                // 시간 업데이트
                result[next] = Math.max(result[next], result[current] + time[current]);

                if(indegree[next] == 0) {
                    Q.add(next);
                }
            }
        }
        for(int i = 1; i <= N ;i++) {
            System.out.println(result[i] + time[i]);
        }
    }
}
