package seungtae.ch8.graph.ch8_2_unionfind;

import _problems.ch8_graph.P51_1976;

//여행 가자

import java.io.*;
import java.util.*;

public class S51_1976 implements P51_1976 {
    /*
        문제 분석 : 도시 간 길이 존재하거나 존재하지 않는다.
                    같은 도시를 여러 번 방문하는 것이 가능할 때 여행 계획이 가능한지 여부를 따져 출력.
                    => union-find
                        => 도시가 같은 집합에 속해있다면 (union) 길이 존재한다. (같은 도시 재방문 가능)

        문제 풀이 :
            - 시간 복잡도 : N<=2*10^2 , M<=10^3
            예제)
                3   // N (도시의 수)
                3   // M (여행 계획에 속한 도시들의 수)
                // N개의 줄에는 N개의 정수가 주어짐
                0 1 0 // 1번 도시는 2번 도시와 연결
                1 0 1 // 2번 도시는 1, 3번 도시와 연결
                0 1 0 // 3번 도시는 2번 도시와 연결

                1 2 3 // 마지막 줄 -> 여행 계획 => 1-2-3 연결되어 있으므로 YES 출력
                    => union-find로 경로 단축을 한다면 O(M)의 시간 복잡도로 여행 가능 여부를 알 수 있다.
                        모두 같은 대표 노드를 보유하고 있는지의 여부만 판단하면 되기 때문이다.
                    => 혹은 인접그래프 dfs로도 풀이할 수 있을 것 같다.
     */
    static int[] arr; // 대표 노드를 담을 배열
    static int[][] cities; // 도시간 연결 정보를 담을 배열

    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        // 초기 대표노드는 인덱스=밸류
        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }

        //배열 안받고 바로 시작해도 됨
        cities = new int[N+1][N+1]; // 도시간 연결 정보
        for(int i=1; i<=N; i++) { //N개의 줄
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // union 계산하기
        for(int i=1; i<=N; i++) { // 최대 시간 복잡도 200*200(최대 도시 수) * O(α(n))
            for(int j=1; j<=N; j++) {
                if(cities[i][j]==1) { // 양 도시간 길이 존재하면 union
                    union(i, j);
                }
            }
        }

        // 여행 계획 (M)이 하나의 union인지 체크
        String[] plan = br.readLine().split(" ");
        if(isUnion(plan)) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }

    static void union(int a, int b) { // O(α(n))
        int parentA = find(a);
        int parentB = find(b);

        // 대표 노드 값이 다르면 b 대표 노드값 다시 설정
        if(parentA != parentB)
            arr[parentB] = parentA;
    }

    static int find(int k) {    // O(α(n))
        if(arr[k]==k) return k;
        return arr[k] = find(arr[k]);
    }

    static boolean isUnion(String[] plan) {
        int representative = find(Integer.parseInt(plan[0])); // 대표 노드
        for (int i = 1; i < M; i++) {
            int num = find(Integer.parseInt(plan[i])); // 대표 노드
            if (num != representative) {
                return false;
            }
        }
        return true;
    }
}

