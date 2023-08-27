package soli.ch4;

import java.util.*;
import java.io.*;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter -> StringBuilder
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int num : arr) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}



//public class BOJ10989 {
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int arr[] = new int[N];
//
//        for(int i = 0 ; i < N ; i ++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        for(int num : arr) {
//            System.out.println(num);
//        }
//    }
//}

