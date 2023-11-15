package seungtae.ch5.bfs;

import _problems.ch5_searching.ch5_2_bfs.PP2_16953;

import java.util.*;
import java.io.*;

public class PS2_16953 implements PP2_16953 {
    /*
        문제 분석 : A -> B로 바꾸는 최단 거리 구하기
            - 변수의 크기: A < B <= 10^9 (int 범위 안)
            - 가능한 경우의 수
                1) 2를 곱한다.
                2) 1을 수의 가장 오른쪽에 추가한다.

        문제 풀이 : 목표 수에 도달하는 최단 경우의 수를 찾기
            - 필요한 것
                1) A, B
                2) Queue<Integer>
                3) 출발점으로부터 이동 거리를 계산할 거리 배열 int[] visited (배열 크기 B+1)
            - 로직
                1) A, B를 bfs에 전달한다.
                2) A, B 유효성 검사를 통해 A의 값을 증가시키며 B에 대한 최단거리를 찾는다.
                    - A가 증가할 수 있는 두 가지 경우 (int 배열 nextNodes)
                        1. 2를 곱한다.
                        2. 1을 수의 가장 오른쪽에 추가한다.
                    - int[] nextNodes를 큐에 추가한다.
                        1. 해당 값을 하나씩 꺼낸다.
                        2. 해당 값이 B보다 작고, 배열을 넘지 않는 범위에서(유효성 검사)
                           visited[해당 값]++ 하여 해당 값 인덱스로 이동하기 위한 거리를 구한다.
                        3. B 인덱스에 도달하는 가장 최단거리를 찾는다.
                            요소가 B에 도달하면 arr[B]를 출력하고 도달하지 못하면 -1을 출력한다.

        ! 주의사항
            B+1개의 int배열을 선언하면 메모리 제한 512MB를 초과한다. (B가 10억이기 때문)

     */

    static long A, B;
    static Queue<Long> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int result = bfs(A);
        System.out.println(result);
    }

    public static int bfs(long a) {
        q.add(a);

        int distance = 0; //
        while (!q.isEmpty()) {
            int size = q.size(); // 큐의 사이즈를 계산하여 각 레벨에서 거리를 따로 측정

            for (int i = 0; i < size; i++) {
                long e = q.poll();
                if (e == B)
                    return distance + 1;

                long[] nextNodes = {2 * e, Long.parseLong(e + "1")};
                for (long next : nextNodes) {
                    if (next >= 0 && next <= B) { //방문 했는지 여부를 체크
                        q.add(next);
                    }
                }
            }
            distance++;

//            if(e == B) { // 종료 조건
//                return distance+1; // 최초 0에서 시작했으므로 거쳐간 노드 +1
//            }
//
//            int[] nextNodes = {2*e, Integer.parseInt(e+"1")};
//
//            for(int next : nextNodes) {
//                if(next >=0 && next<=B) { //방문 했는지 여부를 체크
//                    q.add(next);
//                }
//            }
//            distance++;
//        }

        }
        return -1;
    }
}
