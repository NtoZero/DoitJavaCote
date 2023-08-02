//수들의 합5 : https://www.acmicpc.net/problem/2018

package seungtae.ch3;

import java.util.Scanner;

public class BOJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; // N의 합 N 그 자체에 대하여 count 1이다.
        //start, end는 1로 시작한다.
        int sum = 1, start = 1, end = 1; // sum: 인덱스들의 합, start와 end는 index

        // N의 크기가 10^7이므로 O(N) 알고리즘을 사용하는 것이 좋다.

        // ⭐핵심은 투 포인터를 적절하게 이동해가며 그 간극의 합을 구하는 것이다.
        while(end<N) {
            // sum의 크기가 N보다 작을 때는 end++, sum =sum+end
            if(sum<N) {
                end++;
                sum+=end;
            }// sum의 크기가 N보다 클 때는 sum-start, start++로 간극을 줄이는 것이다.
            else if(sum>N) {
                sum -= start;
                start++;
            }
            // sum == N )) end++, sum=sum+end, count++
            else {
                count++;
                end++;
                sum += end;
            }
        }

        System.out.println(count);


    }
}
