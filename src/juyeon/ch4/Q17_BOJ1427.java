package juyeon.ch4;

import java.util.*;

// https://www.acmicpc.net/problem/1427     500613009
public class Q17_BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

//        1. Arrays.sort() 로 짱 쉽게 풀기
//
//        Integer[] arr = new Integer[N.length()];
//        for( int i = 0; i < N.length(); i++ ) {
//            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
//        }
//
//        Arrays.sort(arr, Collections.reverseOrder());
////                           ^ 기본 자료형 배열에는 사용 불가능! 그래서 Integer 배열~
//
//        for( int i = 0; i < N.length(); i++ ) {
//            System.out.print(arr[i]);
//        }

//        // 2. 우선순위 큐로 멋지게 풀기
//
//        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
//
//        for( int i = 0; i < N.length(); i++ ) {
//            Q.add(Integer.parseInt(String.valueOf(N.charAt(i))));
//        }
//
//        for( int i = 0; i < N.length(); i++ ) {
//            System.out.print(Q.poll());     // poll 할 거라 위 조건에 Q.size() 쓰면 안 댐!!!!!!
//        }

        // 3. 선택 정렬로 풀기

        int[] arr = new int[N.length() + 1];
        for( int i = 1; i < N.length(); i++ ) {
            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        // int max = Arrays.stream(arr).max().getAsInt(); 최댓값 구하는 쩌는 람다식~ 하지만 지금은 필요없는...

        int maxIndex = 1;



        for( int i = 1; i <= N.length(); i++ ) {
            System.out.print(arr[i]);
        }

    }
}
