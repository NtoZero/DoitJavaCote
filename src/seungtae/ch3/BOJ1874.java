// 스택으로 오름차순 수열 만들기 https://www.acmicpc.net/problem/1874

package seungtae.ch3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수열의 개수 (N의 최대값이 10^5이므로 n^2 이하 알고리즘 사용)
        int N = sc.nextInt();

        // pop으로 출력되는 수열
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        // push할 때 사용되는 자연수 (push 하나당 1씩 증가)
        int naturalCount = 1;

        // push & pop에 사용될 스택
        Stack<Integer> stack = new Stack();

        // 정상적으로 수열 출력이 가능한지 여부를 체크하는 check
        boolean check = true;
        // StringBuilder 객체 (마지막에 check 여부를 따져서 한 번만 결과 출력)
        StringBuilder sb = new StringBuilder();

        /*
            1. N의 최대값이 10^5이며, 시간제한이 2초이므로 2*10^8 이하의 알고리즘을 사용해야 한다.
            2. (x) ~~자연수를 스택에 push하므로 스택의 LIFO 특성상 pop으로 빼낸 마지막 수보다 수열의 수가 크면 "NO"를 출력해야 한다.~~
            2. (o) ⭐ 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 출력불가
            3. 스택에 자연수(naturalCount)를 push할 때마다 naturalCount는 ++ 되어야 한다.
            4. boolean 변수와 StringBuilder 객체를 통해 출력이 가능할 경우에만 출력하도록 한다.
         */

        int lastPop = 0; // 마지막으로 pop된 수

        for(int i=0; i<arr.length; i++) {
            int curNum = arr[i];

            // arr의 i번 요소(현재 수)가 자연수 이상일 때 push
            if(curNum >= naturalCount ) {
                while(curNum >= naturalCount) {
                    stack.push(naturalCount++);
                    sb.append("+\n");
                }
                // curNum < naturalCount가 되는 순간 스택의 마지막 요소 pop
                lastPop = stack.pop();
                sb.append("-\n");
            }
            // arr의 i번 요소(현재 수)가 자연수 미만일 때 pop (curNum<naturalCount)
            else{
                lastPop = stack.pop();
                sb.append("-\n");
                if(lastPop > curNum) { // ⭐ 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 출력불가
                    System.out.println("NO"); // 여기서 체크하면 출력초과가 발생
                    check = false;
                    break;
                }
                while(lastPop!=curNum) {
                    lastPop = stack.pop();
                    sb.append("-\n");
                }
            }
        }
        if(check) System.out.println(sb.toString());
    }
}

// 참고 : https://st-lab.tistory.com/182
