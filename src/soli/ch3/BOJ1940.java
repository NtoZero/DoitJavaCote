package soli.ch3;

import _problems.ch3_data_structure.ch3_3_two_pointer.P7_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)
 * 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000)
 * 셋째 줄에는 N개의 재료들이 가진 고유한 번호
 */
public class BOJ1940 implements P7_1940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 재료 개수
        int M = Integer.parseInt(br.readLine());    // 구해야 하는 합

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 재료 오름 차순
        // A[i] + A[j] = M
        Arrays.sort(A);

        int i = 0;  // i 가 작은 수
        int j = N-1;   // j가 큰 수
        int count = 0;

        while(i < j) {
            int sum = A[i] + A[j];

            // 만약에 합이랑 M이랑 같으면
            if (sum == M) {
                // count 하고
                count++;
                // j 줄이고
                j--;
                i++;
            }
            // 만약 sum이 M보다 작으면
            else if (sum < M) {
                // i 증가 시키고
                i++;
            }
            else {
                // j-- 안 시켜주면 무한 루프 돈다!
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
