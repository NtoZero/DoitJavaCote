package seungtae.ch3.ch3_5_stack_queue;

import _problems.ch3_data_structure.ch3_5_stack_queue.P11_1874;

import java.io.*;
import java.util.Stack;

public class S11_BOJ1874_RE implements P11_1874 {
    /*
        시간 제한 2초, 메모리 제한 128MB
        N 10^5 , 권장 알고리즘 NlogN 이하
        - 문제 풀이 : 스택을 사용한다. 문제에서 1부터 오름차순으로 데이터를 쌓는다.
            뺄 때는 마지막에 포함시켰던 요소를 출력하므로 LIFO구조이다. 따라서 스택을 활용한다.
            스택은 push와 pop 등 모든 연산이 O(1)이므로
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int cursor = 0;
        for(int i=1; i<=N; i++) {
            int K = Integer.parseInt(br.readLine());
            while(cursor < K) {
                stack.push(++cursor);
                result.append("+\n");
            }
            while(!stack.isEmpty() && stack.peek()==K) {
                stack.pop();
                result.append("-\n");
            }

            if(!stack.isEmpty() && stack.peek() > K) {
                result.setLength(0);
                result.append("NO");
                break;
            }
        }

        System.out.println(result);

    }
}

