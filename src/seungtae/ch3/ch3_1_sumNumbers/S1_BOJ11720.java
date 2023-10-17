package seungtae.ch3.ch3_1_sumNumbers;

import _problems.ch3_data_structure.ch3_1_sumNumbers.P1_11720;

import java.util.Scanner;

public class S1_BOJ11720 implements P1_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        String num = scanner.next();
        scanner.close();

        int sum=0;

        for(int i=0; i<count; i++) {
            sum += num.charAt(i)-'0';
        }

        System.out.println(sum);
    }


}
