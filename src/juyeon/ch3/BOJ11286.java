package juyeon.ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/11286
//https://velog.io/@robolab1902/Java-Priority-Queue-매개변수에-람다식-쓰는-이유가-뭐야
public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 정렬 조건 정해줘야댐                             이러케 .....
        // *** 양수 반환 = 자리 바꿈, 음수 반환 = 자리 유지 *** 우리는 작은 수부터 내보낼 거니까
        PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 숫자 직접 넣어서 생각해보면 이해하기 편해요
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                // 절댓값이 같으면
                if( a == b) {
                    // o1 < o2 면 음수 -> 자리 유지, 아니면 양수 -> 자리 바꿈
                    return o1 < o2 ? -1 : 1;
                } else {
                    // 절댓값이 다르면 둘이 비교해서 양수면 자리 바꾸고 음수면 유지
                    return a - b;
                }
            }
        });

        for( int i = 1; i <= N; i++ ) {
            int x = Integer.parseInt(br.readLine());
            if( x != 0 ) {
                Q.add(x);
            } else {
                if( Q.size() == 0 ) {
                    System.out.println(0);
                } else {
                    System.out.println(Q.poll());
                }
            }
        }
    }
}
