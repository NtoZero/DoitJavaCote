package seungtae.ch6.greedy;

import java.io.*;
import java.util.*;

public class S33_1715_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(cards);

        int sum = 0;
        for (int i = 1; i < N; i++) {
            // 현재 두 묶음을 합쳐서 새로운 묶음 생성
            int newBundle = cards[i - 1] + cards[i];

            // 새로운 묶음을 다시 배열에 삽입
            cards[i] = newBundle;

            // 비교 횟수 누적
            sum += newBundle;

            // 배열을 다시 정렬
            Arrays.sort(cards);
        }

        System.out.println(sum);
    }
}
