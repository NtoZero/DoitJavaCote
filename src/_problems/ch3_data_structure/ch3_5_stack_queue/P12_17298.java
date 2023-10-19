package _problems.ch3_data_structure.ch3_5_stack_queue;

import java.io.*;
import java.util.StringTokenizer;

public interface P12_17298 {
    //    https://www.acmicpc.net/problem/17298
    /*
        시간 복잡도 : 10^6, 메모리 제한 512MB
        크기 N : 10^6, 원소 크기 10^6
        - 사용 가능한 시간 복잡도 : NlogN 이하
        - 오큰수란 자신의 우측에 있는 원소 중 자신보다 큰 수 중 가장 첫 번째에 만나는 수이다.
          단순히 자신의 오른쪽 수를 찾는다면 현재 인덱스보다 +1하여 우측에 있는 수부터 찾아 대소 비교 하면 된다.
          그러나 이중 for문을 사용하게 되므로 최악의 경우(오큰수가 하나도 없는 경우) N^2에 근접 한다. (정확히는 N*(N-1))
          따라서 이중 for문을 사용하지 않아야 한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] scrArr = new int[N];
        int[] NGEs = new int[N];

        // 원본 배열 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            scrArr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
