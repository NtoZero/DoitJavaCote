// BOJ11286 절대값 힙 : https://www.acmicpc.net/problem/11286

package seungtae.ch3.ch3_5_stack_queue;

import problems.ch3_data_structure.ch3_5_stack_queue.P14_11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class S14_BOJ11286 implements P14_11286 {
    /*
        문제 분석
        - 시간 복잡도 : 시간 제한이 1초(10^8) , N의 최대수 10^5
        - 알고리즘 : N*logN 가능 (10^5 * 5)
        - 풀이
           1) 입력 값이 0이 아니면 자료구조에 절대값이 적은순으로 저장한다.
           2) 입력 값이 0이면 저장된 자료구조의 최저 절대값을 출력한다.
                만약, 동일한 절댓값이 있다면 실제 수가 낮은 쪽이 먼저 출력된다.
        - (x)활용 알고리즘1 : 절대값이 적은 순으로 정렬(NlogN) -> 자료구조에 저장
                        버블정렬로 구현하면 최악의 경우 O(N^2)이 되므로 구현이 어려움. (X)
        - (x)활용 자료구조1 : 정렬된 상태로 저장되므로 FIFO, 큐를 사용해 값이 0일 때만 위에서부터 꺼내 출력

        - 기각 : Comparator를 직접 구현해서 Arrays.sort(arr, new 컴패어레이터);를 하려고 했는데 알 수 없는 이유로 예외발생
            public void sortingAbsDesc(int[] intArr) {
                Arrays.sort(intArr, new AbsDescComparator());
            }

            class AbsDescComparator implements Comparator<Integer> {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(Math.abs(o1), Math.abs(o2));
                }
            }
            ---- 위 내용 기각

        - 활용 자료구조2 : 우선순위 큐 사용


     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // Person.age = 1 .name="이승태"

                                                                // new Comparator 익명 객체
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int FirstAbs = Math.abs(o1);
            int SecondAbs = Math.abs(o2);
            if(FirstAbs == SecondAbs) {
                return o1 - o2; //오름차순
            } else {
                return FirstAbs - SecondAbs;
            }
        });

        for(int i=0; i < N; i++) {
            int check = sc.nextInt();
            if(check == 0) {
                if (priorityQueue.isEmpty()) System.out.println(0);
                else { // 큐가 비어 있지 않으면
                    System.out.println(priorityQueue.poll());
                }
            }  else { // check != 0
                priorityQueue.add(check);
            }
        }
    }


}
