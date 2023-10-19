package juyeon.review;

import _problems.ch3_data_structure.ch3_3_two_pointer.P10_11003;

import java.io.*;
import java.util.*;

public class BOJ11003_RE implements P10_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // bw 안 썼더니 시간초과 되더라구여
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 슬라이딩 윈도우 크기
        int L = Integer.parseInt(st.nextToken());

        // 덱 : 양방향 큐( 양쪽으로 요소 삽입, 삭제 가능)
        Deque<int[]> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 새로 넣을 값보다 원래 있던 값이 더 크면 요소 삭제
            while (!deque.isEmpty() && deque.peekLast()[1] > num) {
                deque.pollLast();
            }

            deque.offer(new int[] {i, num});

            // 슬라이딩 윈도우 크기 밖의 요소 삭제
            if (deque.peekFirst()[0] < i-L+1) {
                deque.poll();
            }
            bw.write(deque.peekFirst()[1]+" ");
        }
        bw.flush();
        bw.close();
    }
}


// 12 3
// 1 5 2 3 6 2 3 7 3 5 2 6
// 1 1 1 2 2 2 2 2 3 3 2 2



