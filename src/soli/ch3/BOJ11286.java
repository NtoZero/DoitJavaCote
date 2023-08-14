package soli.ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // queue에들어가는 Integer를 Math.abs로 변환하여 비교 (두 값을) -> 실패
        // Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        // 들어가는 순서에 따라 queue 되기 때문에..

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs_o1 = Math.abs(o1);
                int abs_o2 = Math.abs(o2);

                // 절대값 똑같으면
                if(abs_o1 == abs_o2) {
                    // 🔗 https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
                    // 비교해서 오름차순 정렬
                    return Integer.compare(o1, o2);
                }
                // 절대값 다르면 절대값으로 비교
                return Integer.compare(abs_o1, abs_o2);
            }
        });

        for(int i = 0 ; i < n ; i++ ) {

            int j = Integer.parseInt(br.readLine());
            // 0 아니면
            if (j != 0) {
                // queue에 추가
                queue.add(j);
            } else {
                // 0이면 poll()
                // 만약에 빼낼 게 있으면
                // poll() 계속
                if(!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    // 없으면 0 출력
                    System.out.println(0);
                }
            }
        }
    }
}

/*
참고
---
🔗 https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
🔗 https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html#comparator--
🔗 https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
 */