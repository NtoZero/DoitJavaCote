// 최솟값 찾기 : https://www.acmicpc.net/problem/11003
package seungtae.ch3;

import java.util.Scanner;

public class BOJ11003 {
    /*
        - 문제 분석
            - 시간 복잡도 : 2.4초 (2.4 * 10^8) / N의 최대 수 : 5*10^6
                            // N logN = 5*10^6 * log(5*10^6)
            - 알고리즘 : NlogN 이하가 권장될 것이다.
                - 이중 for문 사용 불가 (N^2)
            - 자료구조 : 미상
            - 풀이 :
                [변수] int [] arr (원본 배열)
                1) (N만큼 순회하는) for문 사용 하여 배열의 i번째에 해당하는 Di 구하기
                    - int k = i-L+1;
                2) 배열 arr의 k번째부터 끝까지의 원소 중 최소값을 구하여 출력한다.
                
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
