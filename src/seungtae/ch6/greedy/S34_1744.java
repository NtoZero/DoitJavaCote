package seungtae.ch6.greedy;

import _problems.ch6_greedy.P34_1744;

import java.util.*;
import java.io.*;

public class S34_1744 implements P34_1744 {
    /*
        양수는 최댓값끼리 곱한다.
            단, 1은 더하는게 낫다.
        음수는 최솟값끼리 곱한다.
            +. 원소가 홀수개일 때 수열에 0이 있다면 마지막 음수를 0과 곱한다. 0이 없다면 그대로 더한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 양수는 내림차순 정렬
        Queue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minusQ = new PriorityQueue<>();

        // 0과 1을 특별취급
        int one=0, zero = 0;

        for(int i=0; i<N; i++) { // 4개의 그룹으로 분리해 저장
            int num = Integer.parseInt(br.readLine());
            if(num > 1) {
                plusQ.add(num);
            } else if (num ==1) {
                one++;
            } else if (num ==0) {
                zero++;
            } else {
                minusQ.add(num);
            }
        }
        int sum = 0;
        // 양수 최댓값 만들기
        while (plusQ.size()>1) {
            int first = plusQ.remove();
            int second = plusQ.remove();
            sum += first*second;
        }
        // 양수 집합이 홀수 개면 마지막 하나는 그냥 더해야 한다.
        if(!plusQ.isEmpty()) {
            sum += plusQ.remove();
        }

        // 음수 최댓값 만들기
        while(minusQ.size()>1) {
            int first = minusQ.remove();
            int second = minusQ.remove();
            sum += first*second;
        }
        if(!minusQ.isEmpty()) {
            if(zero==0)
                sum += minusQ.remove();
        }
        // 1 처리하기
        sum += one;
        System.out.println(sum);

    }
}
