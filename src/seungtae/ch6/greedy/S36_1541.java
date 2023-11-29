package seungtae.ch6.greedy;

import _problems.ch6_greedy.P36_1541;

import java.util.*;
import java.io.*;

//잃어버린 괄호
public class S36_1541 implements P36_1541 {
    /*
        문제 분석 : 괄호를 적절히 (한번만? 아니면 여러번?) 쳐서 최종 연산 값을 최소로 만드는 프로그램 작성
            - 괄호는 연산의 우선순위이다. +, -만 계산하므로 순서는 바꾸지 않는다.
            - 값을 최소로 만드려면 -다음에 오는 수를 또다른 -가 나오기 전까지 묶어서 계산 한다.
                => 덧셈 먼저 더해주고 묶인 덧셈 끼리 빼준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer cha = new StringTokenizer(br.readLine(), "-"); // '-'을 기준으로 분리

        int sum = Integer.MIN_VALUE; // 0으로 두면 중간합이 0인 경우를 걸러내지 못함.
        while(cha.hasMoreTokens()) {
            int tmpSum = 0;

            StringTokenizer hab = new StringTokenizer(cha.nextToken(), "+"); // '+'를 기준으로 다시 분리
            while(hab.hasMoreTokens()) {
                tmpSum += Integer.parseInt(hab.nextToken());
            }

            // 덧셈을 치르고난 이후이므로 뺄셈끼리 누계
                // 다만 첫째 수는 반드시 양수이다. (첫 문자가 숫자이므로)
            if(sum == Integer.MIN_VALUE) {
                sum = tmpSum;
            } else {
                sum -= tmpSum;
            }
        }
        System.out.println(sum);
    }
}
