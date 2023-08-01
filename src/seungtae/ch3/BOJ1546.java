package seungtae.ch3;

import java.util.Scanner;

public class BOJ1546 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int subjectNUM = scan.nextInt();  // 개행문자
//        scan.nextLine();

//        String[] str = scan.nextLine().split(" ");
        int[] scoreArr = new int[subjectNUM];

        for(int i=0; i<subjectNUM; i++) {
//            scoreArr[i] = Integer.valueOf(str[i]);
            scoreArr[i] = scan.nextInt();
        }

        scan.close();

        int max = 0;
        double sum = 0;
        double result = 0;
        for(int i=0; i<scoreArr.length; i++) {
            if(max<=scoreArr[i]) {
                max = scoreArr[i];
            }
            sum += scoreArr[i];
        }


        result = (sum*100/max/scoreArr.length); // int (4) => 강제 형변환 double (8)

        System.out.println(result);
//        System.out.println(sum/max*100/scoreArr.length);

    }
}
