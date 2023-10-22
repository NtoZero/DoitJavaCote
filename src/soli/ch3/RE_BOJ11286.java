package soli.ch3;

import _problems.ch3_data_structure.ch3_5_stack_queue.P14_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RE_BOJ11286 implements P14_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 우선 순위 큐 -> default 는 오름 차순
        Queue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int abs1 = Math.abs(o1);
                        int abs2 = Math.abs(o2);

                        //  만약 절대값 똑같으면 -> 음수 우선
                        if(abs1 == abs2) {
                            return Integer.compare(o1, o2);
                        }
                        // 다르면 작은 거 우선
                        else {
                            // 다르면
                            return Integer.compare(abs1, abs2);
                        }
                    }
                }
        );

        for(int i = 0 ; i < n ; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                // 0이 아니면 배열에 넣기
                queue.add(num);
            }
            else {
                if (!queue.isEmpty()) {
                    // 안 비어있으면 poll 한 거 출력
                    System.out.println(queue.poll());

                }
                // 만약에 비어있으면 0 출력
                else {
                    System.out.println(0);
                }
            }
        }
    }
}
