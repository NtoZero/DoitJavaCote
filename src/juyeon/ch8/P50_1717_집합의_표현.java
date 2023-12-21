package juyeon.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P50_1717_집합의_표현 {

    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
//            arr[i].add(i);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                arr[a].add(b);
                arr[b].add(a);

                // 보나마나 시간초과 => 일 줄 알았는데 메모리 초과
                for (int j = 0; j <= n; j++) {
                    if (arr[i].contains(a)) arr[i].add(b);
                }
            }

            if (command == 1) {
                isSameSet(a, b);
            }

        }

    }

    private static void isSameSet(int a, int b) {
        if (arr[a].contains(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

// 7 8
// 0 1 3
// 1 1 7
// 0 7 6
// 1 7 1
// 0 3 7
// 0 4 2
// 0 1 1
// 1 1 1

// NO
// NO
// YES


// 3 3
// 0 1 2
// 0 1 3
// 1 2 3

// YES