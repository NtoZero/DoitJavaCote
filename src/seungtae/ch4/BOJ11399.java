package seungtae.ch4;

//18. ATM 인출 시간 계산하기(11399) : https://www.acmicpc.net/problem/11399

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BOJ11399 {
    /*
        1. 시간 복잡도 : 제한시간(1초) N의 최대값 10^3이므로 N^2 이하의 알고리즘이 권장된다.
        2. 문제 풀이 :
            - 인출 소요 시간이 적은 순으로 정렬 한다.
            - n번 줄에 서는 사람에게 걸리는 소요 시간은 해당 n번째까지의 부분합이다.
            - 이 때, 정렬을 삽입 정렬 알고리즘을 통해 구현해본다.
                - 삽입 정렬이란, 이미 정렬된 범위를 점차 넓혀가면서 특정 위치의 올바른 인덱스를 찾아주는 방식을 말한다.
                - 해당 인덱스의 요소가 삽입됨과 동시에 우측 값들은 밀려나게 된다.
                - 따라서, 배열을 사용할 경우 배열의 복사를 사용해야 할 것이다. -> List 자료구조를 활용해보자.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 총 데이터의 개수
        List<Integer> list = new ArrayList<>(); // 소요 시간 리스트


        for(int i=0; i<N; i++) {
            int k = sc.nextInt();
            list.add(k);
        }
//        list = list.stream().sorted().collect(Collectors.toList()); // 스트림을 이용한 정렬


        //삽입 정렬 구현
        for(int i=1; i<N; i++) { // 두 번째 인덱스(인덱스:1)부터 시작
            int insertValue = list.get(i); // insert는 list의 i번 인덱스 요소 값
            int insertIndex = i;    // 삽입 요소의 인덱스
            for(int j=i-1; j>=0; j--) {
                if(list.get(j)<list.get(i)) { //이미 오름차순이면 (i번째 요소가 j번째 요소보다 크면)
                    insertIndex = j+1; // j인덱스 다음에 삽입
                    break;
                }
                // j번째 요소가 i번째 요소 이상이면서
                if(j == 0) { // j가 0이면
                    insertIndex = 0; // 삽입할 인덱스 위치도 0
                }
            }
            // 방법1) list를 삽입 위치를 비워놓아야 하므로 삽입위치부터의 list를 삽입위치+1부터로 옮기기.
            for(int j = i; j > insertIndex; j--) {
                list.set(j, list.get(j-1));
            }
            list.set(insertIndex, insertValue);

            // 방법2) insert인덱스에 add하는 방법 (직후 원래 위치 요소 삭제)
//            list.add(insertIndex, insertValue); //add로 하면 안되는 이유. 배열의 크기가 유지되지 않음. swap이 아니라 추가가 됨. 원래 insert 위치에 있던 요소를 제거해야함.
//            list.remove(list.get(i)); // 원래 위치 요소 삭제 후, add
            // =>  X 단, 이렇게 하면 마지막 자리에서는 스왑되지 않는다...!

            // 결과 출력해보기
//            list.stream().forEach(num -> System.out.print(num + " "));
//            System.out.println();
        }

        // list가 삽입정렬로 정렬되었으니 부분합리스트를 만든다.
        List<Integer> subSumList = new ArrayList<>(); //구간합 리스트
        int sum = 0; // 구간 합
        subSumList.add(list.get(0)); // 첫 요소 집어넣기
        for(int i=1; i<N; i++) {
            int addNum = subSumList.get(i-1)+list.get(i);
            subSumList.add(addNum);
        }
        // 부분합의 누적합을 구함면 최종적으로 구하고자 하는 값을 구할 수 있다.
        for(int i=0; i<N; i++) {
            sum = sum + subSumList.get(i);
        }
        System.out.println(sum);
    }
}
