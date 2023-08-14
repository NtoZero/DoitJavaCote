package seungtae.ch3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String str = sc.nextLine(); // 이거로 왜 안받아지지?
        String str = sc.next();
        int[] arr = new int[str.length()];

        for(int i=0; i<str.length(); i++) {
            arr[i] = Integer.valueOf(str.charAt(i)-'0');
        }
//        System.out.println(Arrays.toString(arr));


        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                //최댓값이 나타날 때마다 최댓값을 갱신하며, 해당 자리와 arr[i]를 변경한다.
                if(arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } // 최종적으로 arr[i]에 남은 값 중 최댓값이 갱신되게 된다.
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
