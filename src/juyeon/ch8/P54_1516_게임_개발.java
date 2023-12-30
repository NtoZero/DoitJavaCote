package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 맞 왜 틀 ( 위상정렬 X)
public class P54_1516_게임_개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] T = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            T[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());

            T[i].add(t);

            int x = 0;

            while (x != -1) {
                x = Integer.parseInt(st.nextToken());

                if (x == -1) break;

                T[i].add(x);
            }
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (T[i].size() > 1) {
                for (int j = 0; j < T[i].size() - 1; j++) {

                    int current = T[T[i].get(j + 1)].get(0);
                    if (current > max) {
                        max = current;
                    }

                }

                T[i].set(0, T[i].get(0) + max);
            }
        }


        for (int i = 1; i <= N; i++) {
            System.out.println(T[i].get(0));
        }

    }
}


// 5
// 10 -1
// 10 1 -1
// 4 1 -1
// 4 3 1 -1
// 3 3 -1

// 10
// 20
// 14
// 18
// 17