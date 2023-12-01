package juyeon.ch6;

import _problems.ch6_greedy.P36_1541;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q36_BOJ1541 implements P36_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), "-");

        int sum = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");

            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
