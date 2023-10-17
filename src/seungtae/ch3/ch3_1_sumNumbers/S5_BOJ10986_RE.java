package seungtae.ch3.ch3_1_sumNumbers;

import _problems.ch3_data_structure.ch3_1_sumNumbers.P5_10986;

import java.util.*;
import java.io.*;

public class S5_BOJ10986_RE implements P5_10986 {
    /*
        시간 제한 1초, 메모리 제한 256MB
        수의 개수 N(10^6) , 나누어 떨어져야 하는 수 M (2~10^10^3) , 하나의 수의 크기는 10^9까지 도달할 수 있다.
        - 풀이 방법 : 구간 합을 구해놓기
            다중 for문으로 풀면 시간 복잡도를 초과하기 때문에 누적합 배열은 구간 합을 미리 구해놓는다.
            구간 합과 투 포인터의 조합으로 풀이하면 경우의 수를 셀 수 있을 것 같다. -> (X)
            합 배열 S[5]-S[2] = a[5]+a[4]+a[3] , 점화식 S[i]-S[j-1] = a의 j부터 i까지의 합을 더한 것
            단, 연속된 구간 조건이 있으므로 a[i] 단독으로 3의 배열이 되는 경우의 수는 제외한다.

            - 주의 : 투 포인터를 활용하려고 했지만 일반적인 경우로는 불가능. 일치합을 구하는 문제도 아니고 정렬도 되지 않았으므로,
                    투 포인터를 for문 처럼 돌리면 N!의 시간 복잡도가 나올 수도 있다.
                    => 계수 정렬을 이용한다.

            - 핵심 아이디어 : S[j] % M 과 S[i] % M의 값이 같다면( S[j]%M - S[i]%M = 0 ) (S[j] - S[i]) % M은 0이다.
                => 구간 합 배열의 원소를 M으로 나눈 나머지로 업데이트하고 S[j]와 S[i]가 같은 (i,j) 쌍을 찾으면
                   원본 배열에서 i+1부터 j까지의 구간 합이 M으로 나누어 떨어진다는 것을 알 수 있음.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수열의 개수 N, 나누어져야 할 수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        // 합의 나머지 원소 배열 R
        long[] R = new long[N+1];
        // 합의 나머지가 같은 배열 C
        long[] C = new long[M];
        st = new StringTokenizer(br.readLine());

        // 원소 배열 arr과 합의 나머지 배열 R, 나머지 계수 배열 C 구하기
        for(int i=1; i<=N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            // 합배열 원소를 M으로 나누어 담아주기 (합의 나머지 배열 만들기)
            R[i] = (R[i-1]+arr[i]) % M;
            // 합의 나머지의 개수 배열 C 세기
            C[(int) R[i]]++;
        }

        // 합이 나누어 떨어짐을 만족하는 개수 cnt
        long cnt = 0;


        // 1. 합의 나머지 배열이 0인 원소의 개수 세기 (누적합 그 자체로 M으로 나누어 떨어지는 원소)
        for(int i=1; i<=N; i++) {
            if(R[i]==0) cnt++;
        }

        // 2. 부분 합이 M으로 나누어 떨어지는 경우의 수 세기 (합의 나머지 배열이 같은 순서쌍의 개수 세기
                    //나머지는 M 이하로만 존재한다.
        for(int i=0; i<M; i++) {
            if(C[i] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 , Combine 연산 수행
               cnt += (C[i]*(C[i]-1))/2;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
