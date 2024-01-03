package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P54_1516_게임_개발_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        int[] time = new int[N + 1];

        // 먼저 지어야 하는 건물 수
        int[] in = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int n = Integer.parseInt(st.nextToken());

                if (n == -1) {
                    break;
                }

                arr.get(n).add(i);

                in[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) q.add(i);
        }

        int[] result = new int[N + 1];

        int max = 0;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 0; i < arr.get(v).size(); i++) {

                int current = arr.get(v).get(i);

                if (current > max) {
                    max = current;
                }

                result[i] = max;

                if (--in[v] == 0) q.add(v);

            }

        }

        for (int i = 1; i <= N; i++) {
            sb.append((result[i] + time[i]) + "\n");
        }

        System.out.println(sb);

    }
}
