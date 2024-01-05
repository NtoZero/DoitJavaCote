package seungtae.ch8.graph.ch8_3_topological;

import _problems.ch8_graph.P53_2252;
import java.util.*;

/*
    위상 정렬(topological sort) : 사이클이 없는 방향 그래프에서 노드 순서 찾기

        개념
            - 기능 : 노드 순서 결정
            - 특징 : 사이클이 없어야 함
            - 시간 복잡도 : O(V+E)
            - 진입 차수(in-degree) : 자기 자신을 가리키는 엣지의 개수
        절차
            1. 진입 차수 배열 업데이트
            2. 진입 차수 배열에서 진입차수가 0인 노드를 선택하고 선택된 노드를 정렬 배열에 저장
            3. 인접 리스트에서 선택된 노드가 가리키는 노드들의 진입 차수를 1씩 뺀다.
            4. 다음 노드를 선택하여 반복 (모든 노드가 정렬될 때까지 반복)
        특징
            1) 위상 정렬이 늘 같은 결과를 보장하지는 않는다. (진입 차수가 같은 노드가 여럿 있을 경우)
        절차
            1. 진입 차수가 0인 노드 큐에 저장
            2. 큐에서 데이터를 poll해 해당 노드 탐색 결과에 추가, 해당 노드가 가리키는 노드의 진입 차수를 1씩 감소
            3. 감소했을 때 진입 차수가 0이 되는 노드를 큐에 offer
            4. 큐가 빌 때까지 1~3 반복
 */

public class S53_2252 implements P53_2252 {
    /*
        문제 분석:
            1. 진입 차수가 0인 노드
     */
    static ArrayList<ArrayList<Integer>> lists; // 인접 리스트 담을 ArrayList
    static Queue<Integer> Q = new LinkedList<>(); // 위상 정렬에 사용할 큐
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt(); // 노드 수
        int M = sc.nextInt(); // 엣지 수
        lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        // 진입 차수 배열
        int[] inArray = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int next = sc.nextInt();
            lists.get(start).add(next);
            // 진입 차수 값 입력 (증가)
            inArray[next]++;
        }

        // 위상 정렬
        for (int i = 1; i <= N; i++) {
            if (inArray[i] == 0) {
                Q.offer(i);
            }
        }
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            sb.append(cur + " ");
            for (int next : lists.get(cur)) {
                inArray[next]--;
                if (inArray[next] == 0) {
                    Q.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}
