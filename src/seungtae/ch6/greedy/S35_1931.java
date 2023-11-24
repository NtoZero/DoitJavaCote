package seungtae.ch6.greedy;

import _problems.ch6_greedy.P35_1931;

import java.io.*;
import java.util.*;

// 회의실 배정
public class S35_1931 implements P35_1931 {
    /*
        문제 분석 : 회의의 시작 시간과 끝 시간이 주어질 때
            각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
            - 회의의 수 N <=10^5 (권고 시간복잡도 : O(NlogN)

        문제 풀이 :
            1.우선순위 큐로 정렬.
                1) 기본적으로 시작 시간이 적은 순으로 정렬
                2) 시작 시간이 같으면 끝-시간 차가 적은 것 우선

            2. 정렬된 상태에서 시작 시간이 같은


     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i<N; i++) {
            pairs.add(new Pair(br.readLine()));
        }


    }

    static class Pair {
        int start;
        int end;
        int gap;

        public Pair(String line) {
            String[] numbers = line.split(" ");
            this.start = Integer.parseInt(numbers[0]);
            this.end = Integer.parseInt(numbers[1]);
            this.gap = Math.abs(start - end);
        }
    }
}
