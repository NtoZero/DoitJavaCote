package seungtae.ch3.ch3_5_stack_queue;

import _problems.ch3_data_structure.ch3_5_stack_queue.P14_11286;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S14_BOJ11286_RE implements P14_11286 {
    /*
        1<=N<=10^5 , 입력되는 정수 |2의 31승|
        -> NlogN 이하의 시간 복잡도가 결정되어야 한다.
        문제 : 0이 조건으로 주어지면 절대값이 가장 작은 값이 제거되고 출력된다.
                단, 절대값이 같은 값이 여럿이면 실제 최소 값이 제거된다.
                이외의 수가 조건으로 주어지면 자료구조 안에 포함(add)한다.
          - 자료구조 : 조건에 따른 삽입/삭제가 용이한 자료구조이어야 한다.
                - 중간 값의 삽입/삭제가 용이해야 한다. -> 링크드리스트? NO, 포인터가 넣으려는 인덱스를 가리키고 있어야 O(1) 한다.
                - 절대값에 따라 가중치를 두어 비교할 수 있는 자료구조이어야 한다. -> 우선순위 큐
                - 우선순위 큐의 삽입 : O(logN), 루트값 확인 O(1), 루트 제거 O(logN)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐로 최소 힙 구현
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs_a = Math.abs(o1);
            int abs_b = Math.abs(o2);

            // 같은 값이면 최소값을 리턴
            if(abs_a==abs_b) {
                return o1-o2; // 원래 값의 오름차순
            } else return abs_a-abs_b; // 절대 값의 오름차순
        });
        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k!=0) {
                queue.add(k);
            } else { // k == 0
                if(!queue.isEmpty()) {
                    bw.write(String.valueOf(queue.poll())+"\n");
                } else {
                    bw.write(String.valueOf(0)+"\n");
                }
            }
        }
        bw.close();
    }
}
