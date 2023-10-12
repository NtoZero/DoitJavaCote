// 카드2 https://www.acmicpc.net/problem/2164
package seungtae.ch3.ch3_5_stack_queue;

import problems.ch3_data_structure.ch3_5_stack_queue.P13_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S13_BOJ2164 implements P13_2164 {

    /*
        문제 해석 :
        시간 복잡도 - 2초 ( 2*10^8 ), N의 크기 : 5 * 10^5 ===> N^2 이하의 알고리즘 사용해야 함.
        자료 구조 - Queue : 먼저 들어 온 요소가 먼저 빠져 나간다. (FIFO)

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 입력되는 수의 개수
        int answer = 0; // 반환할 정답 변수

        Queue<Integer> queue = new LinkedList(); // FIFO 구조를 만들 큐

        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }

        // i는 0부터 queue.size()-1까지 증가된다. (단, queue가 비어있지 않아야 한다.)
//        for(int i=0; i<queue.size() && !queue.isEmpty(); i++) { // (x) 폐기 i는 지속적으로 증가하는데 queue.size()는 두 번 당 한 번만 줄어든다.
//        }

        int count = 0; //번갈아가는 횟수를 세기 위한 count

        while(!queue.isEmpty()) {

            if(queue.size()==1) {
                answer = queue.poll();
                System.out.println(answer);
                return;
            }
            if(count%2==0) { //짝수 번 째 버림
                queue.remove();
            } else if(count%2==1) { //홀수 번 째 마지막에 추가
                int willBeAddedInt = queue.poll();
                queue.add(willBeAddedInt);
            }
            count++;
        }
    }
}

/*

 */