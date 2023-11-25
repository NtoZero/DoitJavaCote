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
                1) 기본적으로 종료 시간이 적은 순으로 정렬
                2) 종료 시간이 같으면 시작 시간이 적은 순 (갭이 적은 순)

            2. 정렬된 상태에서 시작 시간이 같은 것들을 건너뛰고
                끝 시간 이후인 시작시간을 가지고 있는 Pair 객체를 카운트


     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i<N; i++) {
            pairs.add(new Pair(br.readLine()));
        }

        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
//                if(o1.end != o2.end) {
//                    return o1.end-o2.end;
//                }
//                return o1.start-o2.start;
                if(o1.end == o2.end) return o1.start-o2.start;
                return o1.end-o2.end;
            }
        });

        int beforeStart = -1;
        int beforeEnd = -1;
        for(Pair p : pairs) {
//            if(beforeStart == p.start) continue;
            if(p.start >= beforeEnd) { // 시작과 종료가 같은 시간에 끝나는 경우 ex) 2 2 를 고려하여 등호 포함
                beforeStart = p.start;
                beforeEnd = p.end;
                System.out.println(beforeStart + " " + beforeEnd);
                result++;
            }
        }
        System.out.println(result);
    }

    static class Pair {
        int start;
        int end;

        public Pair(String line) {
            String[] numbers = line.split(" ");
            this.start = Integer.parseInt(numbers[0]);
            this.end = Integer.parseInt(numbers[1]);
        }
    }
}
