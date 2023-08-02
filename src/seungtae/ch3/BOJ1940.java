package seungtae.ch3;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        // 문제 포인트 : N개의 고유한 수가 존재. 이 중 두 수의 합으로 M을 달성해야한다.
        /*
            1. M의 최대값이 10^7이므로 O(N)이 넘는 알고리즘 사용은 불가능하다.
            2. O(N) : 10^8 미만의 반복문을 사용해야 한다.
            3. 두 수의 합 또는 구간 합을 구할 때 투포인터를 활용할 수 있다.
         */
        int count = 0; // 경우의 수
        int sum = 0; // 두 고유한 수의 합
        int start = 0, end = N-1;

        // 정렬 N의 모수가 최대 1.5만이라 NlogN의 사용이 가능하다.
        Arrays.sort(arr);

        // arr[start]와 arr[end]의 합이 M인가 아닌가의 여부를 따져야 한다.
        // start와 end는 최소 1의 간격을 유지한다.
        // end++하다가 arr[start]+arr[end]가 M에 도달하면 end-- 이후 start를 증가시킨다.
        // 종료조건 : start와 end가 만나면 종료한다.

        while(start<end) {
            if(arr[start] + arr[end] < M) {
                start++;
            } else if(arr[start] + arr[end]==M) {
//                System.out.println("arr[start] : " + arr[start] + ", arr[end] : " + arr[end]);
                count++;
                end--;
                start++;
            } else { // sum > M
                end--;
            }
        }
        System.out.println(count);

    }
}
