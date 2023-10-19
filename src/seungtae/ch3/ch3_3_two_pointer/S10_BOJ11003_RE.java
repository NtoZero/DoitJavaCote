package seungtae.ch3.ch3_3_two_pointer;

import _problems.ch3_data_structure.ch3_3_two_pointer.P10_11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S10_BOJ11003_RE implements P10_11003 {
    /*
        시간 제한 : 2.6초, 메모리 제한 : 512MB
        수의 개수 : N / 일정 간격 : L , 1 <= L <= N <= 5 *(10^6)
        - 권장 시간 복잡도 : NlogN
        - 주의 사항 :
            1) i<=0인 A의 i번째 요소는 무시한다.
            2) i-L+1 ~ i 의 간격을 유지한다. 슬라이딩 윈도우에 한 번에 포함되는 요소의 개수는 L개이다.
        - 문제 풀이 :
            1) 일정 간격을 유지하며 조건에 부합하는 수를 찾아내야 하므로 '슬라이딩 윈도우'를 사용한다.
            2) i-L+1 <= 0인 수는 OutOfIndex 전에 무시한다. 또한 i의 최대값은 N-1임을 유념한다.
            3) 최대 크기 L을 유지하는 자료구조 'Deque'을 사용한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1]; // 0번 인덱스는 무시한다.
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        // 최소값
        int min = 0;

        // 슬라이딩 윈도우에서 최소값 구하기
        for(int i=1; i<=N; i++) {
            int start = i-L+1;
            int end = i;

            while(start<=0 && min==0) {

            }

            if(deque.size()<=L) {
                deque.addLast(arr[end]);
            } else {
                deque.removeFirst();
                deque.addLast(arr[end]);
            }
        }

        bw.close();
    }
}
