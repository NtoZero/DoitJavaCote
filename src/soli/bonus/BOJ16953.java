package soli.bonus;

import _problems.ch5_searching.ch5_2_bfs.PP2_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 implements PP2_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(bfs(A, B));
    }

    private static int bfs(long A, long B) {
        // 오버 플로우 방지를 위해 Integer 사용하는 것이 좋음
        Queue<Long> Q = new LinkedList<>();
        Q.add(A);

        int count = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for(int i = 0 ; i < size ; i++) {
                long tmp = Q.poll();
                if(tmp == B) {
                    return count +1;
                }
                if (tmp *2 <= B) {
                    Q.add(tmp *2);
                }
                if(tmp*10 +1 <= B) {
                    Q.add(tmp*10 +1);
                }
            }
            count++;
        }
        return -1;
    }
}
