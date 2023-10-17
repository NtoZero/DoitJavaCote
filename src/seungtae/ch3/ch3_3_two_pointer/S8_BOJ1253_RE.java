package seungtae.ch3.ch3_3_two_pointer;

import _problems.ch3_data_structure.ch3_3_two_pointer.P8_1253;

import java.util.*;
import java.io.*;

public class S8_BOJ1253_RE implements P8_1253 {
    /*
        시간 제한 2초, 메모리 제한 256MB
        수의 개수 N, 2*10^3
        - 시간 복잡도 O(N^2) 가능
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 다른 인덱스 두 수를 합해서 특정 인덱스 수가 나오면 cnt를 더해야 함.
        int cnt = 0;
        int s_idx = 0;
        int e_idx = 0;
        int sum = 0;

        // 1. arr을 NlogN 듀얼피봇 퀵 정렬로 정렬시킨다.
        Arrays.sort(arr);

        // 2. for문을 순회하며 arr의 각 요소에 대해 '좋은 수'인지 조회 한다.
        for(int i=0; i<N; i++) {
            int target = arr[i];
            s_idx = 0;
            e_idx = N-1; // 항상 끝 인덱스부터 1 작은 수로 시작해야 한다.

            while(s_idx < e_idx) {
                // 두 수의 합 sum
                sum = arr[s_idx] + arr[e_idx];
                // 더해서 해당 수가 나오면 cnt++, 다음 i로 넘어가기
                if(sum==target) {
                    if(s_idx != i && e_idx != i) { // 서로 다른 인덱스일 때 cnt 인정
                        cnt++;
                        break ;
                    } else if(i == s_idx) { // 시작 인덱스 그 자체로 i이면 ++
                        s_idx++;
                    } else if(i == e_idx) { // 끝 인덱스 그 자체로 i이면 --
                        e_idx--;
                    }
                }
                // 더해서 해당 수를 넘으면 end--
                else if(sum>target) {
                    e_idx--;
                }
                // 더해서 해당 수보다 부족하면 start++
                else { // sum<target
                    s_idx++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
