package seungtae.ch5.ch5_1dfs;

import _problems.ch5_searching.ch5_1_dfs.P24_2023;

import java.io.*;

public class S24_2023 implements P24_2023 {
    /*
        - 문제 요약 : N 자릿수 중 왼쪽 자리 수부터 각 자리 수를 이어붙인 수가 모두 소수인 수 판별하기
            - N : 1 <= N <= 8
              N이 8일 경우 10^8-1 - 10^7의 모든 수를 확인해 보아야 한다. => (10^7)*9의 경우의 수
            - 시간 제한 : 2초 (2 * 10^8)
                => 권장 시간 복잡도 O(N),
                일반적인 소수 판별 메서드의 시간복잡도는 O(sqrt(N))이므로 단순 for문을 돌면서 소수인지 판별할 수는 없다.
                => DFS를 이용한다.
            - tip) 시간 복잡도 줄이기
                1. 첫 자리 수가 소수이어야 함. => 2,3,5,7
                2. 일의 자리가 홀수이어야 함. => 1,3,5,7,9
                3. 중간 탐색 과정에서 소수가 아닌 경우 멈추어야 한다.
     */

    //자릿수
    static int N;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //자릿수
        N = Integer.parseInt(br.readLine()); // 1<=N<=8

        // 첫 자리 수가 소수이어야 하므로 2, 3, 5, 7 에서 시작
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

        bw.close();
    }

    //dfs
    static void dfs(int number, int jarisu) throws IOException {
        if (jarisu == N) { //N 자릿수에 도달하면
            if(isPrime(number)) { // 소수일 때 출력
                bw.write(number+"\n");
            }
            return; //자리수가 N이 되었을 때 출력 및 종료해야 함.
        }
        for (int i=1; i<10; i++) { //1~9 : 우측에 이어붙일 수
            if(i % 2 == 0) { //짝수이면 탐색하지 않는다. (소수x)
                continue;
            }
            if(isPrime(number*10+i)) {
                dfs(number*10+i, jarisu+1);
            }
        }
    }

    // 소수 판별
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 1보다 작거나 같은 수는 소수가 아님
        }
        if (number <= 3) {
            return true; // 2와 3은 소수
        }

        // 2와 3을 제외한 모든 소수는 6k ± 1 형태를 가짐
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        // 6k ± 1 형태의 소수를 검사
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
