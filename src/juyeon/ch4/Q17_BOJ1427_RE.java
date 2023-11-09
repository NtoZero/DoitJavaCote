package juyeon.ch4;

import _problems.ch4.ch4_arrays.P17_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17_BOJ1427_RE implements P17_1427 {
    public static void main(String[] args) throws IOException {

        // (1) Arrays.sort 로 짱 쉽게 풀기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String N = br.readLine();
//
//        Integer[] arr = new Integer[N.length()];
//        for (int i = 0; i < N.length(); i++) {
//            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
//        }

//        Arrays.sort(arr, Collections.reverseOrder());
//                            ^ int X Integer O ( 제네릭엔 원시타입 안 되니까~)

//        for (int i = 0; i < N.length(); i++) {
//            System.out.print(arr[i]);
//        }

//        Arrays.sort(arr);
//
//        for (int i = N.length() - 1; i >= 0; i--) {
//            System.out.print(arr[i]);
//        }

//        (2) 우선순위 큐로 풀어보기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String N = br.readLine();
//
//        PriorityQueue q = new PriorityQueue(Collections.reverseOrder());
//
//        for (int i = 0; i < N.length(); i++) {
//            q.add(Integer.parseInt(String.valueOf(N.charAt(i))));
//        }
//
//        for (int i = 0; i < N.length(); i++) {
//            System.out.print(q.poll());
//        }

//        (3) 선택 정렬로 피곤하게 풀기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] arr = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        int max;
        int k;

        for (int i = 0; i < N.length(); i++) {
            for (int j = i; j < N.length(); j++) {
                if (arr[i] < arr[j]) {
                    max = arr[j];
                    k = arr[i];
                    arr[i] = max;
                    arr[j] = k;
                }
            }
        }

        for (int i = 0; i < N.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}
