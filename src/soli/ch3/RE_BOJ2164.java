package soli.ch3;

import _problems.ch3_data_structure.ch3_5_stack_queue.P13_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RE_BOJ2164 implements P13_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 카드는 1 부터 N까지 하나씩 쌓인다.
        // 홀수는 버려진다고 했는데 그렇게 하니 N이 N이 홀 수 일 때 오류 생김
        Queue<Integer> queue = new LinkedList<>();

        // 자연수
        for(int i = 1 ; i <= N ; i ++) {
            queue.add(i);
        }

        // queue.poll()
        // queue.poll()
        // queue.add() 바로 전에 폴 한 거 add -> 하나 남을 때 까지
        while(queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        // 마지막으로 남은 거 poll
        System.out.println(queue.poll());
    }
}
