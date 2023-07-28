package seungtae.ch3;

import java.util.Scanner;

public class BOJ11720 {
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
