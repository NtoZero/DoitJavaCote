package seungtae.ch5.ch5_3binary_search;

import _problems.ch5_searching.ch5_3_binary_search.P29_1920;

import java.io.*;
import java.util.*;

public class S29_1920_2 implements P29_1920 {
    /*
        문제 분석 : 배열 A에서 X가 존재하는지 알아내는 프로그램 작성
            - A (10^5), M(10^5) 중 M의 수를 순회하며 A에 포함되어 있는지 여부를 출력한다.
            - 이중 for문을 사용한다면 10^10까지 나오므로 시간 제한 1초를 초과한다.
            - 이분탐색의 검색 logN을 사용한다면 -> NlogN의 시간복잡도로 해결 가능

        이분 탐색 :
            - 값을 정렬한다.
            - 중간 위치를 선택한다.
            - 중간 위치의 값보다 타깃이 적으면 왼쪽을, 크면 오른쪽을 선택한다.
            - 타깃과 중간 값이 같으면 종료한다.

        TreeSet 이용해서 풀어보기
     */

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 트리셋에 원소 넣기
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < N; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
//            treeSet.contains(target) ? sb.append("1\n") : sb.append("0\n") // X, 문법 오류
            sb.append(treeSet.contains(target) ? "1\n" : "0\n"); //O, 정상 문법
        }
        System.out.println(sb);
    }
}
