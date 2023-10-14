package seungtae.ch3.ch3_3_two_pointer;

import problems.ch3_data_structure.ch3_3_two_pointer.P7_1940;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S7_BOJ1940_RE implements P7_1940 {
    /*
        시간 제한 2초, 메모리 제한 128MB
        재료 개수 N 1.5 * 10^4 , 고유 번호 M (M<=10^7)
        - 시간 복잡도 O(NlogN) 이하가 권장 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 고유 합 개수 cnt, 시작 idx, 끝 idx
        int cnt = 0;
        int start_idx = 0;
        int end_idx = N-1; // 끝에서부터 시작해서 end 포인터가 인덱스 범위를 벗어나지 않도록 한다.
        int sum = 0;

        // 2. 듀얼 피봇 퀵정렬 Arrays.sort()를 이용, NlogN 사용
        Arrays.sort(arr);

        // 3. 두 수의 합을 단계적으로 구하는 while문, 조건은 start_idx와 end_idx가 만나지 않는 것
        while(start_idx < end_idx) {
            sum = arr[start_idx]+arr[end_idx];
            // sum과 M이 동일하면 cnt++, 시작 인덱스++, 끝 인덱스--,
            if(sum == M) {
                cnt++;
                start_idx++;
                end_idx--;
            }
            else if(sum < M) { // 합이 부족하면 시작 인덱스 하나를 증가.
                start_idx++;
            } else { // sum > M , 합이 넘치면 끝 인덱스 하나 줄이기
                end_idx--;
            }
        }

        // 4. 출력
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
