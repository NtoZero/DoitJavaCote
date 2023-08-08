// 오큰수 구하기(17298) :https://www.acmicpc.net/problem/17298

package seungtae.ch3;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // IOException 필수
        int[] arr = new int[N]; // 받는 수열

        String[] str = bf.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        /*
            오큰 수란, 현재 요소의 오른쪽에 있는 여러 수 중 자기 자신 요소보다 큰, 가장 왼쪽에 있는 수를 말한다.
            시간 제한 1초(10^8), N의 최대수 10^6 이므로 사용 가능한 알고리즘은 nlog(n) 이하가 권장됨을 알 수 있다.
            N번의 반복문을 사용해야 하므로 (N * 알고리즘 시간복잡도)가 최종 시간복잡도가 된다.
                => 스택을 사용한다.
                스택에 배열의 인덱스를 push한다. 최초 push는 0을 넣어야 한다.
                for문으로 순회하며 인덱스 i에 따라 (스택이 비어있지 않고) 가장 최근에 포함된 인덱스의 요소(arr[stack.peek()]) 보다 arr[i]가 크면,
                    직전 요소인 arr[stack.pop()]에 arr[i]를 등록한다.
                    또한 해당 i인덱스를 새로운 기준으로 삼아야 하므로 stack에 해당 인덱스를 push한다.


            1) 자신의 오른쪽에서 큰 수를 만나는 경우 오큰 수를 정답배열에 담는다.
                => 인덱스를 순회하며 push하고 정답배열에 오큰 수를 담는다.
            2) 자신의 오른쪽에서 큰 수를 만나지 못하는 경우 -1을 정답배열에 담는다.
                ~~2-1) (x) 현재 요소가 마지막인 경우 -1 출력~~
                ~~2-2) (x) 현재 요소 오른쪽에 자기 자신보다 작은 수밖에 없는경우~~
                => (O) for문을 순회했는데 스택이 비어있지 않다면 스택이 빌 때까지 저장된 인덱스에 -1을 포함한다.
         */

        Stack<Integer> stack = new Stack<>();
        int[] NgeArr = new int[N]; // 오큰수를 저장하는 배열


        stack.push(0); // 스택이 비어있으므로 기준이 될 0번 인덱스를 처음 push한다.

        for(int i=1; i<N; i++) { // i는 1부터 N-1까지 순회한다.
                //스택이 비어있지 않고 오큰수를 발견한다면,
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                //기준이 되는 해당 인덱스를 스택에서 pop하고 그 인덱스 요소에 오큰수 arr[i]를 넣는다.
                NgeArr[stack.pop()] = arr[i];
            }
            // 위 조건을 거르고 난 후 기준이 되는 인덱스를 push하여 변경한다.
            stack.push(i);
        }

        // 오큰 수를 발견하지 못했는데 스택에 인덱스가 남아있으면, 스택에 남아있는 인덱스 기준으로는 오큰수가 없으므로 -1 대입
        while(!stack.isEmpty()) {
            NgeArr[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<NgeArr.length; i++) {
//            System.out.print(NgeArr[i]+ " ");
            bw.write(NgeArr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
