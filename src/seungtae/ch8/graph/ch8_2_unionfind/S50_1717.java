package seungtae.ch8.graph.ch8_2_unionfind;

import _problems.ch8_graph.P50_1717;

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

import java.util.*;
import java.io.*;

public class S50_1717 implements P50_1717 {

    /*
        문제 분석 : 1차원 배열에서 합집합 연산과 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산 순행
        문제 풀이 :
            합집합 연산(union), 두 원소가 같은 집합에 포함되어 있는지 확인(find) union-find 알고리즘을 사용한다.

            union 합집합 0 a b => a가 속해있는 집합과 b가 속해있는 집합을 합연산 한다. (대표 노드 통일)
            find 1 a b => 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산 (대표 노드가 같은지 여부 판별)

            시간 복잡도 :
                n<=10^6 , m<=10^5
     */

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 원소 개수
        int m = Integer.parseInt(st.nextToken()); // 연산 횟수

        arr = new int[n+1];
        // 최초에는 합집합이 없다. (인덱스(자식 노드)와 요소 값(대표 노드)가 같다.)
        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op==0) {
                union(a, b);
            } else {
                sb.append(isUnion(a, b));
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b) { // 합연산
        // a, b의 대표 노드 찾기
        int superA = find(a);
        int superB = find(b);

        // 대표 노드가 다르면 b의 대표 노드 값 다시 설정
        if(superA != superB) {
            arr[superB] = superA;
        }

//        System.out.println(Arrays.toString(arr));
    }

    static int find(int k) { // 해당 자식 노드의 대표 노드 찾기
        if(arr[k]==k) return k; // 인덱스와 값이 일치해야 대표 노드
        return arr[k]=find(arr[k]); // 대표노드가 아니라면 대표 노드 찾기 -> 재귀 형태로 경로 압축
    }

    static String isUnion(int a, int b) {
        if(find(a)==find(b)) return "YES\n";
        else return "NO\n";
    }
}

/*
    0 1 2 3 4 5 6 7
    0 1 2 3 4 5 6 7

    union(1, 3)
    0 1 2 3 4 5 6 7
    0 1 2 1 4 5 6 7

    find (1, 7) => 1과 7 대표노드가 다름. "NO"

    union(7, 6)
    0 1 2 3 4 5 6 7
    0 1 2 1 4 5 7 7

    find (7, 1) => 1과 7 대표노드가 다름. "NO"

    union(3, 7)
    0 1 2 3 4 5 6 7
    0 1 2 1 4 5 7 3 (arr[7] -> 3) => arr[3] (1) != 3 이 아니므로 한 번 더 재귀
    0 1 2 1 4 5 7 1 (arr[7] -> arr[3]) => arr[3] (1) == 1 이므로 재귀 끝

    union(4, 2)
    0 1 2 3 4 5 6 7
    0 1 4 1 4 5 7 1 (arr[2] -> arr[4])

    union(1, 1) (a, b가 같은 경우)
    0 1 2 3 4 5 6 7
    0 1 4 1 4 5 7 1 (arr[1] -> arr[1])

    find(1, 1) => a, b의 대표 노드는 같다. (한 집합 안에 속한다.) => "YES"
    0 1 2 3 4 5 6 7
    0 1 4 1 4 5 7 1
 */