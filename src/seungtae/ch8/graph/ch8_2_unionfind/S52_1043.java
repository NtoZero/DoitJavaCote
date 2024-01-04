package seungtae.ch8.graph.ch8_2_unionfind;

import _problems.ch8_graph.P52_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
        알고리즘 : Union Find 연산

        Union Find 연산 :
            여러 노드가 있을 때 특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과
            두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성된 알고리즘
            - union 연산 :
                각 노드가 속한 집합을 1개로 합치는 연산 노드 a, b가 각각 A, B에 속해 있을 때 union(a, b)는 A U B이다.
            - find 연산 :
                특정 노드 a에 관해 a가 속한 집합의 대표 노드를 반환하는 연산. 노드 a가 A에 속할 때 find(a)는 A 집합 대표 노드를 반환.

            union 연산 디테일:
                1. 1차원 배열을 이용한다.
                    처음에는 노드가 연결되어 있지 않으므로 각 노드가 대표 노드가 된다.
                    각 노드가 모두 대표 노드 이므로 배열은 자신의 요소 값을 인덱스 값으로 초기화 한다.
                        예) A[5] => 자식 노드 5의 대표 노드. 초기 값은 연결이 없으므로 그대로 5.
                2. 2개의 노드를 선택해 각각 대표 노드를 찾아 연결하는 union 연산을 수행한다.
                    union(대표 노드, 자식 노드) -> 자식 노드(인덱스)에 대한 대표 노드(요소 값)를 세팅한다.
                        예) union(1, 4) => 자식 노드(4) 집합의 대표 노드를 1로 설정한다.
                            1 2 3 4 5 6
                            1 2 3 1 5 6
                        예) union(5, 6)
                            1 2 3 4 5 6
                            1 2 3 1 5 5
                    자식 노드의 union 연산은 어떻게 할까? => 대표노드로 치환하여 연산한다.
                        예) union(4, 6) -> union(1, 5)
                            1 2 3 4 5 6
                            1 2 3 1 1 5

            find 연산 디테일:
                자신이 속한 집합의 대표 노드를 찾는 연산
                특징
                    1) 대표 노드를 찾을 수 있음
                    2) 그래프를 정돈하고 시간 복잡도를 향상시킴
                작동 원리
                    1. 대상 노드 배열에 index값과 value 값이 동일한지 확인.
                    2. 동일하지 않으면 value값이 가리키는 index 위치로 이동.
                    3. 이동 위치의 index값과 value값이 같을 때까지 1~2 반복. (재귀 함수)
                    4. 대표 노드에 도달하면 재귀 함수를 빠져나오면서 거치는 모든 노드 값을 루트 노드값으로 변경.
                        => 경로 압축을 통해서 향후 시간 복잡도가 O(1)로 향상됨.
                            한 번의 find 연산을 이용해 모든 노드가 루트 노드에 직접 연결되는 형태로 변경됨.
                            * 경로 압축 : 실제 그래프에서 여러 노드를 거쳐야 하는 경로에서 그래프를 변형해 더 짧은 경로로 갈 수 있도록 함으로써
                                        시간 복잡도를 효과적으로 줄이는 방법.
 */

public class S52_1043 implements P52_1043 {
    /*
        문제 분석 : 진실을 아는 사람이 포함 되지 않는 파티의 수 구하기
            - 진실을 아는 사람이 한 번이라도 참여하는 파티의 구성원 역시 진실을 아는 사람이 된다.
        문제 풀이 : Union-Find를 이용하여 집합셋을 구분하자.
     */
    static int[] parent; // union find 배열
    static int[] trueP; // 진실을 아는 사람
    static ArrayList<Integer>[] party; // 각 파티 구성 인원
    static int result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 총 인원 수
        int M = sc.nextInt(); // 파티의 수
        int T = sc.nextInt();
        trueP = new int[T];
        for(int i=0; i<T; i++) {
            trueP[i] = sc.nextInt();
        }
        party = new ArrayList[M];
        for(int i = 0; i < M; i++) { // 파티 값 초기화
            party[i] = new ArrayList<>();
            int partySize = sc.nextInt();
            for(int j=0; j<partySize; j++) {
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[N+1];
        for(int i=0; i<=N; i++) { // 대표 노드 자기 자신
            parent[i] = i;
        }
        for(int i=0; i<M; i++) { // 파티 참여한 사람 동일 그룹화
            int firstPeople = party[i].get(0); // 첫 번째 사람을 기준으로 나머지 사람들 동일 그룹화
            for (int j = 1; j<party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        // 파티 대표노드와 진실 그룹 대표 노드 비교 -> 같으면 거짓말 못함
        for (int i=0; i<M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j=0; j<trueP.length; j++) { // 진실을 아는 사람들
                if (find(cur) == find(trueP[j])) { // 한 사람 이라도 진실을 아는 사람이 있다면
                    isPossible = true;
                    break;
                }
            }
            if (isPossible) result++; // 대표 노드가 다르면 거짓말 가능
        }

        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) // 자기 자신이 부모 노드면
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) {
            return true;
        }
        return false;
    }
}
