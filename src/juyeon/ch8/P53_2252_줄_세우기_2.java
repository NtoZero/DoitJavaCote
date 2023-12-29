package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
*
* 47776KB, 496ms => StringBuilder 가 확실히 빠르네용
* StringBuilder 안 쓰면 55660KB,	1000ms
*
* */

public class P53_2252_줄_세우기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int[] in = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);

            in[B]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();

            sb.append(v).append(' ');

            for(int e : list.get(v)) {
                if(--in[e] == 0) {
                    q.add(e);
                }
            }
        }

        System.out.println(sb);
    }
}
