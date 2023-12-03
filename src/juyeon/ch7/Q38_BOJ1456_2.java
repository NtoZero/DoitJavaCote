package juyeon.ch7;

import java.util.Scanner;

public class Q38_BOJ1456_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        // 10^14 의 제곱근 10^7 까지
        long[] num = new long[10000001];

        for (int i = 2; i < num.length; i++) {
            num[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(num.length); i++) {
            if (num[i] == 0) {
                continue;
            }
            for (int j = i + i; j < num.length; j += i) {
                num[j] = 0;
            }
        }

        int count = 0;

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (num[i] == i) {
                long k = i;
                while (k <= B) {
                    k *= i;
                    if (k >= A && k <= B) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
