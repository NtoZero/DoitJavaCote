package seungtae.ch3.ch3_5_stack_queue;

import _problems.ch3_data_structure.ch3_5_stack_queue.P12_17298;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class S12_BOJ17298_RE implements P12_17298 {
    /*
        시간 제한 1초, 메모리 제한 512MB
        N 10^6, 수의 크기 10^6
        - 시간복잡도 NlogN 이하 사용
        - 문제 풀이 : 원본 배열과 정답 배열, 그리고 스택을 이용한다.
                    스택은 정답 배열의 인덱스를 포함한다. 스택은 기본적으로 LIFO의 성질을 갖는다.
                    본 문제는 요소를 순회하며 '오큰수'를 찾아야 한다.
                    '오큰수'는 있을 수도 없을 수도 있으므로, 요소 또는 '요소의 저장 위치'들을 '기록'할 자료 구조가 필요하다.
                    '오큰수'를 만난다면 스택에 저장해두었던 인덱스들을 활용하여 '요소 값'들간 비교를 통해 '오큰수'를 찾아낼 수 있다.
                    while문을 이용해 LIFO로 스택의 봉우리에 있는 요소들을 pop()으로 하나씩 꺼내며 대조할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //1. 원본 배열 중 오큰 수가 있는 값은 그 수를 정답 배열에 저장한다.
        int[] arr = new int[N]; //원본 배열
        int[] answer = new int[N]; // 정답 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 원본 배열 받기
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //2. 스택에 '인덱스'를 저장하여 요소 값을 비교한다.
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //빈 스택 에러 방지
        for(int i=1; i<N; i++) {
            // 스택과 스택 인덱스+1의 요소를 비교하여 (인덱스와 인덱스 다음 요소값 비교) 오큰수가 나오면 정답 배열에 저장한다.
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                // stack에서 pop()하면서 정답 배열의 인덱스에 오큰수 저장하기
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        //3. 정답 배열에 있는 요소를 꺼내면서 값이 0인 것은 -1로 대치하여 출력 한다.
        for(int i=0; i<answer.length; i++) {
            bw.write(String.valueOf(answer[i] != 0 ? answer[i] : -1) + " ");
        }
        bw.close();
    }
}
