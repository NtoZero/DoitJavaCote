package seungtae.ch8.graph.ch8_1;

import _problems.ch8_graph.P49_2251;

import java.io.*;
import java.util.*;

public class S49_2251 implements P49_2251 {
    static int[] Sender = { 0, 0, 1, 1, 2, 2 };
    static int[] Receiver = { 1, 2, 0, 2, 0, 1 };
    static boolean visited[][];  //A B의 무게만 있으면 C의 무게가 고정되므로 2개로만 체크 가능
    static boolean answer[];
    static int container[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        container = new int[3]; // A B C 물통
        container[0] = Integer.parseInt(br.readLine());
        container[1] = Integer.parseInt(br.readLine());
        container[2] = Integer.parseInt(br.readLine());
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) System.out.print(i + " ");
        }
    }
    public static void BFS() {
        Queue<AnB> queue = new LinkedList<>();
        queue.add(new AnB(0, 0));
        visited[0][0] = true;
        answer[container[2]] = true;
        while (!queue.isEmpty()) {
            AnB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = container[2] - A - B; //
            for (int k = 0; k < 6; k++) { // A->B, A->C, B->A, B->C, C->A, C->B
                int[] next = { A, B, C };
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if (next[Receiver[k]] > container[Receiver[k]]) { // 대상 물통의 용량보다 물이 많아 넘칠 때
                    // 초과하는 만큼 다시 이전 물통에 넣어줌
                    next[Sender[k]] = next[Receiver[k]] - container[Receiver[k]];
                    next[Receiver[k]] = container[Receiver[k]]; // 대상 물통은 최대로 채워줌
                }
                if (!visited[next[0]][next[1]]) { // A와 B의 물의 양을 통하여 방문 배열 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new AnB(next[0], next[1]));
                    if (next[0] == 0) {  // A의 물의 양이 0일때 C의 물의 무게를 정답 변수에 저장
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}
    //AB 클래스선언 -> A와 B의 값만으로 C유추
    class AnB {
    int A;
    int B;
    public AnB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
