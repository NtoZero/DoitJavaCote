package juyeon.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P40_1016;

import java.util.HashSet;
import java.util.Scanner;

public class Q40_BOJ1016 implements P40_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        HashSet<Long> set = new HashSet<>();

        // 시간 초과 ❌❌❌
//        for (long i = 2; i * i <= max; i++) {
//            long pow = i * i;
//            for (long j = min; j <= max; j++) {
//                if (j % pow == 0) {
//                    set.add(j);
//                }
//            }
//        }

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = (min / pow) * pow;

            for (long j = start; j <= max; j+= pow) {

                // 15 15 일 때 아래 조건 없으면 틀림( 위 start 때문인 듯~)
                if (j >= min && j <= max) {
                    set.add(j);
                }
            }
        }

        System.out.println(max - min - set.size() + 1);

    }
}
