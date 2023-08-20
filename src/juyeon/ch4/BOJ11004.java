package juyeon.ch4;

import java.io.*;
import java.util.*;
import java.util.List;

public class BOJ11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 인덱스 계산 잘 하기 ...
        int[] arr = new int[N];
        for( int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[K-1]);

//        배열로 풀었는데 틀렸대서 리스트로 풀어봄

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//
//        List<Integer> list = new ArrayList<>();
//        for( int i = 0; i < N; i++ ) {
//            list.add(Integer.parseInt(st.nextToken()));
//        }
//
//        Collections.sort(list);
//
//        System.out.println(list.get(K-1));

    }
}
