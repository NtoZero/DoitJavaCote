package soli.ch3;

import _problems.ch3_data_structure.ch3_5_stack_queue.P12_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_BOJ17298 implements P12_17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력 숫자 받는 배열
        int[] arr = new int[N];
        // 결과 받는 배열
        int[] result = new int[N];
        // 배열 인덱스
        int[] stack = new int[N];
        // 스택의 인덱스
        int top = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // arr[] = [3,5,2,7]
        // stack[] = [3,2,1,0]
        for(int i = N-1 ; i >= 0 ; i--) {
            // top이 0이상, arr[i]가 arr[stack[top]]보다 크면 스택에 들어가는 인덱스 하나 씩 줄여서 넣기
            // i=1, arr[1] = 5 >= arr[stack[top]] = arr[stack[1]] = arr[2] = 2
            // top -- -> top = 0
            while(top >= 0 && arr[i] >= arr[stack[top]]) {
                top--;
            }
            // 만약에 top 이 -1이먄
            if(top == -1 ) {
                // 결과값 -1
                result[i] = -1;
            } else {
                // result [1] = arr[stack[0]]
                // result[1] = arr[2] = 7
                result[i] = arr[stack[top]];
            }
            // stack[1] = 1;
            stack[++top] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
