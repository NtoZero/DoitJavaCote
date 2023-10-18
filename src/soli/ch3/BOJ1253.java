package soli.ch3;

import _problems.ch3_data_structure.ch3_3_two_pointer.P8_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 implements P8_1253 {
    public static void main(String[] args) throws IOException {

    // 주어진 수 중에서 고르는 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(A);
        int count = 0;

        // int k = 구해야 하는 좋은 수의 인덱스 번호
        for (int k = 0; k < N; k++) {
            int num = A[k];
            int i = 0;
            int j = N - 1;
            // i < j 할 때 까지
            while (i < j) {
                int sum = A[i] + A[j];

                // 만약에 sum == A[k] 이면
                if (sum == num) {
                    // A[i] ,A[j] 둘 다 A[k]랑 다른지 확인
                    if (i != k && j != k) {
                        count++;
                        break;  // 안하면 중복 생김
                    } else if (i == k) {   // 아니면 (A[i])가 A[k]랑 같으면 i++
                        i++;
                    } else if (j == k) {  // j가 k랑 같으면 j--;
                        j--;
                    }
                }

                // 만약에 sum < A[k]이면
                else if (sum < num) {
                    i++;
                }
                // 만약에 sum > A[k]이면
                else {
                    j--;
                }
            }
        }
        System.out.println(count);
    }
}
