package seungtae.ch5.ch5_2bfs;

import _problems.ch5_searching.ch5_2_bfs.P28_1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S28_BOJ1167 implements P28_1167 {
    /*
        알고리즘 : BFS (너비 우선 탐색)
            - 요구
                1. 방문 배열
                2. 그래프 (인접 리스트 배열) OR 2차원 배열
                3. 큐 (FIFO)
            - 절차
                1. BFS를 시작할 노드를 정한 후 사용할 자료구조 초기화하기
                2. 큐에서 노드를 꺼낸 후 꺼낸 노드의 인접 노드를 다시 큐에 삽입
                3. 큐에 노드가 존재하지 않을때까지 반복
     */
    /*
        정점의 개수 N (10^3)
        간선의 개수 M (10^4)
        탐색을 시작할 정점의 번호 V

     */

    // 상하좌우 이동 -> 동 남 서 북 (배열 상 x축 y축이 뒤집혀 있다. 행이 x, 열이 y.)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] A; // 인접 행렬 이차원 배열
    static boolean[][] visited;
    static Queue<int[]> queue = new ArrayDeque<>(); //x, y의 좌표값을 기록할 수 있어야 함.

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
