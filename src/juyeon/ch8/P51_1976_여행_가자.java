package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P51_1976_여행_가자 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        String answer = "YES";

        int first = Integer.parseInt(st.nextToken());

        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (find(first) != find(next)) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                arr[b] = a;
            } else {
                arr[a] = b;
            }

        }
    }

    private static int find(int n) {
        if (n == arr[n]) {
            return n;
        } else {
            return arr[n] = find(arr[n]);
        }
    }

}

// 3
// 3
// 0 1 0
// 1 0 1
// 0 1 0
// 1 2 3