package seungtae.ch3;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10986 : 나머지 합 52p
public class BOJ10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] S = new long[N];

        // (A + B) % C 는 ((A%C) + (B%C)) % C와 같다.
        // 합배열 S에서 각 요소를 M으로 나눈 나머지가 같다면 원 요소에서 두 값을 빼면 M으로 나누어 떨어진다는 것이다.
            // 합배열 S의 두 요소를 빼서 M으로 나누어 떨어지면 연속된 부분 구간 합이 나누어 떨어진다는 것이다.

        for(int i =0; i<N; i++) {
            if(i==0) {
                S[0] = (sc.nextInt())%M;
                continue;
            }
            S[i] = S[i-1]+sc.nextInt(); // 1 3 6 7 9
//            S[i] = S[i]%M; // 1 0 0 1 0
        }
        // 연속된 구간이므로 각 구간 차를 M으로 나눴을 때 개수를 카운팅한다.
        // 다만 N의 모수가 10^6 이므로 이중 for문을 사용할 수 없다.
        // 나머지가 0인 경우 + 나머지가 같은 것 중 2가지를 조합하는 경우를 답으로 제출한다.

        long answer =0; // answer가 int 범위를 넘어설 수 있기 때문에 long이어야 한다.
        // 1) 나머지가 0인 경우
        for(int i=0; i<N; i++) {
            if(S[i]%M==0) answer++;
        }

        // 2) 나머지가 같은 것 중 2가지를 조합하는 경우
            // 2-1) 배열 C는 나머지의 개수를 담는 배열이다. 인덱스는 나머지, 해당 요소 값은 개수가 된다.
        long[] C = new long[M]; // C도 long 배열이어야 한다.
        for(int i=0; i<N; i++) {
            int remainder = (int) (S[i]%M);
            C[remainder]++;
        }
            // 2-2) 나머지 조합 찾기
        for(int i=0; i<M; i++) {
            if(C[i]>1) //나머지가 같은 것이 2개 이상인 경우에만 셈해야 한다.
            answer += (C[i]*(C[i]-1))/(2*1);
        }
        System.out.println(answer);

    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//
//        long[] S = new long[N+1];
//
//        for(int i =1; i<=N; i++) {
//            S[i] = S[i-1]+sc.nextInt(); // 0 1 3 6 7 9
//                                        // 7 - 6 7- 3 7-1
//        }
//
//        // 연속된 구간이므로 각 구간 차를 M으로 나눴을 때 개수를 카운팅한다.
//        // 다만 N의 모수가 10^6 이므로 이중 for문을 사용할 수 없다.
//
//        List<Long> list = new ArrayList();
//        for(int i=S.length-1; i>=1; i--) {  // 9
//            for(int j=i-1; j>=0; j--) {
//                if((S[i]-S[j])%M==0) list.add(S[i]-S[j]);
//            }
//        }
//
//        list.stream().forEach(
//                num -> {
//                    System.out.print(num + " ");
//                }
//        );
//
//        System.out.println();
//
//        System.out.println(list.size());
//    }
}
