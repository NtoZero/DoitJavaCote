package soli.ch3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 6 5 4 3 2 1 -> 1 버리고 2 3 가지고 오고 4 버리고 5 가지고 오고
        Queue<Integer> queue = new LinkedList<>();

        // queue에 1부터 n 까지
        for(int i = 1; i<=n ; i++) {
            // queue.add();
            queue.add(i);
        }

        // 큐 : 선입선출
        // 하나 빼서 버리기
        // queue.poll();
        // 또 하나 빼서 저장
        // 하나 남을 때 까지.. * 컬렉션 프레임워크 타입의 길이는 size()
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        // 남은 거 poll()
        System.out.println(queue.poll());
    }
}
