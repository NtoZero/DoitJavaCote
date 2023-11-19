package soli.ch5;

import _problems.ch5_searching.ch5_3_binary_search.P29_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 implements P29_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(A);

        // 찾아야 하는 수
        int M = Integer.parseInt(br.readLine());
        int[] find = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M ; i++) {
            find[i] = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            boolean result = false;

            while(start <= end){
                int mid_index = (start + end) / 2;
                int mid = A[mid_index];

                if(mid == find[i]) {
                    System.out.println(1);
                    result = true;
                    break;
                }
                else if (mid < find[i]) {
                    start = mid_index + 1;
                } else if (mid > find[i]) {
                    end = mid_index - 1;
                }
            }
            if(!result) {
                System.out.println(0);
            }
        }
    }
}
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.HashSet;
//        import java.util.StringTokenizer;

//public class BOJ1920 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        HashSet<Integer> set = new HashSet<>();
//
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            set.add(Integer.parseInt(st.nextToken()));
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            if (set.contains(Integer.parseInt(st.nextToken()))) {
//                System.out.println(1);
//            } else {
//                System.out.println(0);
//            }
//        }
//    }
//}
