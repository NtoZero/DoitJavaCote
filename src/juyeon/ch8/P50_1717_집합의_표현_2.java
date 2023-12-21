package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온 파인드
public class P50_1717_집합의_표현_2 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                if (isSameSet(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            arr[b] = a;
        }
    }

    private static int find(int n) {
        if (n == arr[n]) {
            return n;
        } else {
            // 재귀 함수 형태로 구현
            return arr[n] = find(arr[n]);
        }
    }

    private static boolean isSameSet(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
